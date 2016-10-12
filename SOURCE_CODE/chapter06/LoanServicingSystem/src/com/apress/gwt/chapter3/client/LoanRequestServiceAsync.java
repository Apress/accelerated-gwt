package com.apress.gwt.chapter3.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Async Service interface for the LoanServicingSystem application.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface LoanRequestServiceAsync {

  public void storeLoanRequest(LoanRequest loanRequest, AsyncCallback callback);
}
