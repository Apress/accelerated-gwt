package com.apress.gwt.chapter6.server;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.apress.gwt.chapter6.client.Book;
import com.apress.gwt.chapter6.client.BookStoreService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class BookStoreServiceImpl extends RemoteServiceServlet
    implements BookStoreService {
  
  private static final String BOOKS_ATTRIBUTE_NAME = "books";

  // We start by creating a list of different books in the bookstore. We just added
  // books in Computer category for our application for demonstration purpose.
  private static ArrayList<Book> booksInStore = new ArrayList<Book>();
  static {
    booksInStore.add(new Book("Java 1", "XYZ", "Computer"));
    booksInStore.add(new Book("Java 2", "ABC", "Computer"));
    booksInStore.add(new Book("GWT 1", "DEF", "Computer"));
    booksInStore.add(new Book("GWT 2", "LMN", "Computer"));
    booksInStore.add(new Book("Alien World", "PQR", "Fiction"));
    booksInStore.add(new Book("Time Travel", "GHI", "Fiction"));
  }

  /**
   * This method just filters out the books of a specified category and returns
   * it back to the client for displaying to the user
   */
  public List<Book> getBooks(String category) {
    ArrayList<Book> books = new ArrayList<Book>();

    for (Book book : booksInStore) {
      if (book.getCategory().equals(category)) {
        books.add(book);
      }
    }
    return books;
  }

  /**
   * This method receives a list of books which were selected by the user. This
   * is the place where an application in production should store the books
   * selected by the user. In our sample application we just compile the list of
   * books selected by the user into a message which can be displayed back to
   * the user.
   */
  @SuppressWarnings("unchecked")
  public String storeOrder(List books, String userName) {
    StringBuilder builder = new StringBuilder();
    builder.append("Order by ");
    builder.append(userName);
    builder.append(" for ");
    for (int i = 0; i < books.size(); i++) {
      Book book = (Book) books.get(i);
      builder.append(book.getName());
      if (i < (books.size() - 1)) {
        builder.append(", ");
      }
    }

    builder.append(" has been successfully recorded.");
    return builder.toString();
  }
  
  @SuppressWarnings("unchecked")
  public List addToCart(List books) {

    HttpServletRequest request = this.getThreadLocalRequest();
    HttpSession session = request.getSession();
    TreeSet<Book> cart = (TreeSet<Book>) session
        .getAttribute(BOOKS_ATTRIBUTE_NAME);
    if (cart == null) {
      cart = new TreeSet<Book>(books);
    }
    cart.addAll(books);
    session.setAttribute(BOOKS_ATTRIBUTE_NAME, cart);
    return new ArrayList(cart);
  }

}
