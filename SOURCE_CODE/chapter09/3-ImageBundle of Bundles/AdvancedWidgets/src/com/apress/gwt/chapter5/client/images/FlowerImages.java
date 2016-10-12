package com.apress.gwt.chapter5.client.images;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

/**
 * Interface representing the ImageBundle for the AdvancedWidgets application.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface FlowerImages extends ImageBundle {

  /**
   * The metadata tag contains no '/' characters, so pink.jpg must be located in
   * the same package as FlowerImages.
   * 
   * @gwt.resource pink.jpg
   */
  public AbstractImagePrototype getPinkThumbnail();

  public AbstractImagePrototype red();

  public AbstractImagePrototype yellow();

  public AbstractImagePrototype white();
}
