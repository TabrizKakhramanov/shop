package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() {
        searchables = new LinkedList<>();
    }

    public Map<String,Searchable> search(String term) {
        Map<String,Searchable> results = new TreeMap<>();
        int k = 0;
        for (Searchable e:searchables) {
            if (e != null && e.getSearchTerm().contains(term)) {
                results.put(e.getSearchTerm(),e);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable searchTheBest(String search) throws BestResultNotFound {
        int finalCount = 0;
        Searchable result = null;
        for (Searchable e:searchables) {
            int index = 0;
            int count = 0;
            int substringIndex = e.getSearchTerm().indexOf(search, index);
            while (substringIndex != -1) {
                count++;
                index = index + search.length();
                substringIndex = e.getSearchTerm().indexOf(search, index);
            }
            if (finalCount < count) {
                finalCount = count;
                result = e;
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Запрос " + search + " не найден!");
        }
        return result;
    }
}