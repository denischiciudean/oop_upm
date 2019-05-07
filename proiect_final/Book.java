import pages.Page;

import java.util.Vector;

public class Book implements BookInterface {

    public String name;

    public String author;

    public Integer currentPageNumber = 0;

    public Vector<Page> pages;

    @Override
    public String readPage() {
        return pages.elementAt(currentPageNumber).getPage_content();
    }

    @Override
    public void ripPage() {
        pages.removeElementAt(currentPageNumber);
    }

    @Override
    public void gotoPage() {

    }

    @Override
    public void nextPage() {

    }

    @Override
    public void previousPage() {

    }

    public void searchPage() {
        //Todo: Implement Search within a page
    }

    private class Match {

        private Integer pageNumber;
        private String match_string;
        private String highlighted_match;

        public String getHighlighted_match() {
            return highlighted_match;
        }

        public void setHighlighted_match(String highlighted_match) {
            this.highlighted_match = highlighted_match;
        }

        public String getMatch_string() {
            return match_string;
        }

        public void setMatch_string(String match_string) {
            this.match_string = match_string;
        }

        public Integer getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }
    }

    public Vector<Match> searchWithinBook() {

        //Todo: Implement Search within Book

        Vector<Match> matches = null;

        return matches;
    }
}
