package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String articleName;
    private String articleContent;

    public Article(String articleName, String articleContent) {
        this.articleName = articleName;
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        return articleName + " " + articleContent;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getSearchContentType() {
        return "ARTICLE";
    }
}
