import java.util.*;
class placeQueen{
    public static void main(String[]args){
    Scanner s=new Scanner(System.in);
 
    int n=s.nextInt();
    boolean boxes[][]=new boolean[n][n];
    int arr[]=new int[n];
    int queens=s.nextInt();
    // System.out.println(placeQueen(arr,"",0,1,queens)) ;
    // System.out.println(placeQueenBox(arr,"",0,1,queens,boxes)) ;
    // System.out.println(placeQueenBox02(arr,"",0,queens,boxes));
    // System.out.println(placeQueenBox03(arr,"",0,queens,boxes));
     System.out.println(placeQueenBox04(arr,"",queens,boxes,0));
    
  
  }
  public static boolean isSafeToPlaceQueen(boolean boxes[][], int row, int col)
{

   int[][] Qdir = {
           {0, -1}, 
     {-1, -1}, 
     {-1, 0}, 
     {-1, 1},
        };
   
  
  

    for (int d = 0; d < Qdir.length; d++)
    {
        for (int rad = 1; rad <=boxes.length; rad++)
        {
            int r = row + rad * Qdir[d][0];
            int c = col + rad * Qdir[d][1];

            if (r >= 0 && c >= 0 && r <boxes.length && c <boxes.length)
            {
                if (boxes[r][c]==true)
                    return false;
            }
            else
                break;
        }
    }

    return true;
}



public static int placeQueen(int arr[],String qsf,int idx,int queenNo,int queens){
 if (queenNo>queens){
   System.out.println(qsf);
   return 1;
 }
 int count=0;
 for(int i=idx;i<arr.length;i++){
 
 count+=placeQueen(arr,qsf+"B"+i+"Q"+queenNo+" ",i+1,queenNo+1, queens);

 
 

 }
 return count+1;
 
}

public static int placeQueenBox(int arr[],String qsf,int idx,int queenNo,int queens,boolean boxes[][]){
 if (queenNo>queens){
   System.out.println(qsf);
   return 1;
 }
 int count=0;
 int n=arr.length;
 for(int i=idx;i<n*n;i++){
 int x=i/n;
 int y=i%n;
 if(isSafeToPlaceQueen(boxes,x,y)){
   boxes[x][y]=true;
count+=placeQueenBox(arr,qsf+"("+x+","+y+")",i+1,queenNo+1, queens,boxes);
  boxes[x][y]=false;
 }
 

 
 

 }
 return count;
 
}
static boolean[] rowA=new boolean[4];
static boolean[] colA=new boolean [4];
static boolean[] diag=new boolean[7];
static boolean[] adiag=new boolean[7];

public static int placeQueenBox02(int arr[],String qsf,int idx,int queens,boolean boxes[][]){
 if (queens==0){
   System.out.println(qsf);
   return 1;
 }
 int count=0;
 int n=arr.length;
 for(int i=idx;i<n*n;i++){
 int x=i/n;
 int y=i%n;
 if (!rowA[x] && !colA[y] && !diag[x - y + n - 1] && !adiag[x + y])
        {
            rowA[x] = true;
            colA[y] = true;
            diag[x - y + n - 1] = true;
            adiag[x + y] = true;
            count+=placeQueenBox02(arr,qsf+"("+x+","+y+")",i+1, queens-1,boxes);
            rowA[x] = false;
            colA[y] = false;
            diag[x - y + n - 1] = false;
            adiag[x + y] = false;
 }
 

 
 

 }
 return count;
 
}
static int col1=0;
static int diag1=0;
static int row1=0;
static int adiag1=0;
public static int placeQueenBox03(int arr[],String qsf,int idx,int queens,boolean boxes[][]){
 if (queens==0){
   System.out.println(qsf);
   return 1;
 }
 int count=0;
 int n=arr.length;
 for(int i=idx;i<n*n;i++){
 int x=i/n;
 int y=i%n;
 if ((row1 & (1<<x))==0 && (col1 & (1<<y))==0 && (diag1 & (1<<(x-y+n-1)))==0 && (adiag1 & (1<<(x + y)))==0)
        {
            row1^=(1<<x);
            col1^=(1<<y);
            diag1^=(1<<(x-y+n-1));
            adiag1^=(1<<(x+y));
            count+=placeQueenBox03(arr,qsf+"("+x+","+y+")",i+1, queens-1,boxes);
            row1^=(1<<x);
            col1^=(1<<y);
            diag1^=(1<<(x-y+n-1));
            adiag1^=(1<<(x+y));
 }
 

 
 

 }
 return count;
 
}
public static int placeQueenBox04(int arr[],String qsf,int queens,boolean boxes[][],int r){
  int n=arr.length;
 if (queens==0||r==n){
   if(queens==0){
System.out.println(qsf);
   return 1;
   }
   
   return 0;
 }
 int count=0;

 for(int i=0;i<n;i++){
 int x=r;
 int y=i;
 if ((row1 & (1<<x))==0 && (col1 & (1<<y))==0 && (diag1 & (1<<(x-y+n-1)))==0 && (adiag1 & (1<<(x + y)))==0)
        {
            row1^=(1<<x);
            col1^=(1<<y);
            diag1^=(1<<(x-y+n-1));
            adiag1^=(1<<(x+y));
            count+=placeQueenBox04(arr,qsf+"("+x+","+y+")", queens-1,boxes,r+1);
            row1^=(1<<x);
            col1^=(1<<y);
            diag1^=(1<<(x-y+n-1));
            adiag1^=(1<<(x+y));
 }
 

 
 

 }
 return count;
 
}


}