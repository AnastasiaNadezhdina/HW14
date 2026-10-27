package org.skypro.skyshop.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable s) {
        items.add(s);
    }

    public Set<Searchable> search(String query) {
        Comparator<Searchable> comparator = (a, b) -> {
            int cmp = Integer.compare(b.getName().length(), a.getName().length()); // по убыванию длины имени
            if (cmp != 0) return cmp;
            return a.getName().compareTo(b.getName()); // если длина равна, по алфавиту
        };
        return items.stream()
                .filter(s -> s.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    public org.skypro.skyshop.search.Searchable findBest(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxCount = 0;
        for (Searchable s : items) {
            int count = countOccurrences(s.getSearchTerm(), search);
            if (count > maxCount) {
                maxCount = count;
                best = s;
            }
        }
        if (best == null || maxCount == 0) {
            throw new BestResultNotFound("Не найден результат для запроса: '" + search + "'");
        }
        return best;
    }
    private int countOccurrences(String text, String search) {
        if (search.isEmpty() || text.isEmpty()) return 0;
        int count = 0, idx = 0;
        while ((idx = text.indexOf(search, idx)) != -1) {
            count++;
            idx += search.length();
        }
        return count;
    }
}
