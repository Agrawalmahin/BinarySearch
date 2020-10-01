    import java.util.*;
    import java.io.*;
    public class programA {
    	public static boolean isPerfectSquare(double x)  
        { 
              
            // Find floating point value of 
            // square root of x. 
            double sr = Math.sqrt(x); 
          
            // If square root is an integer 
            return ((sr - Math.floor(sr)) == 0); 
        } 
    	public static void main(String[] args)throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		//StringTokenizer st = new StringTokenizer(br.readLine());
    		double n = Double.parseDouble(br.readLine());
    		boolean issquare = isPerfectSquare(n);
    		if(issquare) {
    			double ans = 2*Math.sqrt(n);
    			System.out.println((int)ans);
    		}
    		else {
    			int sqrt = (int)Math.sqrt(n);
    			double square = (double)sqrt*(double)sqrt;
    			if(n-square <= sqrt)System.out.println(2*sqrt+1);
    			else System.out.println(2*sqrt+2);
    		}
    		
    	}
     
    }
