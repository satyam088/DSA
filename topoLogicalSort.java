// This probelem is taken from the gfg and I solved it using dfs

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        int[] vi = new int[V];
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V ; i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0 ; i<edges.length ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i = 0 ; i<V ; i++){
            if(vi[i]==0){
                dfs(i , vi, st ,adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        // and pushing vertes into the stack when they run out od adj vertices or not have more vertex
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans ;
    }
    // dfs code heregit
    private void dfs(int n , int[] vi , Stack<Integer> st , ArrayList<ArrayList<Integer>> adj){
        vi[n] = 1;
        ArrayList<Integer> nodes = adj.get(n);
        for(int i = 0 ; i<nodes.size() ; i++){
            if(vi[nodes.get(i)]==0){
                dfs(nodes.get(i) , vi , st , adj);
            }
        }
        st.push(n);
        return ;
    }
}