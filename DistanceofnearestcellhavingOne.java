c// The problem is taken from the GFG 

// Distance of nearest cell having 1


// here is a solution in which I used bfs algorithm ,cause I have to fild the minimum distance 
// I started my bfs form One , insteand of zero , and store their distance form one in an answer matrix 
// and return that 



lass Node{
    int first ;
    int second ;
    int third ;
    Node(int first , int second , int third){
        this.first = first ;
        this.second =second ;
        this.third = third ;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int m = grid.length ;
        int n = grid[0].length ;
        int[][] vi = new int[m][n];
        
        int[][] ans = new int[m][n];
        Queue<Node> q = new LinkedList<>();
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j]==1){
                    q.offer(new Node(i , j , 0 ));
                    vi[i][j]=1;
                }
            }
        }
        
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int row = node.first ;
            int col = node.second ;
            int dist = node.third ;
                for(int i = 0 ; i<4 ; i++){
                    
                    int nrow = row + dir[i][0];
                    int ncol = col + dir[i][1];
                    
                    if(nrow>=0 &&  nrow<m && ncol>=0 && ncol<n && vi[nrow][ncol]==0 && grid[nrow][ncol]==0 ) {
                        q.offer(new Node(nrow , ncol , dist + 1));
                        ans[nrow][ncol] = dist + 1; 
                        vi[nrow][ncol] = 1;
                }
            }
        }
        ArrayList<ArrayList<Integer>>  rl = new ArrayList<>();
        for(int i = 0 ; i< m ; i++){
            rl.add(new ArrayList<>());
            for(int j = 0 ; j<n ; j++){
                rl.get(i).add(ans[i][j]);
            }
        }
        
        return rl ;
        
    }
}