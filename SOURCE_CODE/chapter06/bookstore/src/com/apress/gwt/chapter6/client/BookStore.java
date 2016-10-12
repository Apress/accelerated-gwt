package com.apress.gwt.chapter6.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Vipul Gupta ( vipulgupta.vg@gmail.com )
 */
public class BookStore implements EntryPoint, ClickListener {

  private DeckPanel mainPanel;
  private VerticalPanel booksPanel;
  private ArrayList booksBeingDisplayed;
  private FlexTable table;

  // We have assumed a standard username for our application. In a production
  // environment this would be assigned based on the logged in user.
  private String userName = "VG";

  private int CATEGORY_PANEL_INDEX = 0;
  private int BOOKS_PANEL_INDEX = 1;

  /**
   * Create a DeckPanel with CategoryPanel and Books display panel. Then show
   * the category panel when the application is started.
   */
  public void onModuleLoad() {
    mainPanel = new DeckPanel();
    booksPanel = new VerticalPanel();
    booksBeingDisplayed = new ArrayList();
    table = new FlexTable();

    mainPanel.add(createCategoryPanel());
    mainPanel.add(booksPanel);

    mainPanel.showWidget(CATEGORY_PANEL_INDEX);

    RootPanel.get("slot1").add(mainPanel);
  }

  /**
   * Create the category panel and add the various categories to it.
   */
  private Panel createCategoryPanel() {
    VerticalPanel categoryPanel = new VerticalPanel();
    Label categoryHeading = new Label("Books Categories");
    categoryHeading.addStyleName("heading");

    Grid grid = new Grid(5, 1);
    grid.setWidget(0, 0, categoryHeading);
    grid.setWidget(1, 0, addCategories("Computer"));
    grid.setWidget(2, 0, addCategories("Fiction"));
    grid.setWidget(3, 0, addCategories("Horror"));
    grid.setWidget(4, 0, addCategories("Romance"));

    categoryPanel.add(grid);
    return categoryPanel;
  }

  /**
   * Utility method to a add a category label having a click listener registered
   * to it.
   */
  private Widget addCategories(final String categoryName) {

    Label categoryLabel = new Label(categoryName);
    categoryLabel.addClickListener(new ClickListener() {

      public void onClick(Widget sender) {
        createBooksPanel(categoryName);
      }
    });
    return categoryLabel;
  }

  /**
   * Utility method to create the books panel. The method first removes the
   * existing books panel from the deck and then creates a new panel and adds
   * and shows the same. The method calls the helper getBooks(...) method to
   * retrieve the books belonging to a specified category.
   */
  private void createBooksPanel(String categoryName) {
    mainPanel.remove(booksPanel);
    booksPanel = new VerticalPanel();
    table = new FlexTable();

    mainPanel.add(booksPanel);
    mainPanel.showWidget(BOOKS_PANEL_INDEX);

    Label bookCategoryHeading = new Label(categoryName + " Books");
    bookCategoryHeading.addStyleName("book-category-heading");
    booksPanel.add(bookCategoryHeading);

    getBooks(categoryName);
  }

  /**
   * The getBooks() method just makes a call to the wrapper getListOfBooks(...)
   * method in the BookUtil class. The getListOfBooks(...) method internally
   * makes the actual RPC call to the server.
   */
  private void getBooks(String categoryName) {
    BookUtil.getListOfBooks(categoryName, this);
  }

  /**
   * Asynchronous callback object class to handle the servers response to
   * getBooks(...) method call.
   */
  public class BookListUpdaterCallback implements AsyncCallback {

    public void onFailure(Throwable caught) {
      GWT.log("Error in retrieving books list.", caught);
      Window.alert("Error in retrieving books list. Try again later.");
    }

    public void onSuccess(Object result) {
      booksBeingDisplayed = (ArrayList) result;
      displayBooks((ArrayList) result);
    }
  }

  /**
   * Asynchronous callback object class to handle the servers response to
   * storeOrder (...) method call.
   */
  public class StoreOrderCallback implements AsyncCallback {
    public void onFailure(Throwable caught) {
      GWT.log("Error in storing order.", caught);
      Window.alert("Error in storing order. Try again later.");
    }

    public void onSuccess(Object result) {
      showSuccessMessage((String) result);
    }
  }

  /*
   * Implementation of ClickListeners onClick(...) method to handle the button
   * click event. We just accumulate the list of all books selected by the user
   * and send the same to the server to store it accordingly.
   */
  public void onClick(Widget sender) {
    ArrayList selectedList = new ArrayList();
    for (int i = 0; i < booksBeingDisplayed.size(); i++) {
      if (((CheckBox) table.getWidget(i + 1, 0)).isChecked()) {
        selectedList.add(booksBeingDisplayed.get(i));
      }
    }
    BookUtil.storeOrder(selectedList, userName, this);
  }

  /**
   * Utility method to display the list of books returned by the server and
   * belonging to a specific category to the user.
   */
  private void displayBooks(ArrayList booksList) {
    Label nameHeading = new Label("Name");
    Label authorHeading = new Label("Author");

    nameHeading.addStyleName("heading");
    authorHeading.addStyleName("heading");

    int rowNum = 0;

    table.setWidget(rowNum, 1, nameHeading);
    table.setWidget(rowNum, 2, authorHeading);

    Book book = null;
    Label name = null;
    Label author = null;
    CheckBox selectBook = null;

    for (int i = 0; i < booksList.size(); i++) {
      rowNum++;
      book = (Book) booksList.get(i);
      name = new Label(book.getName());
      author = new Label(book.getAuthor());
      selectBook = new CheckBox();
      table.setWidget(rowNum, 0, selectBook);
      table.setWidget(rowNum, 1, name);
      table.setWidget(rowNum, 2, author);
    }

    Button button = new Button("Order books");
    button.addClickListener(this);

    table.getFlexCellFormatter().setColSpan(++rowNum, 0, 2);
    table.setWidget(rowNum, 0, button);
    booksPanel.add(table);
  }

  /**
   * Simple utility method to display a message as an alert to the user. In the
   * BookStore application we use this method to show the message returned by
   * the server and affirming the confirmation of books ordered by the user.
   */
  private void showSuccessMessage(String message) {
    Window.alert("[Server] : " + message);
  }
}
