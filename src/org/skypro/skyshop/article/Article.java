package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {

    private String articleName;
    private String articleContent;

    public Article(String articleName, String articleContent){
        this.articleName=articleName;
        this.articleContent=articleContent;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    @Override
    public String toString() {
        return this.articleName+"\n"+ this.articleContent;
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getObjectType() {
        return "ARTICLE";
    }

    @Override
    public String getObjectName() {
        return "ARTICLE";
    }
}
