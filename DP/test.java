public static void coins (int x, int y , int operations[][] ){
    int collection = 0 ;
    for(int i  = 0 ;i<operations.length;i++){
        if(operations[i][0] == 0 ){
            if(collection>=x){
                x = x + operations[i][1];
            }
            else {
                x += 2*operations[i][1];
            }
        }
        else{
            if(collection-1>y){
                collection -= 1;
            }
            else{
                continue;
            }
        }
    }
}