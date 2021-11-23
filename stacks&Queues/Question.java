import java.util.*;
class Question{
    public static void display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void ngor(int arr[] ){
        int ngor[] = new int[arr.length];
        Arrays.fill(ngor,-1);
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<arr.length;i++){
             while(st.size()>0 && arr[st.peek()]<arr[i]){
                 ngor[st.peek()] = arr[i];
                 st.pop();

        }
        st.push(i);
    }
    display(ngor);
    
}
public static void ngol(int arr[] ){
        int ngor[] = new int[arr.length];
        Arrays.fill(ngor,-1);
        Stack<Integer> st = new Stack<Integer>();
        for(int i=arr.length-1;i>=0;i--){
             while(st.size()>0 && arr[st.peek()]<arr[i]){
                 ngor[st.peek()] = arr[i];
                 st.pop();

        }
        st.push(i);
    }
    display(ngor);
    
}
class Solution {
    public boolean isValid(String s) {
        Stack<Integer>st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch=='('||ch=='{'||ch=='['){
                st.push(i);
            }
            else{
            if(st.size() == 0 ){
                return false;
            }
            else
            if(ch==')' && s.charAt(st.peek())!='(' ){
                return false;
            }
            else
           if(ch=='}' && s.charAt(st.peek())!='{' ){
                return false;
            }
            else
            if(ch==']' &&  s.charAt(st.peek())!='[' ){
                return false;
            }
            
            else {
               st.pop();
            }
            }
        }
        return st.size()==0;
        
    }
     public String removeOuterParentheses(String S) {
        int count = 0 ;
        String ans = "";
        for(int i = 0 ; i<S.length();i++){
            char ch = S.charAt(i);
            
            if(ch=='(' && count++>0){
                
                ans+=ch;
                
            }
            else if(ch==')' && count-->1 ){
                 
                ans+=ch;
                
            }
        }
        return ans;
    }
}
public int minAddToMakeValid(String S) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < S.length(); i++){
            char ch = S.charAt(i);
            if(st.size()>0 && ch==')'&& S.charAt(st.peek())=='('){
                st.pop();
            }
            else{
                st.push(i);
            }
        
    }
        return st.size();
}
 public int minAddToMakeValid02(String S) {
        int opening = 0 ;
        int closing = 0;
        for(int i = 0 ; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch=='('){
                closing++;
            }
            else if(closing>0){
                closing--;
            }
            else{
                opening++;
            }
             
}
        return opening+closing;
}
public int[] nextGreaterElements(int[] nums) {
         Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];
        Arrays.fill(ans,-1);
        int  n = nums.length;
        for(int i = 0 ; i<2*n;i++){
             int no = nums[i%n];

            while(st.size()>0 && no>nums[st.peek()]){
                ans[st.peek()] = no;
                st.pop();
            }
             if(i<n){
                st.push(i);
            }
        }
        return ans;
    }
    class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<arr.length;i++){
            int no = arr[i];
            if(no>0){   // if positive no only no collision         ----->   ---->
                
                st.push(no);
            }
            else {
                while(  st.size()>0 && st.peek()> 0 && st.peek()<-no){  // if no is negative and greater than positive top of stack
                                                                            //  ----->   <---- unequeal size
                    st.pop();
                }
                 if(st.size() == 0 || st.peek()<0){      // size == 0 due to non filling of stack or above pop operation or top of stack is negative
                     
                    st.push(no);
                }
                else
                if( st.size()>0 &&  st.peek() == -no){         // if same size no matter positive or negative
                                                                    // ----->   <----  same size
                                       
                    st.pop();
                }
                else{
                                                    //top postive no negative       //<------- -------->
                }                                                           
                
                
            }
            
             
            
    
        }
        int ans[] = new int[st.size()];
        int i = st.size()-1 ;
        while(st.size()>0){
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}
public int longestValidParenthesesSubstring(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for(int i = 0 ; i<s.length();i++){
            if(st.peek()!=-1 && s.charAt(st.peek())=='(' && s.charAt(i)==')'){
                st.pop();
                max = Math.max(max,i-st.peek());
            }
            else{
                st.push(i);
            }
            
        }
        return max;
    }
    public static void nsol(int arr[] , int nsol[] ){
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1 ; i>=0;i--){
            if(st.size()>0)
               
            while(st.size()>0 && arr[st.peek()]>arr[i]){
               
               nsol[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
      
        
    }
    public static void nsor(int arr[] , int nsol[] ){
        Stack<Integer> st = new Stack<>();
        for(int i =0 ; i<arr.length;i++){
            if(st.size()>0)
               
            while(st.size()>0 && arr[st.peek()]>arr[i]){
               
               nsol[st.peek()] =  i;
                st.pop();
            }
            st.push(i);
        }
      
        
    }
    public int largestRectangleArea(int[] heights) {
       
        int nsol[] = new int[heights.length];
         int nsor[] = new int[heights.length];
        Arrays.fill(nsol,-1);
        Arrays.fill(nsor,heights.length);
        
          nsol(heights,nsol);
          nsor(heights,nsor);
        int max = 0;
        
        for(int i = 0 ; i<heights.length;i++){
            int width = nsor[i] - nsol[i] -1 ;
            int area = width*heights[i];
            max = Math.max(max,area);
        }
      return max;  
    }
    public int largestRectangleArea_BTR(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        st.push(-1);
        int max = 0 ;
        int n = arr.length;
        for(int i = 0 ; i<arr.length;i++){
            while(st.peek()!=-1 && arr[st.peek()]>=arr[i]){
                  int height = arr[st.pop()];
                  int width = i-st.peek()-1;
                  int area = width * height;
                 max = Math.max(area,max);
                   
            }
            st.push(i);
        }
        while(st.size()!=1){
            int height = arr[st.pop()];
            int area = (n-st.peek()-1)*height;
             max = Math.max(area,max); 
        }
        
        return max;
    }
    public int trap_01(int [] height){
         int n = height.length;
       int gol[] = new int[n]; // greatest so far till ith index
         int gor[] = new int[n]

    int prev = -1;
    for (int i = 0; i < n; i++)
    {
        gol[i] = Math.max(prev, height[i]);
        prev = gol[i];
    }

    prev = -1;
    for (int i = n - 1; i >= 0; i--)
    {
        gor[i] = Math.max(prev, height[i]);
        prev = gor[i];
    }

    int twater = 0;
    for (int i = 0; i < n; i++)
        twater += Math.min(gor[i], gol[i]) - height[i];

    return twater;
    }
        public int trap_02(int[] arr) {
       Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        int water = 0;
        int n = arr.length;
       for(int i = 0 ; i<arr.length;i++){
           while(st.size()!=0 && arr[st.peek()]<=arr[i]){
               
               int h = arr[st.pop()];
               if(st.size()==0) break;
               int width  = i - st.peek()-1;
               int height = Math.min(arr[st.peek()],arr[i])-h;
               
               water = water + (height*width);
           }
           st.push(i);
       }
      
        
        return water;
    }
     public int trap_03(int[] height) {

        int n = height.length;
        int lmax = 0;
        int rmax = 0;
        int li = 0 ;
        int ri = n-1;
        int water = 0 ;
        while(li<=ri){
             lmax = Math.max(height[li],lmax);
             rmax = Math.max(height[ri],rmax);
            if(lmax<rmax){
                water+=lmax-height[li];
                li++;
            }
            else{
                water+=rmax-height[ri];
                ri--;
            }
        }
        return water;
        
    } 
    class MinStack {
       Stack<Long>st = new Stack<>();
    /** initialize your data structure here. */
    long min;
    public MinStack() {
         min = 0;
    }
    
    public void push(int x) {
        if(st.size()==0){
          st.push((long)x); 
            min=x;
        }
        else
         if(x<min){
             long  oldmin = min;
               min= x;
             st.push(2*min-oldmin);
         }
        else{
            st.push((long)x);
        }
    }
    
    public void pop() {
          if(st.size()>0 && st.peek()>min) st.pop();
           else{
             min = 2*min-st.pop();
          }
           
    }
    
    public int top() {
             
          if(st.size()>0 && st.peek()>min)
          {  
              return  st.peek().intValue();
             }
         
           return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}
 public boolean validateStackSequences(int[] pushed, int[] popped) {
         Stack<Integer>st = new Stack<>();
        int i = 0 ;
        for(int ele : pushed){
            st.push(ele);
            while(st.size()>0 && st.peek()==popped[i]){
                st.pop();
                i++;
            }
            
        }
        return st.size()==0;
    }
     public String removeKdigits(String num, int k) {
        if(num.length()==0) return "0";
         Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<num.length();i++){
               while(st.size()>0 && k>0 && num.charAt(st.peek())>num.charAt(i)){
                   st.pop();
                   k--;
               }
            st.push(i);
        }
      
        while(st.size()>0 && k-->0){
            st.pop();
        }
        String ans = "";
        while(st.size()>0){
            ans = num.charAt(st.pop())+ans;
        }
        int j = 0 ;
        while(j<ans.length() && ans.charAt(j)=='0'){
           
            j++;
        }
        ans= ans.substring(j);
        
        return ans.length()>0?ans:"0";
    }
    
    class Solution {
    public String removeDuplicateLetters(String s) {
         Stack<Integer>st = new Stack<>();
        boolean seen[] = new boolean[26];
        int freq[] = new int[26];
        for(int i = 0 ; i<s.length() ; i++){
            char ch  = s.charAt(i);
            freq[ch-'a']++;
        }
        for(int i = 0 ; i<s.length();i++){
           
            char ch = s.charAt(i);
            freq[ch-'a']--;
             if(seen[ch-'a']) continue; 
            while(st.size()>0 && s.charAt(st.peek())>ch && freq[s.charAt(st.peek())-'a']>0){   // stack khali ho jaye ya fir upar wala merse chota ho ya fir upar wala bada ho par uski freq 0 ho gyi ho
                seen[s.charAt(st.pop())-'a'] = false;            
                
            }
            if(seen[ch-'a']==false){     // fir me apne app to dal dunga
                st.push(i);
                seen[ch-'a'] = true;
            }
            
        }
       
        StringBuilder ans = new StringBuilder();
        while(st.size()>0){
            ans.append(s.charAt(st.pop()));
            }
        return ans.reverse()+"";
    }
}
public static void main(String[]args){
    int arr[] = {3,5,9,2,7};
    ngol(arr);
}
}