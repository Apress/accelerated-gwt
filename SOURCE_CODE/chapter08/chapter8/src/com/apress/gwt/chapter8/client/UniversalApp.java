package com.apress.gwt.chapter8.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry-point class for the UniversalApp application
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com) *
 */
public class UniversalApp implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final UniversalAppConstants appConstants = (UniversalAppConstants) GWT
        .create(UniversalAppConstants.class);
    final Button button = new Button(appConstants.GreetingButtonText());
    final Label label = new Label();

    button.addClickListener(new ClickListener() {
      boolean toggleLabel = true;

      public void onClick(Widget sender) {
        if (toggleLabel) {
          label.setText(appConstants.GreetingMessage());
          toggleLabel = false;
        } else {
          label.setText("");
          toggleLabel = true;
        }
      }
    });
    RootPanel.get("slot1").add(button);
    RootPanel.get("slot2").add(label);
  }

  
  // /**
  // * This is the entry-point method.
  // */
  // public void onModuleLoad() {
  // MyConstants myConstants = (MyConstants) GWT.create(MyConstants.class);
  // String chapterDescription = myConstants.description();
  // String chapterName = myConstants.chapterName();
  // RootPanel.get("slot1").add(new Button(chapterDescription));
  // RootPanel.get("slot2").add(new Label(chapterName));
  // }

  
  
  // public void onModuleLoad() {
  // GreetingMessages messages = (GreetingMessages) GWT
  // .create(GreetingMessages.class);
  //
  // Label birthdayLabel = new Label(messages.birthdayMessage("Apress"));
  // // Greet birthday to a user
  // RootPanel.get("slot1").add(birthdayLabel);
  //
  // Label aniversaryLabel = new Label(messages.aniversaryMessage("Vipul",
  // "Ria"));
  // // Greet aniversary to a couple
  //    RootPanel.get("slot1").add(aniversaryLabel);
  //
  //  }
}