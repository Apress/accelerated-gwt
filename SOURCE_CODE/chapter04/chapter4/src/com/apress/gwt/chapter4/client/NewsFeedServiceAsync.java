package com.apress.gwt.chapter4.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Async interface corresponding to Service (NewsFeedService) interface
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public interface NewsFeedServiceAsync {
  public void getNews(AsyncCallback callback);
}