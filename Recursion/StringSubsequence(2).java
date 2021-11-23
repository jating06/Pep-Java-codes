import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) {    //combination of String
        Scanner s = new Scanner(System.in);
        String str = "aab";

        permuation(str, "", str.length());
    }
    public static void combination(String str, String asf, int idx, int length) {

        System.out.println(asf);
        for (int i = idx; i < length; i++) {
            char ch = str.charAt(i);
            combination(str, asf + ch, i + 1, length);
        }

    }
    public static void permuation(String str, String asf,  int length) {
         if(str.length()==0){
              System.out.println(asf);
             return;
         }
       
        for (int i = 0; i < str.length(); i++) {
        
            char ch = str.charAt(i);
            String ss= str.substring(0, i) + str.substring(i+1);
                System.out.println(ss);
            permuation(ss, asf + ch,  length);
        }

    }
}