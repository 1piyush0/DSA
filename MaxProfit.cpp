#include<iostream>
#include<map>
#include<vector>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> prices(n);
    for(auto &x:prices) cin>>x;

    map<int,int> FreqProfit; 
    int maxProfit=0;
    for(int i=1;i<n;i++){
        if(prices[i]>prices[i-1]){
            FreqProfit[prices[i]-prices[i-1]]++;
        }
    }

    for(auto &[profit,freq]:FreqProfit){
        maxProfit=max(maxProfit,profit*freq);
    }
    cout<<maxProfit<<'\n';
    return 0;
}