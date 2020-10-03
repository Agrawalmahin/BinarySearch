// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/discover-the-monk/

#include <iostream>
using namespace std;
 
void search(int *A,int start,int end,int key);
int quick_sort(int *,int ,int );
void sort(int * ,int, int );
int main()
{
    int n,q,A[100001],Q[100001];
    cin>>n>>q;
    
    for(int i = 0;i < n; i++){
        cin>>A[i];
    }
    sort(A, 0,n-1);
    for(int i = 0;i < q; i++){
        cin>>Q[i];
    }
    for(int i = 0;i < q; i++){
        int m = Q[i];
        search(A,0,n-1,m);
    }
    return 0;
}
 
void search(int *A,int start,int end,int key){
    int mid;
    
    while(start <= end){
        mid = (start+end)/2;
        if(A[mid] == key){
            cout<<"YES"<<endl;
            return;
        }
         
        else if(key < A[mid]){
            end = mid-1;
        }
        else{
            start = mid+1;
        }
        }
        cout<<"NO"<<endl;
}
int  quick_sort(int *A,int start,int end){
    int pivot = A[end];
    int i = start-1;
    for(int j = start;j < end;j++){
        if(A[j] < pivot){
            i++;
            int swap = A[j];
            A[j] = A[i];
            A[i] = swap;
        }
    }
    i++;
    int swap = A[end];
    A[end] = A[i];
    A[i] = swap;
    
    return (i) ;
 }
void sort(int *A,int start,int end){
    int q;
    if(start < end){
        q = quick_sort(A,start,end);
       // cout<<q<<endl;
        sort(A,start,q-1);
        sort(A,q+1,end);
    }
}
