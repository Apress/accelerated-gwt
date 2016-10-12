package com.apress.gwt.chapter6.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface BookStoreService extends RemoteService {

  public List<Book> getBooks(String category);

  public String storeOrder(List<Book> books, String userName);

  public List<Book> addToCart(List<Book> books);
}
