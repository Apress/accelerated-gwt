package com.apress.gwt.chapter4.server;

import java.util.Random;

import com.apress.gwt.chapter4.client.NewsFeedService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Server side implementaion of the NewsFeedService interface.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public class NewsFeedServer extends RemoteServiceServlet
    implements
      NewsFeedService {

  private static final long serialVersionUID = 1L;

  private static final Random random = new Random();

  public String[] newsFeeds = {"Feed1", "Feed2", "Feed3"};

  public String getNews() {
    return newsFeeds[random.nextInt(newsFeeds.length)];
  }
}