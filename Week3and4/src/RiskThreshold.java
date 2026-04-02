import java.util.*;

public class RiskThreshold {

    // 🔸 Linear Search (unsorted)
    static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // 🔸 Binary Search - Floor
    static Integer findFloor(int[] arr, int target, Counter c) {
        int low = 0, high = arr.length - 1;
        Integer floor = null;

        while (low <= high) {
            c.count++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    // 🔸 Binary Search - Ceiling
    static Integer findCeiling(int[] arr, int target, Counter c) {
        int low = 0, high = arr.length - 1;
        Integer ceil = null;

        while (low <= high) {
            c.count++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] > target) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    // 🔸 Binary Search - Insertion Point (lower_bound)
    static int insertionPoint(int[] arr, int target, Counter c) {
        int low = 0, high = arr.length;

        while (low < high) {
            c.count++;
            int mid = (low + high) / 2;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // Counter class
    static class Counter {
        int count = 0;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        // Linear Search
        linearSearch(risks, 30);

        Counter c1 = new Counter();
        Integer floor = findFloor(risks, 30, c1);

        Counter c2 = new Counter();
        Integer ceil = findCeiling(risks, 30, c2);

        Counter c3 = new Counter();
        int pos = insertionPoint(risks, 30, c3);

        System.out.println("\nBinary Search:");
        System.out.println("Floor: " + floor);
        System.out.println("Ceiling: " + ceil);
        System.out.println("Insertion Position: " + pos);
        System.out.println("Comparisons (Floor): " + c1.count);
        System.out.println("Comparisons (Ceiling): " + c2.count);
        System.out.println("Comparisons (Insertion): " + c3.count);
    }
}