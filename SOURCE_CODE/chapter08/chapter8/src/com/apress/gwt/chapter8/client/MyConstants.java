package com.apress.gwt.chapter8.client;

import com.google.gwt.i18n.client.Constants;

/**
 * Interface to represent Constants in an application
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public interface MyConstants extends Constants {
  /**
   * @gwt.key chapterDescription
   * @return the localized name of the book
   */
  String description();

  /**
   * @return the localized name of the chapter
   */
  String chapterName();
}
