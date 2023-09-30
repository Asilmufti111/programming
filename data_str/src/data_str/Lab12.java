package data_str;

public class Lab12 {

    public static void main(String[] args) {
        int[] values = {3, 6, 8, 1, 7, 4, 5, 2};
        System.out.println("The array before sorting: ");
        for (int i = 0; i < values.length; ++i) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
        MergeSort(values, 0, values.length - 1);
        System.out.println("The array after sorting: ");
        for (int i = 0; i < values.length; ++i) {
            System.out.print(values[i] + " ");
        }
        System.out.println();

    }

    public static void MergeSort(int[] values, int start, int end) {
        int mid;
// Check if our sorting range is more than one element. 
        if (start < end) {
            mid = (start + end) / 2;
// Sort the first half of the values. 
            MergeSort(values, start, mid);
// Sort the last half of the values. 
            MergeSort(values, mid + 1, end);
// Put it all together. 
            Merge(values, start, mid, end);
        }
    }

    public static void Merge(int values[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = values[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = values[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                values[k] = L[i];
                i++;
            } else {
                values[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            values[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            values[k] = R[j];
            j++;
            k++;
        }
    }

}
