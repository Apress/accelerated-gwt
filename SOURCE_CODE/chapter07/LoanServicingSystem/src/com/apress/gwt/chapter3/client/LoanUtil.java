package com.apress.gwt.chapter3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * Wrapper class to encapsulate the creation of service proxy objects. This
 * class also provides wrapper around calls to the service methods.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class LoanUtil {

  private static LoanRequestServiceAsync serviceInstance;

  /**
   * Utility class for simplifying access to the instance of async service.
   */
  public static class Util {

    // JavaScript is a single-threaded language. This method is synchronized even
    // though the synchronized keyword is ignored by the GWT compiler when
    // converting the code to its JavaScript equivalent.
    public synchronized static void initInstance() {
      if (serviceInstance == null) {
        serviceInstance = (LoanRequestServiceAsync) GWT
            .create(LoanRequestService.class);

        ServiceDefTarget target = (ServiceDefTarget) serviceInstance;
        target.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "LoanRequestService");
      }
    }
  }

  static {
    Util.initInstance();
  }

  public static void storeLoanRequest(LoanRequest loanRequest,
      LoanRequestForm loanRequestForm) {
    serviceInstance.storeLoanRequest(loanRequest,
        loanRequestForm.new StoreRequestCallback());
  }
}