package com.apress.gwt.chapter6.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface BookStoreServiceAsync extends RemoteService {

  public void getBooks(String category, AsyncCallback<List<Book>> callback);

  public void storeOrder(List<Book> books, String userName,
      AsyncCallback<String> callback);

  public void addToCart(List<Book> books, AsyncCallback<List<Book>> callback);
}
