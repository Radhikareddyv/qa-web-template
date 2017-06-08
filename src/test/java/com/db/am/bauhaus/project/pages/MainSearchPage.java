package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".btn.btn-orange.btn-append")
    WebElementFacade searchButton;

    @FindBy(id = "catnav-primary-link-2938-link")
    WebElementFacade clothingAndAccessories;

    @FindBy(id = "category-nav-side-nav-3090-link")
    WebElementFacade clothingAndAccessoriesSubNav;


    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public void clickOnClothingAndAccessoriesLink(){
        clothingAndAccessories.click();
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector("h4.pb-xs-1-5")).getText();
    }

    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.conform-heading.display-inline")).getText();
    }

    public AccessoriesPage clickAccessories() {
        clothingAndAccessoriesSubNav.click();
        return switchToPage(AccessoriesPage.class);
    }
}
