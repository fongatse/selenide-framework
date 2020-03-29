package resources.components.novel_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class ChaptersTab {
    Random random = new Random();

    private String CHAPTERS_TAB_LOCATOR = "#content-container > div.section > div > div > div.novel-bottom.p-15 > div.tabbable.light > ul > li:nth-child(2) > a";
    private int randNumber = random.nextInt(5);

    private SelenideElement chaptersTab = $(CHAPTERS_TAB_LOCATOR);
    private SelenideElement chapter;

    private void chaptersTab(){
        chaptersTab.click();
    }

    public void clickRandomChapter(){
        chaptersTab();
        chapter = $(By.xpath("//li[@class =\"chapter-item\"]/a[contains(text(), \"Chapter "+randNumber+" \")]"));

        if (chapter.exists()){
            chapter.click();
        }
        else {
            this.randNumber = random.nextInt(5);
            clickRandomChapter();
        }
    }
}
