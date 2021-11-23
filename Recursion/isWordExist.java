
int dir[] = {{0,1},{0,-1},{1,0},{-1,0}};
public  boolean isLetterExist(char ch , char[][] board , int idx , String word) {
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]==ch){
                if(idx == 0){
                    return true;
                }
                for(int d = 0 ; d< 4 ;d++){
                     int r = i + d[i][0];
                     int c = j + d[i][1];
                     if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c]==word.charAt(idx-1)){
                         return true;
                     }
                }
            }
        }
    }
    return false;
}

public boolean exist(char[][] board, String word) {
        boolean isExist = true;
         for(int i = 0 ;i<word.length();i++){
             char ch = word[i];
             if(!isLetterExist(ch , board, i ,word))
             isExist=false;
         }
         return isExist;
    }