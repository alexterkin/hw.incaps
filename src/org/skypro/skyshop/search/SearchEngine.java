package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;

import java.util.LinkedList;

public class SearchEngine {
    private final LinkedList<Searchable> searchables;
    private int counter = 0;

    public SearchEngine(int size) {
        this.searchables = new LinkedList<>();
    }

    public LinkedList<Searchable> search(String clientRequest) {
        LinkedList<Searchable> result = new LinkedList<>();
        for(Searchable searchable : searchables) {
            if(searchable != null && searchable.getSearchTerm().contains(clientRequest)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
        counter++;
    }

    public Searchable getBestMatch(String search) throws BestResultNotFoundException {
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
        return candidate;
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
