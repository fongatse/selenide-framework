package pages;

import components.bookmarks_page.Bookmarks;
import components.global.Navbar;

public class BookmarksPage extends Navbar {
    Bookmarks bookmarks = new Bookmarks();

    public BookmarksPage assertManualBookmarkExists(String bookmark){
        closeAd();
        bookmarks.manualTab();
        bookmarks.assertBookmarkExists(bookmark);
        return this;
    }

    public BookmarksPage assertAutomaticBookmarkExists (String bookmark){
        closeAd();
        bookmarks.automaticTab();
        bookmarks.assertBookmarkExists(bookmark);
        return this;
    }

    public BookmarksPage deleteBookmark(String bookmark){
        closeAd();
        bookmarks.deleteBookMark(bookmark);
        return this;
    }
}
