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


// here is the solution 2 , that I solved using kahn's algorithm 

class Solution2 {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int indegree[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i<V ; i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0 ; i<edges.length ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i< V ; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int n = q.poll();
            ans.add(n);
            for(int i : adj.get(n)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        return ans ;
    }
}