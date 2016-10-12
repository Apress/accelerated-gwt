package com.apress.gwt.chapter3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point class for the Loan Servicing System.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public class LoanServicingSystem implements EntryPoint {
  
  /* This is the entry point method. */
  public void onModuleLoad() {
    // Get reference to the RootPanel
    final RootPanel rootPanel = RootPanel.get();

    // Create an instance of the LoanRequestForm and add it to the RootPanel
    rootPanel.add(new LoanRequestForm());
  }
}