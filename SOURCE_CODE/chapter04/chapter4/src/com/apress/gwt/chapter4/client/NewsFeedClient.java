package com.apress.gwt.chapter4.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point class for the News Feed application
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public class NewsFeedClient implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    final Button button = new Button("Get News Feed");
    final Label label = new Label();

    button.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {

        NewsFeedServiceAsync newsService = (NewsFeedServiceAsync) GWT
            .create(NewsFeedService.class);

        // Specify the URL at which our service implementation is running.
        // Note that the target URL must reside on the same domain and port from
        // which the host page was served.
        ServiceDefTarget endpoint = (ServiceDefTarget) newsService;
        String moduleRelativeURL = GWT.getModuleBaseURL() + "News";
        endpoint.setServiceEntryPoint(moduleRelativeURL);

        // Create an asynchronous callback to handle the result.
        AsyncCallback callback = new AsyncCallback() {
          public void onSuccess(Object result) {
            // do some UI stuff to show success
            label.setText((String) result);
          }

          public void onFailure(Throwable caught) {
            // do some UI stuff to show failure
            label.setText("Error in getting news feed");
          }
        };
        newsService.getNews(callback);
      }
    });

    // Assume that the host HTML has elements defined whose
    // IDs are "slot1", "slot2". In a real app, you probably would not want
    // to hard-code IDs. Instead, you could, for example, search for all
    // elements with a particular CSS class and replace them with widgets.
    RootPanel.get("slot1").add(button);
    RootPanel.get("slot2").add(label);
  }
}
