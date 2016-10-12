package com.apress.gwt.chapter6.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class BookUtil {

  private static BookStoreServiceAsync serviceInstance;

  /**
   * Utility class for simplifying access to the instance of async service.
   */
  public static class Util {
    public synchronized static void initInstance() {
      if (serviceInstance == null) {
        serviceInstance = (BookStoreServiceAsync) GWT
            .create(BookStoreService.class);
        ServiceDefTarget target = (ServiceDefTarget) serviceInstance;
        target
            .setServiceEntryPoint(GWT.getModuleBaseURL() + "BookStoreService");
      }
    }
  }

  static {
    Util.initInstance();
  }

  public static void getListOfBooks(String category, BookStore bookStore) {
    serviceInstance.getBooks(category, bookStore.new BookListUpdaterCallback());
  }

  public static void storeOrder(List books, String userName, BookStore bookStore) {
    serviceInstance.storeOrder(books, userName,
        bookStore.new StoreOrderCallback());
  }

  public static void addToCart(List books, BookStore bookStore) {
    serviceInstance.addToCart(books, bookStore.new AddToCartCallback());
  }

}