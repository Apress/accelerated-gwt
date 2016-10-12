package com.apress.gwt.chapter3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public class SampleWidgets implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    final Label label = new Label("This is a Label");
    final Button button = new Button("Button");
    final CheckBox checkBox = new CheckBox("Checkbox");
    final RadioButton radioButton = new RadioButton("RadioButton",
        "RadioButton");
    final PushButton pushButton = new PushButton("Push Up", "Push Down");
    final ToggleButton toggleButton = new ToggleButton("Toggle Up",
        "Toggle Down");
    final TextBox textBox = new TextBox();
    final TextArea textArea = new TextArea();
    final PasswordTextBox passwordTextBox = new PasswordTextBox();

    final ListBox listBox = new ListBox();
    listBox.addItem("Item1");
    listBox.addItem("Item2");
    listBox.addItem("Item3");
    listBox.addItem("Item4");

    final RichTextArea richTextArea = new RichTextArea();

    final MenuBar menuBar = new MenuBar();
    menuBar.addItem(new MenuItem("Menu1", new Command() {
      public void execute() {
        Window.alert("Hello");
      }
    }));

    menuBar.addItem(new MenuItem("Menu2", new Command() {
      public void execute() {
        Window.alert("Hello2");
      }
    }));

    final VerticalPanel vPanel = new VerticalPanel();
    vPanel.setSpacing(20);
    vPanel.add(label);
    vPanel.add(button);
    vPanel.add(checkBox);
    vPanel.add(radioButton);
    vPanel.add(pushButton);
    vPanel.add(toggleButton);
    vPanel.add(textBox);
    vPanel.add(textArea);
    vPanel.add(passwordTextBox);
    vPanel.add(listBox);
    // vPanel.add(richTextArea);
    // vPanel.add(menuBar);

    RootPanel.get("widgetDiv").add(vPanel);
  }

  // public void onModuleLoad() {
  // final Label label = new Label("Sample Label");
  // final Button button = new Button("Sample Button");
  // final CheckBox checkBox = new CheckBox("Sample CheckBox");
  // final RadioButton radioButton = new RadioButton("radio", "Sample
  // RadioButton");
  //
  // Panel panel = new HorizontalPanel();
  // RootPanel.get().add(panel);
  //
  // panel.add(label);
  // panel.add(button);
  // panel.add(checkBox);
  // panel.add(radioButton);
  // }
  
  
  // public void onModuleLoad() {
  // final Label label = new Label("Sample Label");
  // final Button button = new Button("Sample Button");
  // final CheckBox checkBox = new CheckBox("Sample CheckBox");
  // final RadioButton radioButton = new RadioButton("radio", "Sample
  // RadioButton");
  //
  // Panel panel = new VerticalPanel();
  // RootPanel.get().add(panel);
  //
  // panel.add(label);
  // panel.add(button);
  // panel.add(checkBox);
  // panel.add(radioButton);
  // }
  
  
  // public void onModuleLoad() {
  // final Button button = new Button("Sample Button");
  // final CheckBox checkBox = new CheckBox("Sample Checkbox");
  // final RadioButton radioButton = new RadioButton("radio", "Sample Radio
  // button");
  //
  // Panel panel = new FlowPanel();
  // RootPanel.get().add(panel);
  //
  // panel.add(button);
  //    panel.add(checkBox);
  //    panel.add(radioButton);
  //  }

}
