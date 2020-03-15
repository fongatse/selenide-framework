package resources.pages;

import resources.components.global.Navbar;
import resources.components.novel_page.NovelInfo;

/**
 * Contains methods for any NovelPage
 */
public class NovelPage extends Navbar {
    NovelInfo novelInfo = new NovelInfo();

    /**
     * closes Cookie modal
     *
     * @return NovelPage
     */
    public NovelPage continueCookies() {
        continueWithCookies();
        return this;
    }

    /**
     * Verifies that the Novel is the one the user wants
     *
     * @param novel Novel label
     * @return
     */
    public NovelPage verifyNovel(String novel) {
        novelInfo.verifyNovel(novel);
        return this;
    }
}
