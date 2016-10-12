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
   * If the path is unqualified (that is, if it contains no slashes), then it is
   * sought in the package enclosing the image bundle to which the annotation is
   * attached. If the path is qualified, then it is expected that the string can
   * be passed verbatim to ClassLoader.getResource()
   */
  @Resource("pink.jpg")
  public AbstractImagePrototype getPinkThumbnail();

  public AbstractImagePrototype red();

  public AbstractImagePrototype yellow();

  public AbstractImagePrototype white();
}
