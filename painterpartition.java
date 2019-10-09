/*
You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

        2 painters cannot share a board to paint. That is to say, a board
        cannot be painted partially by one painter, and partially by another.
        A painter will only paint contiguous boards. Which means a
        configuration where painter 1 paints board 1 and 3 but not 2 is
        invalid.

Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003

Example

Input : 
  K : 2
  T : 5
  L : [1, 10]


*/
    public class Solution {
        
        
        public boolean func(ArrayList<Integer> C, int A, int mid){
            
            int pReq = 1;
            int curr = 0;
            
            for(int i = 0;i<C.size();i++){
                if(C.get(i) > mid) return false;
                
                if(curr + C.get(i) > mid){
                    pReq++;
                    curr = C.get(i);
                    
                    if(pReq > A) return false;
                }
                
                else curr += C.get(i);
            }
            return true;
        }
        
        public int paint(int A, int B, ArrayList<Integer> C) {
            
            int maxC = Integer.MIN_VALUE;
            int sum = 0;
            
            for(int i = 0;i<C.size();i++){
                maxC = Math.max(maxC,C.get(i));
                sum += C.get(i);
            }
            int m = 10000003;
            if(C.size() <= A){
                return (int)(((long)maxC*B)%(m));
            }
            
            int start = 0;
            int end = sum;
            int result = Integer.MAX_VALUE;
            while(start <= end){
                int mid = start + (end - start)/2;
                
                if(func(C,A,mid) == true){
                    result = Math.min(result, mid);
                    end = mid - 1;
                }
                else start = mid + 1;
            }
            int ans = (int)(((long)result*B)%m);
            return ans;
        }
    }

