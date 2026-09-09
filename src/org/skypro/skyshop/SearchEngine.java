package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable s) {
        if (size < items.length) {
            items[size++] = s;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int found = 0;
        for (Searchable s : items) {
            if (s != null && s.getSearchTerm().contains(query)) {
                result[found++] = s;
                if (found >= 5) break;
            }
        }
        return result;
    }
    public Searchable findBest(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxCount = 0;
        for (Searchable s : items) {
            if (s == null) continue;
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
