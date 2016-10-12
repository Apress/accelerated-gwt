package com.apress.gwt.chapter3.client;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Service interface for the LoanServicingSystem application.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface LoanRequestService extends RemoteService {

  public boolean storeLoanRequest(LoanRequest loanRequest);
}
