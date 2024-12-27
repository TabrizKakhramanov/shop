package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine(int size) {
        searchables = new ArrayList<>(size);
    }

    public List<Searchable> search(String term) {
        List<Searchable> results = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) != null && searchables.get(i).getSearchTerm().contains(term)) {
                results.add(searchables.get(i));
                k++;
            }
            if (k >= results.size()) {
                break;
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
        for (int i = 0; i < searchables.size(); i++) {
            int index = 0;
            int count = 0;
            int substringIndex = searchables.get(i).getSearchTerm().indexOf(search, index);
            while (substringIndex != -1) {
                count++;
                index = index + search.length();
                substringIndex = searchables.get(i).getSearchTerm().indexOf(search, index);
            }
            if (finalCount < count) {
                finalCount = count;
                result = searchables.get(i);
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Запрос " + search + " не найден!");
        }
        return result;
    }
}
