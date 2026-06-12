// The problem is taken form leetocde Number of ENcloves     problem no 1020 
// the idea to solve the question is very sillimar to surrounded region ques pronlem no 130 

class Pair{
    int first ; 
    int second ;
    Pair(int first , int second){
        this.first = first ;
        this.second = second ;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int[][] vi = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        // strating form the boundry and appling bfs on all the 1'ss at boundry and mark them aas visited 
        // than Count the leftover 1's and return 
        for(int i = 0 ; i<m ; i++){
            if(grid[i][0] == 1 && vi[i][0] == 0){
                q.offer(new Pair(i , 0));
                vi[i][0] = 1;
            }
            if(grid[i][n-1]==1 && vi[i][n-1] == 0){
                q.offer(new Pair(i , n-1));
                vi[i][n-1] = 1;
            }
        }
        for(int j = 0 ; j<n ; j++){
            if(grid[0][j] ==1 && vi[0][j]==0){
                q.offer(new Pair(0 , j));
                vi[0][j] = 1;
            }
            if(grid[m-1][j]==1 && vi[m-1][j]==0){
                q.offer(new Pair(m-1 , j ));
                vi[m-1][j] = 1;
            }
        }
        int count = 0  ;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first ;
            int col = p.second ;
            int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
            for(int i = 0 ; i<4 ; i++){
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && vi[nrow][ncol]==0){

                    count++;
                    q.offer(new Pair(nrow , ncol));
                    vi[nrow][ncol] = 1;
                }
            }
        }

        int landCount = 0 ;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j]==1 && vi[i][j] == 0 ){
                    landCount++;
                }
                
            }
        }

        return landCount ;
    }
}