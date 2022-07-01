// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
	using ll = long long int;
	ll mod = 1e9 + 7;
public:
    int FindNthTerm(ll n) {
		if (n < 2) return n;
        vector<ll> fibs = {1, 1, 1, 0};
        vector<ll> ans = fibPower(fibs, n);
        return (int)ans[0];
    }
private:
    vector<ll> matrixProd(vector<ll>& l, vector<ll>& r) {
        vector<ll> ans(4, 0);
        ans[0] = add(mul(l[0] , r[0]) , mul(l[1] , r[2]));
        ans[1] = add(mul(l[0] , r[1]) , mul(l[1] , r[3]));
        ans[2] = add(mul(l[2] , r[0]) , mul(l[3] , r[2]));
        ans[3] = add(mul(l[2] , r[1]) , mul(l[3] , r[3])); 
        return ans;
    }
    vector<ll> fibPower(vector<ll>& fibs, int n){
		if (n == 1) return fibs;
        vector<ll> half = fibPower(fibs, n / 2);
        vector<ll> ans = matrixProd(half, half);
        if (n % 2 == 0) return ans;
        ans[0] = add(ans[0], ans[1]);
        ans[2] = add(ans[2], ans[3]);
        ans[1] = (ans[0] - ans[1] + mod) % mod;
        ans[3] = (ans[2] - ans[3] + mod) % mod;
        return ans;
    }
    ll add(ll a, ll b){
    	return (((a % mod) + (b % mod))) % mod;
    }
    ll mul(ll a, ll b){
    	return ((a % mod) * (b % mod)) % mod;
    }
};


// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		long long int n;
		cin >> n;
		Solution obj;
		int ans = obj.FindNthTerm(n);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends