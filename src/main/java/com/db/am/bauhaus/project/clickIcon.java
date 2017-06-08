package com.db.am.bauhaus.project;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Objects;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


/**
 * Created by Radhika on 07/06/2017.
 */
public class clickIcon implements Task {

    private String categoryName;

    @Override
    public <T extends Actor> void performAs(T theUser) {
        theUser.should(
                seeThat("The icon with category name", the(SearchTarget.ALL_ICON_CATEGORIES), isVisible())
        );

        List<WebElementFacade> webElementFacades = SearchTarget.ALL_ICON_CATEGORIES.resolveAllFor(theUser);
        WebElementFacade webElementFacade = Search(webElementFacades, categoryName);
        theUser.attemptsTo(Click.on(webElementFacade));
    }

    public static clickIcon With(String categoryName){
        return Instrumented.instanceOf(clickIcon.class).withProperties(categoryName);
    }

    public clickIcon(String categoryName){ this.categoryName = categoryName; }

    private static WebElementFacade Search(List<WebElementFacade> webElementFacadeList, String searchText){
        WebElementFacade result = null;
        for (WebElementFacade webElementFacade: webElementFacadeList){
            if (Objects.equals(webElementFacade.getText(), searchText)){
                result = webElementFacade;
            }
        }

        return result;
    }
}
