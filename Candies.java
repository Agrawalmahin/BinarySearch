    import java.util.*;
    import java.io.*;
     //https://codeforces.com/problemset/problem/991/C
    public class programA {
    	public static int Check(long k, long n) {
    		long curr = n;
    		long sum = 0;
    		while(curr>0) {
    			long temp = Math.min(curr, k);
    			sum+=temp;
    			curr-=temp;
    			curr-=curr/10;
    		}
    		if(2*sum>=n)return(1);
    		else return(-1);
    	}
    	public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		long n = Long.parseLong(br.readLine());
    		long low =1;
    		long high = n;
    		long min = Long.MAX_VALUE;
    		while(low<=high) {
    			long mid = (low+high)/2;
    			int g = Check(mid,n);
    			if(g == 1) {
    				min = Math.min(min, mid);
    				high = mid-1;
    				}
    			else low  = mid+1;
    		}
    		System.out.println(min);
    	}
    }
