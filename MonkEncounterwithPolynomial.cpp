// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/monks-encounter-with-polynomial/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    int t;
    cin>>t;
    for(int i = 0;i < t ;i++){
        ll a,b,c,k,ans=0;
        cin>>a>>b>>c>>k;
        ll low=0,high=100000;
        while(low<=high){
            ll x = (low+high)/2;
            if((a*x*x)+(b*x)+c >= k){
                ans = x;
                high = x-1;
            }
            else{
                low = x+1;
            }
        }
        cout<<ans<<endl;
    }
    return 0;
}
