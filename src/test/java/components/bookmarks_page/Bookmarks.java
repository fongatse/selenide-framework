package components.bookmarks_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Bookmarks {
    private String AUTOMATIC_TAB_XID = "//a[contains(text(), \"Automatic\")]";
    private String MANUAL_TAB_XID = "//a[contains(text(), \"Manual\")]";

    private SelenideElement automaticTab = $(By.xpath(AUTOMATIC_TAB_XID));
    private SelenideElement manualTab = $(By.xpath(MANUAL_TAB_XID));
    private SelenideElement bookmark;
    private SelenideElement deleteBtn;

    public void automaticTab() {
        automaticTab.click();
    }

    public void manualTab() {
        manualTab.click();
    }

    public void assertBookmarkExists(String bookmark) {
        this.bookmark = $(By.xpath("//a[contains(text(),\"" + bookmark + "\")]"));
        this.bookmark.shouldBe(Condition.exist);
    }

    public void deleteBookMark(String bookmark) {
        this.deleteBtn = $(By.xpath("//a[contains(text(),\"" + bookmark + "\")]//preceding::a[1]"));
        this.deleteBtn.click();
        assertBookmarkNotExist(bookmark);

    }

    private void assertBookmarkNotExist(String bookmark) {
        this.bookmark = $(By.xpath("//a[contains(text(),\"" + bookmark + "\")]"));
        this.bookmark.shouldNot(Condition.exist);
    }


}
