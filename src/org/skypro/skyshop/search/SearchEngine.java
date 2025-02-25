package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFoundException;

public class SearchEngine {
    private final Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String clientRequest) {
        Searchable[] result = new Searchable[10];
        int position = 0;
        for(Searchable searchable : searchables) {
            if(searchable != null && searchable.getSearchTerm().contains(clientRequest)) {
                result[position++] = searchable;
            }
            if(position == result.length - 1) {
                break;
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if(searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
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
}
