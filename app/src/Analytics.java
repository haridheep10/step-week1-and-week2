import java.util.*;

class Analytics {

    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String, Integer> sources = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }

    public void getDashboard() {

        System.out.println("Top Pages");

        for (String page : pageViews.keySet()) {

            System.out.println(page + " Views: " + pageViews.get(page) +
                    " Unique: " + uniqueVisitors.get(page).size());
        }

        System.out.println("Traffic Sources " + sources);
    }

    public static void main(String[] args) {

        Analytics a = new Analytics();

        a.processEvent("/news", "user1", "google");
        a.processEvent("/news", "user2", "facebook");

        a.getDashboard();
    }
}