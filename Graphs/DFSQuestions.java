import java.util.*;
class DFSQuestions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

    }
    //leecode 130================================================================

    public static void surroundedDfsHelper(int r, int c, int board[][]) {
        if (board[r][c] != 'O')
            return;
        board[r][c] = '#';
        if (r - 1 >= 0) {
            surroundedDfsHelper(r - 1, c, board);
        }
        if (c - 1 >= 0) {
            surroundedDfsHelper(r, c - 1, board);
        }
        if (r + 1 < board.length) {
            surroundedDfsHelper(r + 1, c, board);
        }
        if (c + 1 < board[0].length) {
            surroundedDfsHelper(r, c + 1, board);
        }
    }

    public static void surroundedDfs(int board[][]) {
        if (board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                surroundedDfsHelper(i, 0, board);


            if (board[i][m - 1] == 'O')
                surroundedDfsHelper(i, m - 1, board);
        }

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O')
                surroundedDfsHelper(0, i, board);

            if (board[n - 1][i] == 'O')
                surroundedDfsHelper(n - 1, i, board);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    //   leecode 200 =============================
    public static void numIslandsHelper(int r, int c, char[][] board) {
        if (board[r][c] != '1') return;
        board[r][c] = 0;
        if (r - 1 >= 0) {
            numIslandsHelper(r - 1, c, board);
        }
        if (c - 1 >= 0) {
            numIslandsHelper(r, c - 1, board);
        }
        if (r + 1 < board.length) {
            numIslandsHelper(r + 1, c, board);
        }
        if (c + 1 < board[0].length) {
            numIslandsHelper(r, c + 1, board);
        }

    }

    public static int numIslands(char[][] board) {
        if (board.length == 0) {
            return 0;

        }
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    count++;
                    numIslandsHelper(i, j, board);
                }
            }
        }
        return count;
    }
    public int islandPerimeter(int[][] grid) {
        int boxes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    boxes++;
                }
            }
        }
        int commonArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && i + 1 < grid.length && grid[i + 1][j] == 1) {
                    commonArea++;
                }
                if (grid[i][j] == 1 && j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    commonArea++;
                }

            }
        }
        return 4 * boxes - (2 * commonArea);
    }


}



   public int numberofDistinctIslands(int[][] grid) {
        HashSet<String> hs = new HashSet<>();
      for(int i=0;i<grid.length;i++) {
          for(int j=0;j<grid[0].length;j++) {
              if(grid[i][j]==1){
                  
                  str ="";
                   numberofDistinctIslands_(grid,i,j);
               hs.add(str);
             }
          }
        
      }
      System.out.println(hs);
      int size = hs.size();
     return size;
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    char[]dirS={'L','R','T','D'};
    String str;
    public void numberofDistinctIslands_(int [][]grid,int r, int c){
             grid[r][c]=2;
         for(int d=0;d<4;d++){
             int i = r + dir[d][0];
             int j = c + dir[d][1];
             
            if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&& grid[i][j]==1)
            
          {   
                 
              str+=dirS[d];
               numberofDistinctIslands_(grid,i,j) ;
           }
           
           str+="B";
              
         }
         
    }
}