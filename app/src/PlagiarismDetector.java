import java.util.*;

class PlagiarismDetector {

    HashMap<String, Set<String>> ngramMap = new HashMap<>();

    public List<String> getNgrams(String text, int n) {

        String[] words = text.split(" ");
        List<String> ngrams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++)
                sb.append(words[i + j]).append(" ");

            ngrams.add(sb.toString().trim());
        }

        return ngrams;
    }

    public void addDocument(String docId, String text) {

        for (String ngram : getNgrams(text, 3)) {

            ngramMap.putIfAbsent(ngram, new HashSet<>());
            ngramMap.get(ngram).add(docId);
        }
    }

    public void checkDocument(String text) {

        int matches = 0;

        for (String ngram : getNgrams(text, 3)) {

            if (ngramMap.containsKey(ngram))
                matches++;
        }

        System.out.println("Matching ngrams: " + matches);
    }

    public static void main(String[] args) {

        PlagiarismDetector p = new PlagiarismDetector();

        p.addDocument("essay1", "this is a sample essay for testing");

        p.checkDocument("this is a sample document");
    }
}