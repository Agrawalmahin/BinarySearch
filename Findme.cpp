#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define ld long double
#define mod 1000000007
#define mp make_pair
#define pb push_back
#define si(x) scanf("%d",&x)
#define pi(x) printf("%d\n",x)
#define s(x) scanf("%lld",&x)
#define p(x) printf("%lld\n",x)
#define sc(x) scanf("%s",x)
#define pc(x) printf("%s",x)
#define pii pair<int,int>
#define pll pair<ll,ll>
#define F first
#define S second
#define inf 4e18
#define prec(x) fixed<<setprecision(15)<<x
#define all(x) x.begin(),x.end()
#define rall(x) x.rbegin(),x.rend()
#define mem(x,y) memset(x,y,sizeof(x))
#define PQG priority_queue< int,std::vector<int>,std::greater<int> >
#define PQL priority_queue< int,std::vector<int>,std::less<int> >
#define PQPL priority_queue<pii ,vector< pii >, less< pii > >
#define PQPG priority_queue<pii ,vector< pii >, greater< pii > >
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL)
#define max(a,b) (a>b?a:b)

ll search(ll *A,ll mn,ll mx,ll key){
    ll mid;
    while(mn<=mx){
        mid = (mn+mx)/2;
        if(A[mid] == key){
            return mid;
        }
        else if(A[mid] > key){
            if(A[mid-1]<=key){
                return (mid-1);
            }
            mx = mid-1;
        }
        else{
            if(A[mid+1] > key){
                return mid;
            }
            mn = mid+1;
        }
    }
    return -1;
}

ll  power(ll a,ll e){
    if(e == 0)
        return 1;
     ll ans = power(a,e/2);
     ll p = (ans*ans)%mod;
    if(e%2==1)p = (a*p)%mod;
     return p;    
}
int main(){
    
    return 0;
}
