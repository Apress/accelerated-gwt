package com.apress.gwt.news.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry-point class for the news client application displays a news entry every
 * two seconds on the browser window.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class NewsClient implements EntryPoint {

  private final String[] newsEntries = new String[]{"News Entry 1",
      "Another News Entry", "Yet another news entry", "One Final news Entry"};

  public void onModuleLoad() {
    final Label label = new Label();
    // Create a new timer that keeps changing the news text
    Timer t = new Timer() {
      public void run() {
        label.setText(getNewsEntry());
      }
    };
    // Schedule the timer to run every two seconds.
    t.scheduleRepeating(2000);
    RootPanel.get("newsEntryDivId").add(label);
  }

  private String getNewsEntry() {
    return newsEntries[Random.nextInt(newsEntries.length)];
  }
}
