//https://codeforces.com/problemset/problem/600/B
import java.io.BufferedOutputStream;
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.util.Arrays;
    import java.util.StringTokenizer;
     
    public class queries {
     
    	public static void main(String[] args) throws Exception {
    		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
     
    		StringTokenizer st = new StringTokenizer(in.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		
    		Integer[] a = new Integer[n];
    		StringTokenizer st1 = new StringTokenizer(in.readLine());
    		for (int i = 0; i < n; i++) {
    			int num = Integer.parseInt(st1.nextToken());
    			a[i] = num;
    		}
    		
    		Pair[] b = new Pair[m];
    		StringTokenizer st2 = new StringTokenizer(in.readLine());
    		for (int i = 0; i < m; i++) {
    			int num = Integer.parseInt(st2.nextToken());
    			b[i] = new Pair(num, i);
    		}
    		
    		Arrays.sort(a);
    		Arrays.sort(b);
    		
    		int[] res = new int[m];
    		
    		int currI = 0;
    		int currS = 0;
    		for(int i = 0; i < m; i++) {
    			while(currI < n) {
    				if(a[currI] <= b[i].num) {
    					currS++;
    					currI++;
    				} else {
    					break;
    				}
    			}
    			
    			res[b[i].i] = currS;
    		}
    		
    		for (int i = 0; i < m; i++) {
    			out.print(res[i] + " ");
    		}
    		
    		in.close();
    		out.close();
    	}
    	
    	static class Pair implements Comparable<Pair> {
    		int num, i;
    		public Pair(int a, int b) {
    			num = a;
    			i = b;
    		}
    		@Override
    		public int compareTo(Pair o) {
    			return num - o.num;
    		}
    	}
    }
