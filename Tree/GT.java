import java.util.*;
class GT{
    static class Node{
        int data;
        ArrayList<Node>childs;
        Node(int data){
            this.data = data;
            childs = new ArrayList<>();
        }
    }
    static Node construct(int arr[]){
        LinkedList<Node> st = new LinkedList<>();
        for(int  i = 0 ; i<arr.length-1;i++){
            if(arr[i]!=-1){
                st.addFirst(new Node(arr[i]));
            }
            else{
                Node node = st.removeFirst();
                st.getFirst().childs.add(node);
            }
        }
          return st.removeFirst();
    }
    public static void display(Node node){
    
    String str="";
    str+=(node.data + " -> ");
    
    

    for(Node child:node.childs){
        str+=child.data + " ";
    }

    System.out.println(str);
    
    for(Node child:node.childs){
        display(child);
    }
}
public static ArrayList<Integer> rootTONodePath(Node node , int data){
   ArrayList<Integer>res =  new ArrayList<Integer>();
    if(node.data == data){
       res.add(data);
       return res;
    }
    for(Node childs : node.childs){
        res = rootTONodePath(childs,data);
         if(res.size()>0){
        res.add(node.data);
        return res;
         }
    }
   
    return new ArrayList<>();
}
public static boolean rootTONodePath_02(Node node , int data ,ArrayList<Integer>res ){
   
    if(node.data == data){
       res.add(data);
       return true;
    }
    boolean rd = false;
    for(Node childs : node.childs){
        rd = rootTONodePath_02(childs,data,res);
         if(rd){
        res.add(node.data);
        return true;
         }
    }
   
    return false;
}
public static boolean isMirror(Node root1 , Node root2){
    if(root1.data!=root2.data && root1.childs.size()!=root2.childs.size()){
        return false; 
    }
    boolean ismirror = true;
    for(int i = 0 ; i < root1.childs.size(); i++){
        ismirror = ismirror &&  isMirror(root1.childs.get(i),root2.childs.get(root2.childs.size()-1));
    }
    return ismirror;
}

public static Node linearize(Node node){
   if(node.childs.size()==0){
       return node;
   }
    int n = node.childs.size();
      Node lastKtail = linearize(node.childs.get(n-1));
        for(int i = n-2; i>=0 ; i--){
            Node skt = linearize(node.childs.get(i));
            skt.childs.add(node.childs.get(i+1));
            node.childs.remove(node.childs.size()-1);
        }
       
 
    return lastKtail;
}
public static Node flattern(Node node){
    ArrayList<Node> nchilds=new ArrayList<>();
         for(Node child:node.childs){
             flattern(child);
             nchilds.add(child);
             for(Node e : child.childs){
                 nchilds.add(e);
             }
             child.childs.clear();
         }
         node.childs.clear();
         node.childs = nchilds;
         return node;
}
    public static void main(String args[]){
          int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
              Node root = construct(arr);
                flattern(root);
              display(root);
    }
}