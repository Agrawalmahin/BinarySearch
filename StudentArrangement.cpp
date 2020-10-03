// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/student-arrangement-6/

#include<bits/stdc++.h>
#define MOD 2*100000+7
using namespace std;
typedef long long int l;
int main()
{ 
    l n,m,k,r=0;
    l a[MOD],b[MOD];
    set<int> s;
    cin>>n>>m>>k;
 
    for(l i=1;i<=n;i++)cin>>a[i];
 
    for(l i=1;i<=m;i++)s.insert(i);
 
    for(l i=1;i<=n;i++){
        auto it=s.lower_bound(a[i]);
        if(it==s.end())
            it=s.begin();
        if(*it!=a[i])
            r++;
        b[*it]++;
        
        if(b[*it]==k)
            s.erase(*it);
    
    }
 
    cout<<r<<endl;
    return 0;
}
