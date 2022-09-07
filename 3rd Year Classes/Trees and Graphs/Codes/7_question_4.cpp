#include<bits/stdc++.h>
using namespace std;
#define ll long long int

vector<vector<pair<ll,ll>>>adj;
bool dfs(ll node,ll mid,vector<ll>&col,vector<bool>&vis,ll curr){
	vis[node]=true;
	col[node]=curr;
	for(auto child:adj[node]){
		if(child.second<=mid){
			if(!vis[child.first]){
				bool flag=dfs(child.first,mid,col,vis,!curr);
				if(!flag)return false;
			}
			else {
				if(curr==col[child.first])return false;
			}
		}
	}
	return true;
}

void solve(){
	ll n;cin>>n;
	ll m;cin>>m;
	adj.resize(n);
	for(ll i=0;i<n;i++)adj[i].clear();
	for(ll i=0;i<m;i++){
		ll u,v;cin>>u>>v;
		u--,v--;
		adj[u].push_back({v,i});
		adj[v].push_back({u,i});
	}
	ll ans=0;
	ll l=0,u=m-1;
	
	while(l<=u){
		ll mid=l+(u-l)/2;
		vector<bool>vis(n,false);
		vector<ll>col(n,-1);
		bool flag=true;
		for(ll i=0;i<n;i++){
			if(!vis[i]){
				if(!dfs(i,mid,col,vis,0)){
					flag=false;
					break;
				}
			}
		}
		if(!flag){
			u=mid-1;
			ans=mid;
		}
		else{
			l=mid+1;
		}
	}
	
	cout<<ans<<endl;
	
    return;
}
int main()
{
    solve();
    return 0;
}