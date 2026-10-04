package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();

    public void add(Searchable s) {
        items.add(s);
    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable s : items) {
            if (s.getSearchTerm().contains(query)) {
                result.add(s);
            }
        }
        return result;
    }

    public Searchable findBest(String search) throws BestResultNotFound {
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
