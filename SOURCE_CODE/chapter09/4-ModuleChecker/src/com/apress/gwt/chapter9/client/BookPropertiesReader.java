package com.apress.gwt.chapter9.client;

import com.apress.gwt.chapter2.client.PropertiesReader;

/**
 * @gwt.properties.filename book.properties 
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
