package com.apress.gwt.chapter3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * Entry point class for the Loan Servicing System.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public class LoanServicingSystem implements EntryPoint {

  /* This is the entry point method. */
  public void onModuleLoad() {
    final RootPanel rootPanel = RootPanel.get();
    
    TabPanel tabPanel = new TabPanel();
    
    // Create a new tab titled New Loan Request and associate the
    // LoanRequestForm with it.
    tabPanel.add(new LoanRequestForm(), "New Loan Request");
    
    // Add two more tabs with HTML text as place-holders for the UI.
    tabPanel.add(new HTML("ApprovalSystem comes here"), "Approve Loan Requests");
    tabPanel.add(new HTML("Under Construction"), "Accounts Information");
    
    rootPanel.add(tabPanel);
  }
}