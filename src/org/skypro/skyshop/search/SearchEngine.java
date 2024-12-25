package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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

    public Searchable searchTheBest(String search){
        int finalCount = 0;
        Searchable result = null;
        for (int i = 0; i < id; i++) {
            int index=0;
            int count = 0;
            int substringIndex = searchables[i].getSearchTerm().indexOf(search,index);
            while (substringIndex!=-1 ) {
                count++;
                index = index + search.length();
                substringIndex = searchables[i].getSearchTerm().indexOf(search, index);
            }
            if (finalCount<count){
                finalCount = count;
                result = searchables[i];
            }
        }
        return result;
    }
}
