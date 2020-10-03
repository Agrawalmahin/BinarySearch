// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-old-monk/

#include <iostream>
using namespace std;
 
int main()
{
    int tc,n,max = 0;
    long long A[100001],B[100001];
    cin>>tc;
    for(int i = 0;i < tc;i++){
        int m = 0;
        cin>>n;
        for(int j = 0;j < n;j++){
            cin>>A[j];
        }
        
        for(int j = 0;j < n;j++){
            cin>>B[j];
        }
        if(B[0] < A[n-1]){
            cout<<"0"<<endl;
            continue;
        }
        else{
            for(int k = 0; k < n;k++){
                m=k;
                while(B[k] >= A[m] && m >=0){
                    if(B[k] >= A[m] && max <= (k-m)){
                            max = k-m;
                        }
                        m--;
                    }
            }
        }
        cout<<max<<endl;
        max = 0;
    }
    return 0;
}
