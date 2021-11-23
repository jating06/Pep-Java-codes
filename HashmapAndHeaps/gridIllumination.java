class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashMap<Integer,Integer>rows = new HashMap<>(); 
        HashMap<Integer,Integer>cols = new HashMap<>(); 
        HashMap<Integer,Integer>diagnol1 = new HashMap<>(); 
        HashMap<Integer,Integer>diagnol2 = new HashMap<>(); 
        HashSet<Integer> bulbs = new HashSet<>();
        for(int i = 0 ; i <lamps.length;i++){
           int r = lamps[i][0];
           int c = lamps[i][1];
         
            rows.put(r,rows.getOrDefault(r,0)+1);
            cols.put(c,cols.getOrDefault(c,0)+1);
           diagnol1.put(r+c,diagnol1.getOrDefault(r+c,0)+1);
           diagnol2.put(r-c,diagnol2.getOrDefault(r-c,0)+1);
           bulbs.add(r*N+c);
        }
        int ans[] = new int[queries.length];
        int dir[][] = {{0,0},{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        for(int i = 0 ; i <queries.length;i++){
            int r = queries[i][0];
            int c = queries[i][1];
           
            if(rows.containsKey(r)||cols.containsKey(c)||diagnol1.containsKey(r+c)||diagnol2.containsKey(r-c)) {         
               
                ans[i]=1;
            }
          
              for(int d = 0 ; d<9;d++){
                  int row = r+dir[d][0];
                  int col = c+dir[d][1];
                  if(bulbs.contains(row*N+col)){
                    
                      bulbs.remove(row*N+col);
                      if(rows.containsKey(row)){
                           rows.put(row,rows.get(row)-1);
                          if(rows.get(row)==0){
                          rows.remove(row);
                      }
                      }
                     
                      if(cols.containsKey(col)){
                          cols.put(col,cols.get(col)-1);
                           if(cols.get(col)==0){
                          cols.remove(col);
                      }
                      }
                      
                      if(diagnol1.containsKey(row+col)){
                          diagnol1.put(row+col,diagnol1.get(row+col)-1);
                           if(diagnol1.get(row+col)==0){
                          diagnol1.remove(row+col);
                      }
                      }
                      
                      if(diagnol2.containsKey(row-col)){
                           diagnol2.put(row-col,diagnol2.get(row-col)-1);
                           if(diagnol2.get(row-col)==0){
                          diagnol2.remove(row-col);
                      }
                      }
                     
                   }
              }  
            
          
        }
        
        return ans;
    }
}