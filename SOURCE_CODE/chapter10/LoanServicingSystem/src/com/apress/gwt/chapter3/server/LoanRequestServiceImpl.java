package com.apress.gwt.chapter3.server;

import com.apress.gwt.chapter3.client.LoanRequest;
import com.apress.gwt.chapter3.client.LoanRequestService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author Vipul Gupta (vipulg@google.com)
 */
public class LoanRequestServiceImpl extends RemoteServiceServlet
    implements LoanRequestService {

  public boolean storeLoanRequest(LoanRequest loanRequest) {
  
    if (loanRequest == null) {
      return false;
    }
    // You can add the logic for storing the LoanRequest object in any
    // persistence storage like database here
    return true;
  }
}