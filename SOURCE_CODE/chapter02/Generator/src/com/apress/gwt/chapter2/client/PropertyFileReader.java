package com.apress.gwt.chapter2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class PropertyFileReader implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    BookPropertiesReader reader = (BookPropertiesReader) GWT
        .create(BookPropertiesReader.class);
    RootPanel.get("slot1").add(new Label(reader.year()));
    RootPanel.get("slot1").add(new Label(reader.getBookName()));
    RootPanel.get("slot1").add(new Label(reader.publisher()));
    RootPanel.get("slot1").add(new Label(reader.getAuthorName()));
  }
}
