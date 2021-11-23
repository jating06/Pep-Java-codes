class test{
        
public static int solve(String A) {
        boolean ans = false ;
        for(int i = 0 ; i<A.length();i++){
            String s = A.substring(0,i)+A.substring(i+1,A.length());
            System.out.println(s);
           
            if(isPalindrome(s)){
                ans = true;
                break;
            }
        }
        if(ans) return 1;
        return 0 ;
    }
    public static boolean isPalindrome(String s) {
        int i = 0 ; 
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
            
        }
        return true;
        

    }
    public static void main(String args[]){
        System.out.println(solve("daxnad"));
        // System.out.println(isPalindrome("pyyevdadveyype"));
    }
}