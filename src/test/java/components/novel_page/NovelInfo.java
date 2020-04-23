package components.novel_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Contains elements and methods for the Novel info label
 */
public class NovelInfo {
    private SelenideElement novelNameLabel;

    /**
     * verifies Novel by adding a user specified string to the xpath and seeing if it exists
     *
     * @param novel
     */
    public void verifyNovel(String novel) {
        novelNameLabel = $(By.xpath("//h2[contains(text(),\"" + novel + "\")]"));
        novelNameLabel.should(Condition.exist);
    }
}
