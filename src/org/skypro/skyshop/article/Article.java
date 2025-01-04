package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleName);
    }
}
