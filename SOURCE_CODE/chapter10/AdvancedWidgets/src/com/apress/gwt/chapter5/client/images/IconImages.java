package com.apress.gwt.chapter5.client.images;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

/**
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public interface IconImages extends ImageBundle {

  @Resource("icon_left.jpg")
  public AbstractImagePrototype getLeftIcon();

  @Resource("icon_top.jpg")
  public AbstractImagePrototype getTopIcon();

  @Resource("icon_right.jpg")
  public AbstractImagePrototype getRightIcon();
}
