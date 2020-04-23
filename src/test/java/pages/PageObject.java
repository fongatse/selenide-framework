package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Common class with common methods.
 */
public class PageObject {
    public void selectOptionFromList(ElementsCollection elements, String nameOfOption) {
        for (SelenideElement elem : $$(elements)){
            if (elem.text().equals(nameOfOption)) {
                elem.click();
                break;
            }
        }
    }
}
