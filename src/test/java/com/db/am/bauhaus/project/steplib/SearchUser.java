package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.AccessoriesPage;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;
    AccessoriesPage accessoriesPage;

    String searchText = "craft";

    @Step
    public void search_from_input_box() {
        mainSearchPage.searchFromInputBox(searchText);
    }

    @Step
    public void verify_result_for_top_categories() {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void verify_result_for_all_categories() {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void clicks_on_clothing_and_accessories(){
        mainSearchPage.clickOnClothingAndAccessoriesLink();
    }

    @Step
    public void clicks_accessories() {
        mainSearchPage.clickAccessories();
    }

    public void verify_accessories_page() {
        assertThat(accessoriesPage.getTitle(), containsString("Accessories"));
    }
}
