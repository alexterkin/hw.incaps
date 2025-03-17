package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchEngineComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        System.out.println("Сравниваем: " + o1.getName() + " и " + o2.getName());
        int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length());
        if (lengthComparison == 0) {
            int result = o1.getName().compareTo(o2.getName());
            System.out.println("Результат сравнения по имени: " + result);
            return result;
        }
        System.out.println("Результат сравнения по длине: " + lengthComparison);
        return lengthComparison;
    }
}

