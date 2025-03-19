package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;

import java.util.*;
import java.util.stream.Collectors;


public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String clientRequest) {
        return searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(clientRequest))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchEngineComparator())));
    }

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public void getBestMatch(String search) throws BestResultNotFoundException {
        Searchable candidate = null;
        int candidateCount = 0;
        for(Searchable searchable : searchables) {
            if(searchable != null) {
                int count = countMatches(searchable.getSearchTerm(), search);
                if(count > candidateCount) {
                    candidate = searchable;
                    candidateCount = count;
                }
            }
        }
        if(candidate == null) {
            throw new BestResultNotFoundException("Результат не найден");
        }
    }

    private int countMatches(String source, String search) {
        int count = 0;
        int index = 0;
        while ((index = source.indexOf(search, index)) >= 0) {
            count++;
            index = index + search.length();
        }
        return count;
    }
}
