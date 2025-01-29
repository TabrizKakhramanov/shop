package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchEngineComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int name1 = o1.getSearchTerm().length();
        int name2 = o2.getSearchTerm().length();
        int result = Integer.compare(name2,name1);
        if (result==0){
            return o2.getSearchTerm().compareTo(o1.getSearchTerm());
        } else {
            return result;
        }

    }
}
