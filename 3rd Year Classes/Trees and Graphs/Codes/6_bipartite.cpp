#include<bits/stdc++.h>
using namespace std;
#define ll long long int

vector<vector<ll>>adj;
bool dfs(ll node,vector<ll>&colour){
	if(colour[node]==-1){
		colour[node]=0;
	}
	
	ll opp_colour = (1-colour[node]);
	
	bool ans=true;
	
	for(ll child:adj[node]){
		if(colour[child]==-1){
			colour[child]=opp_colour;
			ans|= dfs(child,colour);	
		}
		else if(colour[child]==colour[node])return false;
	}
	return ans;
	
}
void solve(){
	ll n;cin>>n;
	ll m;cin>>m;
	adj.resize(n);
	for(ll i=0;i<n;i++)adj[i].clear();
	for(ll i=0;i<m;i++){
		ll u,v;cin>>u>>v;
		u--,v--;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	
	bool ans=true;
	
	vector<ll>colour(n,-1);
	for(ll i=0;i<n;i++){
		if(colour[i]==-1){
			ans=dfs(i,colour);
		}
		if(ans==false){
			cout<<"Not a Bipartite Graph\n";
			return;
		}
	}
	
	cout<<"Its a Bipartite Graph\n";
	
    return;
}
int main()
{
    solve();
    return 0;
}