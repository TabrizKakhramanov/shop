package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String term) {
        Set<Searchable> results = searchables.stream()
                .filter(el->{return el!=null&&el.getSearchTerm().contains(term);})
                .collect(Collectors.toCollection(()-> new TreeSet<>(new SearchEngineComparator())));
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