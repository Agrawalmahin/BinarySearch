//https://codeforces.com/problemset/problem/251/A
import java.util.LinkedList;
    import java.util.Scanner;
     
    public class a4_1 {
     
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		int n = sc.nextInt();
    		int d = sc.nextInt();
    		int[] ndata = new int[n];
    		for (int i = 0; i < n; i++) {
    			ndata[i] = sc.nextInt();
    		}
    		LinkedList<Integer> list = new LinkedList<>();
    		long ans = 0;
     
    		for (int i = 0; i < n; i++) {
    			list.addLast(i);
    			while (ndata[i] - ndata[list.peekFirst()] > d) {
    				list.pollFirst();
    			}
    		
    			long dis = i - list.peekFirst();
    			ans += (dis * (dis - 1) / 2);
    		}
    		System.out.println(ans);
    	}
    }
 
