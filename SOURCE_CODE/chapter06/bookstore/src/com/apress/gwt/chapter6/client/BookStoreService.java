package com.apress.gwt.chapter6.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface BookStoreService extends RemoteService {

  /**
   * The annotation indicates that the returned List will only contain objects
   * of type <com.apress.gwt.chapter3.client.LoanRequest>
   * 
   * @gwt.typeArgs <com.apress.gwt.chapter6.client.Book>
   */
  public List getBooks(String category);

  /**
   * The annotation specifies that the parameter named 'books' is a List that
   * will only contain com.apress.gwt.chapter6.client.Book objects.
   * 
   * @gwt.typeArgs books <com.apress.gwt.chapter6.client.Book>
   * 
   */
  public String storeOrder(List books, String userName);
}
