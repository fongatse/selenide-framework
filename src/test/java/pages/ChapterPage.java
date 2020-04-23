package pages;

import components.chapter_page.Chapter;
import components.global.Navbar;

public class ChapterPage extends Navbar {
    Chapter chapter = new Chapter();

    public String getChapterName() {
        return chapter.getChapterName();
    }

    public ChapterPage bookmarkChapter() {
    chapter.bookmarkChapter();
    return this;
    }
}
