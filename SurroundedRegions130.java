// this problem is taken form leetcode problem no 130 surrounded region 


class Solution {
    // I created a dfs fucntion here which cheks for O's in all the four direction and mark them as visited 
    private void dfs(int row , int col , char[][] board , int[][] vi ){
        int m = board.length ;
        int n = board[0].length ;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0 ; i< 4 ; i++){
            int nrow = row + dir[i][0];
            int ncol = col + dir[i][1];
            if(nrow>= 0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol]=='O'&& vi[nrow][ncol]==0){
                vi[nrow][ncol]=1;
                dfs(nrow , ncol , board , vi);
            }
        }
        return ;
    }
    public void solve(char[][] board) {
        int m = board.length ;
        int n = board[0].length ;
        int[][] vi = new int[m][n] ;

        // I used 2 loops for traversing the boundries of the board 
        // and when ever I am getting any 'O' which is not visited and exist on boundry I called dfs on it and mark it as visted 
        // for upper and bottom row
        for(int j = 0 ; j<n ;j++){
            if(board[0][j]=='O' && vi[0][j]==0){
                vi[0][j]= 1;
                dfs(0 , j , board , vi );
            }
            if(board[m-1][j]=='O'&& vi[m -1][j]==0){
                vi[m-1][j] = 1;
                dfs(m -1 , j , board , vi);
            }
        }
        // for left and right column 
        for(int i = 0 ; i<m ;i++){
            if(board[i][0]=='O' && vi[i][0]==0){
                vi[i][0]= 1;
                dfs(i , 0 , board , vi );
            }
            if(board[i][n-1]=='O'&& vi[i][n-1]==0){
                vi[i][n-1] = 1;
                dfs(i , n-1 , board , vi);
            }
        }
        // Now I am cheking all the indexes which is not visited and is 'O' , changing them to 'X'
        for(int i = 0 ; i< m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(board[i][j]=='O'&& vi[i][j]==0){
                    board[i][j]= 'X';
                }
            }
        }

        return ;
    }
}