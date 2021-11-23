import java.util.*;
class wordbreak{
    static HashSet<String> map=new HashSet<String>();
public static int wordBreak_(String str, String ans)
{    if(str.length()==0){
    System.out.println(ans);
      return 1;
}
    int count=0;
     for(int i=1;i<=str.length();i++){
         String ss= str.substring(0,i);
         if(map.contains(ss)){
             count+=wordBreak_(str.substring(i),ans+ss+" ");
         }
     }
     return count;
    
}

public static void wordBreak()
{
    String[] words={"like", "samsung", "i", "ilike", "sam", "sung", "and", "man", "go", "mango"};
    String word = "ilikesamsungandmango";

    for (String w : words)
        map.add(w);

	int ans=wordBreak_(word, "");
	System.out.println(ans);

}

public static void main(String[] args){
    wordBreak();
}
}