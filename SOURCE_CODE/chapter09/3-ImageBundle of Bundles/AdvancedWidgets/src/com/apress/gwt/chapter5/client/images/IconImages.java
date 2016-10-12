package com.apress.gwt.chapter5.client.images;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface IconImages extends ImageBundle {

  /**
   * @gwt.resource icon_left.jpg
   */
  public AbstractImagePrototype getLeftIcon();

  /**
   * @gwt.resource icon_top.jpg
   */
  public AbstractImagePrototype getTopIcon();

  /**
   * @gwt.resource icon_right.jpg
   */
  public AbstractImagePrototype getRightIcon();
}
