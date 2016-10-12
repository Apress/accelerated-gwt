package com.apress.gwt.chapter8.client;

import com.google.gwt.i18n.client.Messages;

/**
 * Interface to represent Greeting Messages in an application
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 * 
 */
public interface GreetingMessages extends Messages {
  /**
   * @param username name of the individual
   * @return a birthday message greeting the individual
   */
  String birthdayMessage(String name);

  /**
   * @param name1 name of one member of the couple
   * @param name2 name of second member of the couple
   * @return aniversary message greeting the couple
   */
  String aniversaryMessage(String name1, String name2);

}
