package com.apress.gwt.chapter2.client;

/**
 * Base interface for reading properties from the book.properties file
 * 
 * @gwt.properties.filename book.properties
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface BookPropertiesReader extends PropertiesReader {

  String year();

  /**
   * @gwt.key name
   * @return
   */
  String getBookName();

  String publisher();

  /**
   * @gwt.key author
   * @return
   */
  String getAuthorName();
}