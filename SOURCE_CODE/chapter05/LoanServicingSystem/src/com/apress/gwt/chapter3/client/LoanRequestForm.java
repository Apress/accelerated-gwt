package com.apress.gwt.chapter3.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * This class represents the form for taking inputs of a Loan request.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public class LoanRequestForm extends Composite {

  private final Label contactNameLabel;
  private final Label organizationLabel;
  private final Label addressLabel;
  private final Label amountLabel;
  private final Label loanType;
  private final Button submitDetailsButton;
  private final TextBox contactNameTextBox;
  private final TextBox organizationNameTextBox;
  private final TextBox addressTextBox;
  private final TextBox loanAmountTextBox;
  private final Label savedLabel;
  private final ListBox typeOfLoan;

  public LoanRequestForm() {

    // The input widgets will be stacked from top to bottom, so a vertical panel
    // is created and used as the base panel of the composite object.
    final VerticalPanel loanFormMainPanel = new VerticalPanel();

    // Each input elements requires a label and input field. These should be
    // displayed together from left to right. So, a horizontal panel needs to be
    // created for each input
    final HorizontalPanel hPanelItem1 = new HorizontalPanel();

    loanFormMainPanel.add(hPanelItem1);
    hPanelItem1.setStyleName("loanForm-Panel");

    contactNameLabel = new Label("Contact Name");
    hPanelItem1.add(contactNameLabel);

    contactNameTextBox = new TextBox();
    hPanelItem1.add(contactNameTextBox);
    contactNameTextBox.setFocus(true);

    // Each Input widget is added with a corresponding Label describing the
    // required input. The widget and corresponding label are added using
    // HorizontalPanel so that they can align horizontally to each other.
    final HorizontalPanel hPanelItem2 = new HorizontalPanel();
    loanFormMainPanel.add(hPanelItem2);
    hPanelItem2.setStyleName("loanForm-Panel");

    organizationLabel = new Label("Organization");
    hPanelItem2.add(organizationLabel);

    organizationNameTextBox = new TextBox();
    hPanelItem2.add(organizationNameTextBox);

    final HorizontalPanel hPanelItem3 = new HorizontalPanel();
    loanFormMainPanel.add(hPanelItem3);
    hPanelItem3.setStyleName("loanForm-Panel");

    addressLabel = new Label("Address");
    hPanelItem3.add(addressLabel);

    addressTextBox = new TextBox();
    hPanelItem3.add(addressTextBox);

    final HorizontalPanel hPanelItem4 = new HorizontalPanel();
    loanFormMainPanel.add(hPanelItem4);
    hPanelItem4.setStyleName("loanForm-Panel");

    amountLabel = new Label("Amount of Loan");
    hPanelItem4.add(amountLabel);

    loanAmountTextBox = new TextBox();
    hPanelItem4.add(loanAmountTextBox);

    final HorizontalPanel hPanelItem5 = new HorizontalPanel();
    loanFormMainPanel.add(hPanelItem5);
    hPanelItem5.setStyleName("loanForm-Panel");

    loanType = new Label("Loan Type");
    hPanelItem5.add(loanType);

    // Create a new list box with the various types of loans a customer
    // can make request for
    typeOfLoan = new ListBox();
    typeOfLoan.addItem("Home Loan");
    typeOfLoan.addItem("Personal Loan");
    typeOfLoan.addItem("Auto Loan");
    typeOfLoan.addItem("Business installment Loan");
    typeOfLoan.addItem("Equipment Loan");

    // The visible element count is set as 1, so that the list box behaves
    // like a drop-down menu.
    typeOfLoan.setVisibleItemCount(1);
    hPanelItem5.add(typeOfLoan);

    final HorizontalPanel hPanelItem6 = new HorizontalPanel();
    loanFormMainPanel.add(hPanelItem6);
    hPanelItem6.setStyleName("loanForm-Panel");

    submitDetailsButton = new Button();
    hPanelItem6.add(submitDetailsButton);

    submitDetailsButton.setText("Submit Details");
    submitDetailsButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        submitLoanRequest();
      }
    });

    // Create a hidden label that will be shown the user of the
    // system when the loan is stored on the server.
    // successfully stored on server side.
    savedLabel = new Label("Loan request recorded successfully");
    savedLabel.setVisible(false);
    hPanelItem6.add(savedLabel);

    // The initWidget(...) method is called with the base element of the
    // composite.
    // The base element that contains all other elements is the vertical
    // panel you created in the beginning of this constructor.
    initWidget(loanFormMainPanel);
  }

  protected void submitLoanRequest() {
    // We will add logic in this method later.
  }
  
  Label getAddressLabel() {
    return addressLabel;
  }

  public Label getContactNameLabel() {
    return contactNameLabel;
  }

  public Label getSavedLabel() {
    return savedLabel;
  }

  public Button getSubmitDetailsButton() {
    return submitDetailsButton;
  }

  public Label getOrganizationLabel() {
    return organizationLabel;
  }

  public Label getAmountLabel() {
    return amountLabel;
  }

  public Label getLoanType() {
    return loanType;
  }

  public TextBox getContactNameTextBox() {
    return contactNameTextBox;
  }

  public TextBox getOrganizationNameTextBox() {
    return organizationNameTextBox;
  }

  public TextBox getAddressTextBox() {
    return addressTextBox;
  }

  public TextBox getLoanAmountTextBox() {
    return loanAmountTextBox;
  }

  public ListBox getTypeOfLoan() {
    return typeOfLoan;
  }
}
