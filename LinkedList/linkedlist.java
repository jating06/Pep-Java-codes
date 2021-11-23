class linkedlist{
    static class Node{
              int data;
              Node next;
              Node(int data){
                  this.data = data;
                  this.next = null;
              }
                }
              Node head = null ; //
              Node tail = null;
              int size = 0; 
    
              public int size(){
                  return this.size;
              }
              public boolean isEmpty() {
                  return this.size == 0;
              }
              @Override
             public String toString() {
                  Node curr = this.head;
                  String str = "";
                  while (curr != null){
                      str+=curr.data+"->";
                      curr = curr.next;
                  }
                  return str;
              }
              void addFirst(int data){
                  Node node = new Node(data);
                  if(head == null && tail == null){
                      head = node;
                      tail = node;
                  }
                  else{
                      node.next = this.head;
                      this.head = node;
                  }
       

                  this.size++;
                   
              }
              void addLast(int data){
                  Node node = new Node(data);
                  if(head == null && tail == null){
                      head = node;
                      tail = node;
                  }
                  else{
                      tail.next = node;
                      tail = node;

                  }
                  this.size++;

              }
              Node getNodeAt(int pos){
                  
                  Node curr = this.head;
                  while(pos-->0){
                     curr=curr.next;
                  }
                  return curr;
              }
              void addAt(int data , int pos){
                 if(pos==0){
                     addFirst(data);
                 }
                 else if(pos==this.size-1){
                     addLast(data);
                 }
                 else if(pos<0 || pos>=this.size){
                     System.out.println("Invalid Position");
                     return;
                 }
                 else{
                     Node node = new Node(data);
                     Node prev = getNodeAt(pos-1);
                     Node temp = prev.next;
                     prev.next = node;
                     node.next = temp;

                 }
                 this.size++;
              }

              int removeFirst(){
                   if(head==null && tail==null){
                       System.out.println("Invalid Position");
                       return -1;
                   }
                   Node rnode = this.head;
                   if(this.size == 1 ){
                       this.head = null;
                       this.tail = null;
                   }
                   else{
                       this.head = this.head.next;
                       rnode.next  = null;
                   }
                   this.size --;
                   return rnode.data;
              }
               int removeLast(){
                   if(head==null && tail==null){
                       System.out.println("Invalid Position");
                       return -1;
                   }
                   Node rnode = this.tail;
                   if(this.size == 1 ){
                       this.head = null;
                       this.tail = null;
                   }
                   else{
                       Node sl = getNodeAt(size()-2);
                       sl.next = null;
                       tail  = sl;
                   }
                   this.size --;
                   return rnode.data;
              }
              int removeAt(int pos){
                
                  if(pos<0 || pos>=this.size) {
                   
                       System.out.println("Invalid Position");
                       return -1;
                  }
                  else
                  if(pos == 0 ){
                     return  removeFirst();
                  }
                  else if(pos == this.size - 1){
                      return removeLast();
                  }
                   
                  
                      Node rnode = getNodeAt(pos-1);
                      Node temp = rnode.next;
                      rnode.next = temp.next;
                      temp.next = null;
                      this.size --;
                      return temp.data;

                  
              }
                    public int getFirst(){
            if(this.size==0){  
                System.out.println("EmptyList!");
                return -1;
            }
            return this.head.data;  
        }

        public int getLast(){
            if(this.size==0){
                System.out.println("EmptyList!");
                return -1;
            }
            return this.tail.data;  
        }
         public int getAt(int pos){
            if(pos>=this.size || pos < 0){
                System.out.println("NullPointException!");
                return -1;
            }

            return getNodeAt(pos).data;  
        }
        static class addTwoNumbers{
        ListNode th = null;
        ListNode tt = null;
        public void addLast(ListNode node){
     if(th==null){
         th = node;
         tt = node;
     }
     else{
          tt.next = node;
         tt = node;
     }
}


           
    
          public static void main(String[] args){
                 
             linkedlist ll=new linkedlist();
        for(int i=1;i<10;i++){
            ll.addLast(i*10);
        }
        

        
        System.out.println(ll);
          }

}