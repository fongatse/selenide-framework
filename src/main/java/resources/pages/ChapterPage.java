package resources.pages;

import resources.components.chapter_page.Chapter;
import resources.components.global.Navbar;

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
