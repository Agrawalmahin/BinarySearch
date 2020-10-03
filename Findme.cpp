#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define _ cin.tie(0);cout.tie(0);ios_base::sync_with_stdio(0);
int b[1000005] = {0};
int A[1000005];
int n;
int get(int idx){
    int sum=0;
    while(idx>0){
        sum += b[idx];
        idx -= idx&(-idx);
    }
    return sum;
}
void add(int idx){
    while(idx<=n){
        b[idx]++;
        idx += idx&(-idx);
    }
}
int main(){
    _
    int q;
    cin >> n >> q ;
    for(int i = 1 ; i <= n ; i++){
        cin >> A[i];
    }A[0] = 0;
    sort(A,A+n+1);
    
    while(q--){
        int k;
        cin >> k ;
        int l = 1,r=n;
        int ans = n ;
        while(l<=r){
            int mid = (l+r)/2;
            if(mid - get(mid) >= k){
                ans = min(ans,mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        cout << A[ans]<<"\n";
        add(ans);
    }
    return 0;
}
