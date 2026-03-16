import java.util.*;

class TwoSum {

    public void findTwoSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println(num + " + " + complement);
            }

            map.put(num, 1);
        }
    }

    public static void main(String[] args) {

        TwoSum t = new TwoSum();

        int arr[] = {500, 300, 200};

        t.findTwoSum(arr, 500);
    }
}