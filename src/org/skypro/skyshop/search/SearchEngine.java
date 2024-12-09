package org.skypro.skyshop.search;

public class SearchEngine {
    Searchable[] searchables;
    Searchable[] foundItems;
    private int size;
    private static int id;

    public SearchEngine(int size){
        searchables = new Searchable[size];
        this.size = size;
        id = 0;
    }

    public void search(String term){
        for (int i = 0; i < size; i++) {
            int foundItems = 0;
           if (searchables[i].getSearchTerm().contains(term)){
               if (foundItems==5){
                   break;
               }
               System.out.println(searchables[i].getStringRepresentation());
               foundItems++;
           }
        }
    }
    public void add (Searchable searchable){
        if (id<size) {
            searchables[id] = searchable;
            id++;
        } else {
            System.out.println("Массив заполнен!");
        }
    }
}
