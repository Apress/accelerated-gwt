package com.apress.gwt.chapter3.client;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class TestLoanServicingSystem extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.apress.gwt.chapter3.LoanServicingSystem";
  }

  /**
   * Add as many tests as you like.
   */
  public void testSimple() {
  }

  /**
   * Test case to validate the Loan Request Form.
   */
  public void testLoanRequestForm() {

    // Create an instance of the loan request form.
    final LoanRequestForm loanRequestForm = new LoanRequestForm();

    // Assert the name of the contact label
    assertEquals("Contact Name", loanRequestForm.getContactNameLabel()
        .getText());

    // Assert the style of the contact label
    assertEquals("gwt-Label", loanRequestForm.getContactNameLabel()
        .getStyleName());

    // Assert the name of the submit details button
    assertEquals("Submit Details", loanRequestForm.getSubmitDetailsButton()
        .getText());
  }
}
