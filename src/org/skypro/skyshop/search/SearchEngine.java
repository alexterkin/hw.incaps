package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String clientRequest) {
        Searchable[] result = new Searchable[5];
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

    public Searchable getSearchTerm(String search) {
        int quantity = 0;
        int index = 0;
        int indexSubstring = str.indexOf(search, index);
        for(Searchable searchable : searchables) {
            searchable.
        }
    }
}
