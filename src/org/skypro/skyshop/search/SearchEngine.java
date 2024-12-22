package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int id;

    public SearchEngine(int size){
        searchables = new Searchable[size];
    }

    public Searchable[] search(String term){
        Searchable[] results = new Searchable[5];
        int k =0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i]!=null&&searchables[i].getSearchTerm().contains(term)){
                results[k]= searchables[i];
                k++;
            }
            if (k>=results.length){
                break;
            }
        }
        return results;
    }

    public void add(Searchable searchable){
        if (id<searchables.length){
            searchables[id]=searchable;
            id++;
        }else{
            System.out.println("Невозможно добавить элемент для поиска.");
        }

    }
}
