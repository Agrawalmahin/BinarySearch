/*
    

Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.

Note: No extra memory is allowed.

*/

    public class Solution {
        public int findMedian(ArrayList<ArrayList<Integer>> A) {
            
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            for(int i = 0;i<A.size();i++){
                if(A.get(i).get(0) < min) min = A.get(i).get(0);
                
                if(A.get(i).get(A.get(0).size() - 1) > max) max = A.get(i).get(A.get(0).size() - 1);
                
            }
            
            int desired = (A.size()*A.get(0).size() + 1)/2;
            
            while(min < max){
                int mid = min + (max - min)/2;
                
                int less = 0;
                int get = 0;
                for(int i = 0;i<A.size();i++){
                    get= Collections.binarySearch(A.get(i), mid);
                    
                    if(get < 0) get = Math.abs(get) - 1 ;
                    else {
                        
                        while(get < A.get(i).size() && A.get(i).get(get) == mid) get+=1;
                    }
                    
                    less += get;
                }
                
                if(less < desired) min = mid + 1 ;
                else max = mid;
            }
            
            return min;
            
            
        }
    }

