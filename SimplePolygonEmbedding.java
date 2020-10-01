    import java.io.*;
    import java.util.*;
     //https://codeforces.com/problemset/problem/1354/C1
    public class solution {
        static class sort implements Comparator<ArrayList<Integer>> {
     
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int c = o2.get(1).compareTo(o1.get(1));
                if (c == 0) {
     
                    c = o2.get(0).compareTo(o1.get(0));
                }
                return c;
            }
        }
     
        public static void merge(long arr[], int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
            long L[] = new long[n1];
            long R[] = new long[n2];
            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];
            int i = 0, j = 0;
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
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
     
        public static void sort(long arr[], int l, int r) {
            if (l < r) {
                int m = (l + r) / 2;
                sort(arr, l, m);
                sort(arr, m + 1, r);
                merge(arr, l, m, r);
            }
        }
     
        public static long gcd(long a, long b) {
            if (b == 0) {
                return a;
            } else return gcd(b, a % b);
        }
     
        public static long lcm(long a, long b) {
            long gcd = gcd(a, b);
            long pord = a * b;
            return pord / gcd;
        }
     
        static class graphs {
            private int V;
            private ArrayList<Integer> adj[];
     
            graphs(int v) {
                V = v;
                adj = new ArrayList[v];
                for (int i = 0; i < v; i++) {
                    adj[i] = new ArrayList<>();
                }
            }
     
            void addedge(int u, int v) {
                adj[u].add(v);
            }
     
            void BFS(int v) {
                boolean visited[] = new boolean[V];
                Queue<Integer> Q = new LinkedList<>();
                visited[v] = true;
                Q.add(v);
                while (!Q.isEmpty()) {
                    int temp = Q.peek();
                    System.out.print(temp + " ");
                    Q.remove();
                    Iterator<Integer> it = adj[temp].listIterator();
                    while (it.hasNext()) {
                        int n = it.next();
                        if (!visited[n]) {
                            visited[n] = true;
                            Q.add(n);
                        }
                    }
                }
            }
     
            void DFSUtil(int v, boolean visited[]) {
                visited[v] = true;
                System.out.print(v + " ");
                Iterator<Integer> it = adj[v].listIterator();
                while (it.hasNext()) {
                    int n = it.next();
                    if (!visited[n]) {
                        DFSUtil(n, visited);
                    }
                }
            }
     
            void DFS(int v) {
                boolean visited[] = new boolean[V];
                DFSUtil(v, visited);
            }
        }
     
        public static int Binaraysearch(long a[], int low, int high, long key) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (a[mid] == key) {
                    return mid;
                } else if (a[mid] < key) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            return -1;
        }
     
        public static void seive(boolean prime[]) {
            Arrays.fill(prime, true);
            int n = prime.length - 1;
            for (int p = 2; p * p <= n; p++) {
                if (prime[p] == true) {
                    for (int i = p * p; i <= n; i += p)
                        prime[i] = false;
                }
            }
        }
     
        public static boolean random(long a, long b) {
            return a < b;
        }
     
        public static int subArraySum(int arr[], int n, int sum) {
            int curr_sum = arr[0], start = 0, i;
            for (i = 1; i <= n; i++) {
                // If curr_sum exceeds the sum, then remove the starting elements
                while (curr_sum > sum && start < i - 1) {
                    curr_sum = curr_sum - arr[start];
                    start++;
                }
     
                // If curr_sum becomes equal to sum, then return true
                if (curr_sum == sum) {
                    int p = i - 1;
                    if (p != start)
                        return 1;
                }
     
                // Add this element to curr_sum
                if (i < n)
                    curr_sum = curr_sum + arr[i];
     
            }
            return 0;
        }
     
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                double n = Double.parseDouble(br.readLine());
                n *= 2;
                double g = (double) (180 / n);
                double m = Math.toRadians(g);
                double r1 = ((double) 1 / 2);
                double r = r1 / Math.sin(m);
                double a = r * Math.cos(m);
                System.out.printf("%.10f",2 * a);
                System.out.println();
            }
        }
    }
