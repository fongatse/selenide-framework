package resources.components.chapter_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Chapter {

    private String BOOKMARK_BTN_LOCATOR = "#bookmark-chapter";
    private String CHAPTER_NAME_XID = "//div[@class = \"caption clearfix\"]//h4";

    private SelenideElement bookmarkBtn = $(BOOKMARK_BTN_LOCATOR);
    private SelenideElement chapterName = $(By.xpath(CHAPTER_NAME_XID));


    public void bookmarkChapter(){
        bookmarkBtn.click();
    }

    public String getChapterName(){
        return chapterName.text();
    }
}
