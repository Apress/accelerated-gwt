package com.apress.gwt.chapter5.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Form for a Resume upload service.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class ResumeUploadForm implements EntryPoint {

  public void onModuleLoad() {

    // We start by creating a Create a FormPanel
    final FormPanel resumeForm = new FormPanel();

    // Map the form panel to a service
    resumeForm.setAction("/resumeUpload");

    // FileUpload widget requires multipart MIME encoding
    resumeForm.setEncoding(FormPanel.ENCODING_MULTIPART);

    // FileUpload widget requires the form to use POST method.
    resumeForm.setMethod(FormPanel.METHOD_POST);

    // Create a vertical panel to put all the widgets in the form vertically.
    VerticalPanel verticalPanel = new VerticalPanel();
    resumeForm.setWidget(verticalPanel);

    // Create a text box to take users email as input
    final TextBox emailAddress = new TextBox();
    emailAddress.setText("Enter Your email address");
    emailAddress.selectAll();
    emailAddress.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        emailAddress.setText("");
      }
    });
    verticalPanel.add(emailAddress);

    // Create a FileUpload widget.
    FileUpload upload = new FileUpload();
    upload.setName("resume");
    verticalPanel.add(upload);

    // Create a button to submit the form.
    Button submitButton = new Button("Submit Form");
    submitButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        resumeForm.submit();
      }
    });
    verticalPanel.add(submitButton);

    /**
     * Create a class to handle the form submission events
     */
    final class ResumeFormHandler implements FormHandler {
      // This method is called just before the form is submitted.
      // It can be used to do validations on the data before submission
      public void onSubmit(FormSubmitEvent event) {
        if (emailAddress.getText().length() == 0) {
          Window.alert("Please enter your name");
          event.setCancelled(true);
        }
      }

      // This method is called when the form is successfully completed
      // and the result is returned from the server.
      public void onSubmitComplete(FormSubmitCompleteEvent event) {
        if (event.getResults().equals("OK")) {
          Window.alert("Resume Successfully uploaded");
        } else {
          Window.alert("Error in uploading your resume");
        }
      }
    };

    // Add an event handler to the form.
    resumeForm.addFormHandler(new ResumeFormHandler());

    RootPanel.get().add(resumeForm);
  }
}