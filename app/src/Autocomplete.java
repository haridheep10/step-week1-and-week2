import java.util.*;

class Autocomplete {

    HashMap<String, Integer> queries = new HashMap<>();

    public void addQuery(String q) {
        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> result = new ArrayList<>();

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix))
                result.add(q);
        }

        return result;
    }

    public static void main(String[] args) {

        Autocomplete a = new Autocomplete();

        a.addQuery("java tutorial");
        a.addQuery("javascript");

        System.out.println(a.search("jav"));
    }
}