class solution{

    // T[i][k][0] = Max(T[i-1][k][0],T[i-1][k][1]+val);
    // T[i][k][1] = Max(T[i-1][k][1],T[i-1][k-1][0]-val);
     public int OneTransactionAllowed(int[] prices) {
        int tiIO = 0;
        int tiII = Integer.MIN_VALUE;
        for(int val : prices){
            tiIO = Math.max(tiIO,tiII+val);
            tiII = Math.max(tiII,-val);
        }
        return tiIO;
        
        
    }


    public int InfTransactionsAllowed(int[] prices) {
        int tikO = 0;
        int tikI = Integer.MIN_VALUE;
        for(int val : prices){
            int temp  = tikO;
            tikO = Math.max(tikO,tikI+val);
            tikI = Math.max(tikI,temp-val);
        }
        return tikO;
        
        
    }
     public int InfTransactionsAllowedwithFee(int[] prices,int fee) {
        int tiIO = 0;
        int tiII = Integer.MIN_VALUE;
        for(int val : prices){
            int temp  = tiIO;
            tiIO = Math.max(tiIO,tiII+val);
            tiII = Math.max(tiII,temp-val-fee);
        }
        return tiIO;
        
        
    }
      public int InfTransactionWithCooldown(int[] prices) {
         int tik0 = 0; ;
        int tik1 = Integer.MIN_VALUE;
        int tik0Old = tik0;
        for(int val:prices){
            int temp = tik0;
            tik0 = Math.max(tik0,tik1+val);
            tik1 = Math.max(tik1,tik0Old-val);
            tik0Old = temp;
        }
        return tik0;
    }
      public int TwoTransactionsAllowed(int[] prices) {
        int ti20 = 0;
        int ti21 = Integer.MIN_VALUE;
        int ti10  = 0;
        int ti11 = Integer.MIN_VALUE;
        for(int val : prices){
            ti20 = Math.max(ti20,ti21+val);
            ti21 = Math.max(ti21,ti10-val);
            ti10 = Math.max(ti10,ti11+val);
            ti11 = Math.max(ti11,-val);
        }
        return ti20;
    }
}