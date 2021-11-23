import java.util.*;
class Sudoku{
    
static int Srow[]=new int[9];
 static int Scol[]=new int[9];
 static int Smat[][]=new int[3][3];
    public static  void solveSudoku(int board[][])
{
    ArrayList<Integer> calls=new ArrayList<>();
    

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (board[i][j] == 0)
                calls.add(i * 9 + j);
            
        
       
            else
            {
                int num = board[i][j] ;
                int mask = 1 << num;
                Srow[i] ^= mask;
                Scol[j] ^= mask;
                Smat[i / 3][j / 3] ^= mask;
            }
        }
        
    }

    SolveSudoku(board, calls, 0);
     
}
     public static boolean isValid(int arr[][],int r, int c ,int num){
       for(int i=0;i<arr.length;i++){
           if(arr[i][c]==num){
               return false;
           }
      }
        for(int i=0;i<arr[0].length;i++){
           if(arr[r][i]==num){
               return false;
           }
        }
         int row=(r/3)*3;
         int col=(c/3)*3;
         for(int i=0;i<3;i++){
             for(int j=0;j<3;j++){
                 if(arr[row+i][col+j]==num){
                     return false;
                 }
             }
         }

           return true;
      }

     public static void SolveSudoku(int arr[][],ArrayList<Integer> calls,int idx){
     
       if(idx==calls.size()){
           for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
           return;
       }
       
            int r=calls.get(idx)/9;
            int c=calls.get(idx)%9;
             
           
             for(int j=1;j<=9;j++){
              
            int mask = 1 << j;
               if ((Srow[r] & mask) == 0 && (Scol[c] & mask) == 0 && (Smat[r / 3][c / 3] & mask) == 0)
               {

               arr[r][c]=j;
            Srow[r] ^= mask;
            Scol[c] ^= mask;
            Smat[r / 3][c / 3] ^= mask;
               SolveSudoku(arr,calls,idx+1);
                arr[r][c]=0;
            Srow[r] ^= mask;
            Scol[c] ^= mask;
            Smat[r / 3][c / 3] ^= mask;
              }
              
            }
           
             


     }
     
    public static void main(String[] args){
      int arr[][]={ {5, 3, 0, 0, 7, 0, 0, 0, 0}, 
         {6, 0, 0, 1, 9, 5, 0, 0, 0}, 
         {0, 9, 8, 0, 0, 0, 0, 6, 0}, 
         {8, 0, 0, 0, 6, 0, 0, 0, 3}, 
         {4, 0, 0, 8, 0, 3, 0, 0, 1}, 
         {7, 0, 0, 0, 2, 0, 0, 0, 6}, 
         {0, 6, 0, 0, 0, 0, 2, 8, 0}, 
         {0, 0, 0, 4, 1, 9, 0, 0, 5}, 
         {0, 0, 0, 0, 8, 0, 0, 7, 9} };
        solveSudoku(arr);
       
        
         
    }
}