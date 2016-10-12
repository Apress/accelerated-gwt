package com.apress.gwt.chapter3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class TestLoanService extends GWTTestCase {

  public String getModuleName() {
    return "com.apress.gwt.chapter3.LoanServicingSystem";
  }

  public void testAddressLabelStyle() {

    // Create an instance of the loan request form.
    final LoanRequestForm loanRequestForm = new LoanRequestForm();

    // Assert the style of the address label
    assertEquals("gwt-Label", loanRequestForm.getAddressLabel().getStyleName());
  }

  public void testUsingTimer() {

    // (1) Setup an asynchronous event handler and call an asynchronous
    // method directly or indirectly.
    final LoanRequestForm loanRequestForm = new LoanRequestForm();
    LoanUtil.storeLoanRequest(new LoanRequest(), loanRequestForm);
    // new LoanUtil(loanRequestForm).storeLoanRequest(new LoanRequest());

    // (2)
    Timer timer = new Timer() {
      public void run() {

        // (3) Validations and Assertions related code comes here
        assertEquals(Boolean.TRUE.booleanValue(), loanRequestForm
            .getSavedLabel().isVisible());

        finishTest(); // (4) Brings the test out of asynchronous mode and the
        // test succeeds.
      }
    };

    delayTestFinish(2000); // (5) Set a long enough delay period for the
    // asynchronous event handling at server side to complete

    timer.schedule(100);
    // (6) Schedule the event and return control to JUnit runtime.
  }

  public void testStoreLoanRequest() throws Exception {
    final LoanRequestServiceAsync loanRequestService = 
      (LoanRequestServiceAsync) GWT.create(LoanRequestService.class);

    ServiceDefTarget endPoint = (ServiceDefTarget) loanRequestService;
    endPoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "LoanRequestService");
    
    AsyncCallback callback = new AsyncCallback() {
      public void onSuccess(Object result) {
        assertEquals(Boolean.TRUE, result);
        finishTest();
      }

      public void onFailure(Throwable caught) {
        fail();
      }
    };

    delayTestFinish(2000);
    loanRequestService.storeLoanRequest(new LoanRequest(), callback);
  }
}
