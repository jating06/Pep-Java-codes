import java.util.*;
class crypto{
    static int numused=0;
    static int mapping[]=new int[26];
static int stringToNumber(String str)
{  
    int res = 0;
    for (int i = 0; i < str.length(); i++)
    {
        int idx = str.charAt(i)- 'a';
        res = res * 10 + mapping[idx];
    }
    return res;
}
    static  String s1="send";
    static    String s2="more";
    static   String s3="money";
    
    public static int cryptoSolver(String s,int idx){
         if (idx == s.length())
    {
        int a = stringToNumber(s1);
        int b = stringToNumber(s2);
        int c = stringToNumber(s3);
        String str1= ""+a;
         String str2= ""+b; 
         String str3= ""+c;


        if(a+b==c && str1.length()==s1.length()&&str2.length()==s2.length()&&str3.length()==s3.length() ){
             
            System.out.println(a+" "+b+" "+c);
            return 1;
        }
        return 0;
    }

        int count=0;
         for(int i=0;i<=9;i++){
               int mask = (1 << i);
        if ((numused & mask) == 0)
        {        numused ^= mask;
        
             mapping[s.charAt(idx)-'a']=i;
             count+=cryptoSolver(s,idx+1);
              mapping[s.charAt(idx)-'a']=0;
               numused ^= mask;
        }

        }
        return count;
    }
    public static void crypto(){
      
       String s=s1+s2+s3;
       int map[]=new int[26];
      
       for(int i=0;i<s.length();i++){
               map[s.charAt(i)-'a']++;
           
       }
        s="";
       for(int i=0;i<map.length;i++){
          if(map[i]>0){
              s+=(char)(i+'a');
          }
       }
      cryptoSolver(s,0);
    }
    public static void main(String[]args){
          crypto();
    }
}