//https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/charsi-in-love/description/
#include<bits/stdc++.h>
using namespace std;
#define ll long long
 
bool search(ll *A,ll min,ll max,ll key){
    ll mid;
    while(min<=max){
        mid = (min+max)/2;
        if(A[mid] == key){
            return true;
        }
        else if(A[mid] > key){
            max = mid-1;
        }
        else {
            min = mid+1;
        }
    }
    return false;
}
 
int main(){
    ll A[45000];
    A[0] = 0;
    ll n;
    cin>>n;
    for(ll i = 1 ; i <= 45000 ; i++){
        A[i] = A[i-1] + i;
    }
    ll a=1;
    for(ll i = 1 ; i*i  < n ; i++){
        if(search(A,a,45000,n-A[i])){
            cout<<"YES"<<endl;
            return 0;
        }
    }
    cout<<"NO"<<endl;
    return 0;
}
