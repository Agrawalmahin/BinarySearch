/*
    

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

        NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*


*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int bsearch(List<Integer> a, int l, int h, int b){
        if(l > h) return -1;
        
        int mid = l + (h-l)/2;
        if (a.get(mid) == b) 
            return mid; 
        
        if (a.get(l) <= a.get(mid)) 
        { 
            if (b >= a.get(l) && b <= a.get(mid)) 
               return bsearch(a, l, mid-1, b); 
        
            return bsearch(a, mid+1, h, b); 
        } 
        if (b >= a.get(mid) && b <= a.get(h)) 
            return bsearch(a, mid+1, h, b); 
        
        return bsearch(a, l, mid-1, b); 
    }
    
    public int search(final List<Integer> a, int b) {
        return bsearch(a,0,a.size()-1,b);
    }
}
