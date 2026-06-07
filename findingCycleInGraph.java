// I have taken this problem from GeeksforGeeks and solved
//  it using bfs and dfs traversal algorithm ,


// First I thinked of BFS than I also solved it using DFS ;

// This is a ds that I create for the simplicity of my bfs algorithm 
class Pair{
    int first ; 
    int second ;
    Pair(int first , int second){
        this.first = first ;
        this.second = second;
    }
}
class Solution {
    // Herre I am using BFS algorithm to find the cycle in the graph 
    public boolean bfs(int src , ArrayList<ArrayList<Integer>>adj , int[] vi){
        vi[src] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src , -1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int curr = p.first ;
            int par = p.second;
            ArrayList<Integer> currlist = adj.get(curr);
            for(int i = 0 ; i<currlist.size();i++){
                int el = currlist.get(i);
                if(el==par) continue ;
                else if(vi[el]==0){
                    q.offer(new Pair(el , curr));
                    vi[el] = 1;
                }else if (vi[el]==1){
                    return true;
                }
            }
        }
        return false;
    }
    
    // Here I am using an dfs algrothim for finding the cycle in the graph 
        public boolean dfs(int src , int parent ,  ArrayList<ArrayList<Integer>> adj , int[] vi){
        ArrayList<Integer> n = adj.get(src);
        boolean ans = false;
        vi[src] = 1;
        for(int i = 0 ; i<n.size();i++){
            
            int curr = n.get(i);
            if(vi[curr]==0){
                ans = ans || dfs(curr , src , adj , vi);
            }else if(vi[curr]==1  && curr !=parent){
                return true;
            }
        }
        return ans ;
    }
    // this is my main fucntion called by gfg , 
    public boolean isCycle(int V, int[][] grid) {
        // Code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0 ; i<V ; i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] vi = new int[V];
        for(int i = 0 ; i < grid.length ; i++){
                adj.get(grid[i][0]).add(grid[i][1]);
                adj.get(grid[i][1]).add(grid[i][0]);
        }
        
        for(int i = 0 ; i<V ; i++){
            if(vi[i]==0){
                if(dfs(i , adj , vi))  return true;
            }
        }
       
       return false;
    }
}
