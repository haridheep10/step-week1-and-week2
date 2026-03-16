import java.util.*;

class InventoryManager {

    HashMap<String, Integer> stock = new HashMap<>();
    HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId, int count) {
        stock.put(productId, count);
        waitingList.put(productId, new LinkedList<>());
    }

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public synchronized void purchaseItem(String productId, int userId) {

        int available = stock.getOrDefault(productId, 0);

        if (available > 0) {
            stock.put(productId, available - 1);
            System.out.println("Success. Remaining: " + (available - 1));
        } else {
            waitingList.get(productId).add(userId);
            System.out.println("Added to waiting list position: " + waitingList.get(productId).size());
        }
    }

    public static void main(String[] args) {

        InventoryManager m = new InventoryManager();

        m.addProduct("IPHONE15", 2);

        m.purchaseItem("IPHONE15", 101);
        m.purchaseItem("IPHONE15", 102);
        m.purchaseItem("IPHONE15", 103);
    }
}