import java.util.ArrayList;

public class floodfill{
	public static void main(String[] args) {
        int [][] board=new int[4][4];
 pair ans=floodfill_LongestPath(0,0,3,3,board);
 System.out.println(ans.str+" "+ans.len);
    }

	static int[][] dir = {
		{
			0,
			1
		},
		{ - 1,
			1
		},
		{ - 1,
			0
		},
		{ - 1,
			-1
		},
		{
			0,
			-1
		},
		{
			1,
			-1
		},
		{
			1,
			0
		},
		{
			1,
			1
		}
	};
	static String[] dirN = {
		"R",
		"E",
		"U",
		"N",
		"L",
		"W",
		"D",
		"S"
	};

	public static int floodfill_Height(int sr, int sc, int er, int ec, int[][] board) {
		if (sr == er && sc == ec) {
			return 0;
		}

		board[sr][sc] = 2;
		int maxH = 0;
		for (int d = 0; d < dir.length; d++) {
			int r = sr + dir[d][0];
			int c = sc + dir[d][1];
			if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0) {
				int recH = floodfill_Height(r, c, er, ec, board);
				maxH = Math.max(recH, maxH);
			}
		}

		board[sr][sc] = 0;
		return maxH + 1;
	}
     static class pair {
		int len = 0;
		String str = "";

		pair(int len, String str) {
			this.len = len;
			this.str = str;
		}
	}

	public static pair floodfill_LongestPath(int sr, int sc, int er, int ec, int[][] board) {
     //base case
	 if(sr==er&&sc==ec){
		 
		 return new pair(0," ");
	 }
	 
    	board[sr][sc]=1;
      int count=0;
	 //recursive Case
	 pair max= new pair(0," ");
	 	for (int d = 0; d < dir.length; d++) {
			int r=sr+dir[d][0];
			int c=sc+dir[d][1];
			if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0) {
			     
				pair ans=floodfill_LongestPath(r,c,er,ec,board);
				if(ans.len+1>max.len){
					max.len=ans.len+1;
					max.str=ans.str+dirN[d];
				}
				

			}
		}

		board[sr][sc]=0;
        return max;
	}
}