package com.apress.gwt.chapter6.client;

import java.io.Serializable;

/**
 * Domain object for capturing details of a book in the system.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class Book implements Serializable {

  String name;
  String author;
  String category;

  public Book() {
  }

  public Book(String name, String author, String category) {
    super();
    this.name = name;
    this.author = author;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

}
