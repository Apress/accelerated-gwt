package com.apress.gwt.chapter5.client;

import com.apress.gwt.chapter5.client.images.FlowerImages;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point class for the AdvancedWidgets application.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class AdvancedWidgets implements EntryPoint {

  private final Image largeImage = new Image();

  public void onModuleLoad() {

    final FlowerImages flowerImages = (FlowerImages) GWT
        .create(FlowerImages.class);

    largeImage.setStylePrimaryName("gwt-Content");

    final FlexTable table = new FlexTable();
    table.setBorderWidth(2);

    Image thumbnailImage = flowerImages.getPinkThumbnail().createImage();
    table.setWidget(0, 1, thumbnailImage);
    addMouseListeners(thumbnailImage, "pink");

    thumbnailImage = flowerImages.red().createImage();
    table.setWidget(0, 2, thumbnailImage);
    addMouseListeners(thumbnailImage, "red");

    thumbnailImage = flowerImages.yellow().createImage();
    table.setWidget(0, 3, thumbnailImage);
    addMouseListeners(thumbnailImage, "yellow");

    thumbnailImage = flowerImages.white().createImage();
    table.setWidget(0, 4, thumbnailImage);
    addMouseListeners(thumbnailImage, "white");

    RootPanel.get("thumbnails").add(table);
  }

  private void addMouseListeners(final Image thumbnailImage, final String name) {
    thumbnailImage.addMouseListener(new MouseListenerAdapter() {
      public void onMouseEnter(Widget sender) {
        largeImage.setUrl(GWT.getModuleBaseURL() + name + "_large.jpg");
        addContent();
      }

      public void onMouseLeave(Widget sender) {
        removeContent();
      }

    });
  }

  private void removeContent() {
    RootPanel.get("content").remove(largeImage);
  }

  private void addContent() {
    RootPanel.get("content").add(largeImage);
  }
}
