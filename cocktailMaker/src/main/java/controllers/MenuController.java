package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import org.apache.derby.iapi.store.raw.Page;
import server.PageNavigator;
import server.session.SessionManager;

/**
 * Created by B06514A on 6/18/2017.
 */
public class MenuController {

    @FXML
    public MenuItem logoff_item;
    @FXML
    public MenuItem pumps_item;

    @FXML
    public MenuItem ingredients_item;

    @FXML
    public MenuItem users_item;

    @FXML
    public MenuItem log_item;

    @FXML
    public MenuItem cocktailGroup_item;

    @FXML
    public MenuItem cocktail_item;

    public void initialize() {

        configureNavigation(pumps_item, PageNavigator.PAGE_CONFIGURE_PUMPS);
        configureNavigation(ingredients_item, PageNavigator.PAGE_CONFIGURE_INGREDIENTS);
        configureNavigation(users_item, PageNavigator.PAGE_CONFIGURE_USERS);
        configureNavigation(log_item, PageNavigator.PAGE_LOG);
        configureNavigation(cocktailGroup_item, PageNavigator.PAGE_CONFIGURE_COCKTAIL_GROUPS);
        configureNavigation(cocktail_item, PageNavigator.PAGE_CONFIGURE_COCKTAILS);

        logoff_item.addEventHandler(ActionEvent.ACTION, event -> {
            SessionManager.sessionInvalidate();
            PageNavigator.navigateTo(PageNavigator.PAGE_LOGIN);
        });

    }

    private void configureNavigation(MenuItem menuItem, String page) {
        menuItem.addEventHandler(ActionEvent.ACTION, event -> {
            PageNavigator.navigateTo(page);
        });
    }

}
