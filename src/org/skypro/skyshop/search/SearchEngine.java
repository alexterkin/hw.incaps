package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class SearchEngine {
    private final LinkedList<Searchable> searchables;
    private int counter = 0;

    public SearchEngine(int size) {
        this.searchables = new LinkedList<>();
    }

    public Map<String, Searchable> search(String clientRequest) {
        Map<String, Searchable> result = new TreeMap<>();
        for(Searchable searchable : searchables) {
            if(searchable != null && searchable.getSearchTerm().contains(clientRequest)) {
                result.put(searchable.getSearchTerm(), searchable);
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
        counter++;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
