    import java.util.*;
    import java.math.*;
    import java.io.*;
    import java.text.*;
     //https://codeforces.com/problemset/problem/1301/B
    public class practice {
        // heloo world nudniobv udivbo
        // buyfhsfnoisdfnoi
        public static void merge(int arr[], int l, int m, int r) {
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;
     
            /* Create temp arrays */
            int L[] = new int[n1];
            int R[] = new int[n2];
     
            /*Copy data to temp arrays*/
            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];
     
     
            /* Merge the temp arrays */
     
            // Initial indexes of first and second subarrays
            int i = 0, j = 0;
     
            // Initial index of merged subarry array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
     
            /* Copy remaining elements of L[] if any */
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
     
            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
     
        // Main function that sorts arr[l..r] using
        // merge()
        public static void sort(int arr[], int l, int r) {
            if (l < r) {
                // Find the middle point
                int m = (l + r) / 2;
     
                // Sort first and second halves
                sort(arr, l, m);
                sort(arr, m + 1, r);
     
                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }
     
        public static int n;
        public static int m;
        public static int dis;
        public static ArrayList<Integer> a = new ArrayList<>();
     
        public static void hold_round() {
            for (int i = 0; i < n; i++) {
                int x = a.get(i);
                if (--(x) == 0)
                    dis--;
            }
        }
     
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            long t = Long.parseLong(br.readLine());
            for (int xa = 0; xa < t; xa++) {
                int n = Integer.parseInt(br.readLine());
                long a[] = new long[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    a[i] = Long.parseLong(st.nextToken());
                }
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                long diff1 = Long.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    if (a[i] == -1) continue;
                    else {
                        if (i == 0) {
                            long val = a[i + 1];
                            if (val != -1) {
                                diff1 = Math.max(diff1, Math.abs(a[i] - a[i + 1]));
                            } else {
                                max = Math.max(max, a[i]);
                                min = Math.min(min, a[i]);
                            }
                        } else if (i == n - 1) {
                            long val = a[i - 1];
                            if (val != -1) {
                                diff1 = Math.max(diff1, Math.abs(a[i] - a[i - 1]));
                            } else {
                                max = Math.max(max, a[i]);
                                min = Math.min(min, a[i]);
                            }
                        }
                        else{
                            long val1 = a[i-1];
                            long val2 = a[i+1];
                            if(val1 == -1 && val2 == -1){
                                max = Math.max(max, a[i]);
                                min = Math.min(min, a[i]);
                            }
                            else if(val1!=-1 && val2!=-1){
                                diff1 = Math.max(diff1, Math.max(Math.abs(a[i] - a[i + 1]),Math.abs(a[i]-a[i-1])));
                            }
                            else if(val1!=-1 && val2 == -1){
                                diff1 = Math.max(diff1,Math.abs(a[i] - a[i - 1]));
                                max = Math.max(max, a[i]);
                                min = Math.min(min, a[i]);
                            }
                            else {
                                diff1 = Math.max(diff1,Math.abs(a[i] - a[i + 1]));
                                max = Math.max(max, a[i]);
                                min = Math.min(min, a[i]);
                            }
                        }
                    }
                }
                if(max == Long.MIN_VALUE && (min == Long.MAX_VALUE)){
                    System.out.println("0 0");
                }
                else{
                    long k = (max+min)/2;
                    long ans = Math.max(Math.max(diff1,Math.abs(min-k)),Math.abs(max-k));
                    System.out.println(ans + " " + k);
                }
            }
        }
    }
