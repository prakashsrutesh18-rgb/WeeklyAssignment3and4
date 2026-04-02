import java.util.*;

public class AccountSearch {

    // 🔸 Linear Search (First & Last Occurrence)
    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // 🔸 Binary Search (Find any one occurrence)
    static int binarySearch(String[] arr, String target, Counter counter) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            counter.count++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // 🔸 Count occurrences using Binary Search
    static int countOccurrences(String[] arr, String target, Counter counter) {
        int index = binarySearch(arr, target, counter);
        if (index == -1) return 0;

        int count = 1;

        // left side
        int i = index - 1;
        while (i >= 0 && arr[i].equals(target)) {
            counter.count++;
            count++;
            i--;
        }

        // right side
        i = index + 1;
        while (i < arr.length && arr[i].equals(target)) {
            counter.count++;
            count++;
            i++;
        }

        return count;
    }

    // Helper class for counting comparisons
    static class Counter {
        int count = 0;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search (unsorted)
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        Counter counter = new Counter();
        int index = binarySearch(logs, "accB", counter);
        int count = countOccurrences(logs, "accB", counter);

        System.out.println("\nBinary Search:");
        System.out.println("Found at index: " + index);
        System.out.println("Total occurrences: " + count);
        System.out.println("Comparisons: " + counter.count);
    }
}