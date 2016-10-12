package com.apress.gwt.chapter3.client;

import java.io.Serializable;

/**
 * Domain object for capturing details of a loan request in the system.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class LoanRequest implements Serializable {

  private String contactName;
  private String organizationName;
  private String address;
  private long loanAmount;
  private String typeOfLoan;

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public long getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(long loanAmount) {
    this.loanAmount = loanAmount;
  }

  public String getTypeOfLoan() {
    return typeOfLoan;
  }

  public void setTypeOfLoan(String typeOfLoan) {
    this.typeOfLoan = typeOfLoan;
  }
}
