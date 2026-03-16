import java.util.*;

class MultiLevelCache {

    LinkedHashMap<String, String> L1 = new LinkedHashMap<>(10, 0.75f, true);
    HashMap<String, String> L2 = new HashMap<>();

    public String getVideo(String id) {

        if (L1.containsKey(id)) {
            System.out.println("L1 HIT");
            return L1.get(id);
        }

        if (L2.containsKey(id)) {
            System.out.println("L2 HIT");
            String data = L2.get(id);
            L1.put(id, data);
            return data;
        }

        System.out.println("L3 Database HIT");

        String data = "VideoData";
        L2.put(id, data);

        return data;
    }

    public static void main(String[] args) {

        MultiLevelCache c = new MultiLevelCache();

        c.getVideo("video1");
        c.getVideo("video1");
    }
}