package com.apress.gwt.chapter4.client;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Service interface for the News feed application
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public interface NewsFeedService extends RemoteService {
  public String getNews();
}