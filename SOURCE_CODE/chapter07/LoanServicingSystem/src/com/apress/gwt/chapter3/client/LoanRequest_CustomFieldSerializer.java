package com.apress.gwt.chapter3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class LoanRequest_CustomFieldSerializer {

  public static LoanRequest instantiate(SerializationStreamReader reader)
      throws SerializationException {
    return new LoanRequest();
  }

  public static void serialize(SerializationStreamWriter writer,
      LoanRequest instance) throws SerializationException {
    if (instance == null)
      throw new NullPointerException("LoanRequest object is null");

    writer.writeString(instance.getContactName());
    writer.writeString(instance.getOrganizationName());
    writer.writeString(instance.getAddress());
    writer.writeLong(instance.getLoanAmount());
    writer.writeString(instance.getTypeOfLoan());
  }

  public static void deserialize(SerializationStreamReader reader,
      LoanRequest instance) throws SerializationException {
    if (instance == null)
      throw new NullPointerException("LoanRequest object is null");

    instance.setContactName(reader.readString());
    instance.setOrganizationName(reader.readString());
    instance.setAddress(reader.readString());
    instance.setLoanAmount(reader.readLong());
    instance.setTypeOfLoan(reader.readString());
  }

  /**
   * From book: Listing 6-26.  Method Demonstrating the Use of RequestBuilder
   * Object to Make a Call to the approveLoan Service Registered as a 
   * CGI/PHP Script on the Web Server hosting the Application
   */ 
  private void approveLoan(int requestId, String status) {

    // Create the parameters that you want to add to the request. The parameters
    // should be encoded so that any special characters like blanks and
    // special symbols can be part of the URL string.
    StringBuffer params = new StringBuffer();
    params.append("id=");
    params.append(URL.encodeComponent(String.valueOf(requestId)));
    params.append("&");
    params.append("status=");
    params.append(URL.encodeComponent(status));

    // Create the RequestBuilder object appending the parameters created
    // earlier to the URL string as well.
    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, GWT
        .getModuleBaseURL()
        + "approveLoan?" + params.toString());

    try {
      // A request is then created and a callback is passed to handle the
      // response from server
      Request request = builder.sendRequest(null, new RequestCallback() {

        public void onError(Request request, Throwable exception) {
        }

        public void onResponseReceived(Request request, Response response) {
          if (response.getStatusCode() == 200) {
            Window.alert(response.getText());
          } else if (response.getStatusCode() == 404) {
            Window
                .alert("Loan Approval service not available. Try again later.");
          } else {
            GWT.log("The request returned an error", null);
          }
        }
      });
    } catch (RequestException requestException) {
      GWT.log("Error ", requestException);
    }
  }
}
