#include<iostream>
#include<map>
#include<vector>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> tiles(n);
    for(auto &x:tiles) cin>>x;

    map<int,int> FreqTiles; 
    for(int i=0;i<n;i++){
        FreqTiles[tiles[i]]++;
    }
    int flg=0,previous,cur=0,longest_streak=0;
    for(auto &[tile,present]:FreqTiles){
        if(flg==0){
            flg=1;
            cur=1;
        }
        else {
            if(previous==tile-1){
                cur+=1;
            }
            else {
                cur=1;
            }
        }
        previous=tile;
        longest_streak=max(longest_streak,cur);
    }
    cout<<longest_streak<<'\n';
    return 0;
}