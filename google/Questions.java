public class nextClosestTime {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
      HashSet<Integer> hs = new HashSet<>();
      hs.add(time.charAt(0)-'0');
      hs.add(time.charAt(1)-'0');
      hs.add(time.charAt(3)-'0');
      hs.add(time.charAt(4)-'0');

      List<Integer> timeList = new ArrayList<>(hs);
      Integer minutes = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
      solve(timeList,"",minutes);
      return ans;
    }

    Integer minDiff = Integer.MAX_VALUE;
    String ans = "";
    public void solve(List<Integer> timeList , String str , Integer originalMinutes) {
        if(str.length() == 4) {
             Integer hour = Integer.parseInt(str.substring(0,2));
             Integer min = Integer.parseInt(str.substring(2));
             if(hour > 24 || min > 59){
                 return;
             }
             Integer minutes =   hour * 60 + min;
             minutes +=  (minutes > originalMinutes ? 0 : 1440);
             if(minutes-originalMinutes < minDiff){
                 minDiff =  minutes - originalMinutes;
                 ans = str.substring(0,2) + ":" + str.substring(2);
             }
             return;
        }
        

        for(int i = 0 ; i < timeList.size() ; i++){
        
            solve(timeList,str+timeList.get(i),originalMinutes);
        }
    }

}


// leetcode 904
class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0 ;  
        int j = 0 ;
        int fruitsPicked = 0;
        int maxFruitsPicked = Integer.MIN_VALUE;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(j < fruits.length){
            hm.put(fruits[j],hm.getOrDefault(fruits[j],0)+1);
            fruitsPicked ++;
            while(hm.size() > 2) {
               int rf = fruits[i];
               hm.put(rf,hm.get(rf)-1);
               fruitsPicked --;
               i++;
               if(hm.get(rf) == 0){
                hm.remove(rf);
                break;
               }
            }

            if(fruitsPicked>maxFruitsPicked){
                maxFruitsPicked = fruitsPicked; 
            }
            j++;
        }
       return maxFruitsPicked;
    }
}


// leetcode 482
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();

        int cnt = 0; 
        String temp = "";

        for(int i=0;i<n;i++){
            if(s.charAt(i)!='-'){
                cnt++;
                temp+=s.charAt(i);
            }
        }

        int firstDash = cnt%k; // divisor can't be greater than remainder so first group will always have character less than or equal to k

        String str = "";
        
        int c = 0; 

        for(int i=0;i<cnt;i++){
            if(i!=0 && (i==firstDash || c==k)){
                str+='-';
                str+=temp.charAt(i);
                c=0;
            }
            else str = str + temp.charAt(i);
            c++;
        }
        
        return str.toUpperCase();
    }
}