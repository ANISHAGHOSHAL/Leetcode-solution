// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;



  /* Function to print linked list */
   public static void printList(Node head)
    {
        
        while (head!= null)
        {
           System.out.print(head.data+" ");
           head = head.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
			Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
			
			LinkedList obj = new LinkedList();
			Node head = obj.sortedMerge(head1,head2);
			printList(head);
			
			t--;
			
         }
    }
}
// } Driver Code Ends


/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList
{
    //Function to merge two sorted linked list.
	Node sortedMerge(Node head1, Node head2) 
    { 
      
        //creating a dummy first node to hang the result on.
        Node dummyNode = new Node(0); 
          
        //a pointer, tail is used to store the resultant list after merging.
        Node tail = dummyNode; 
        while(true)  
        { 
            //if either list runs out, we store all the nodes of 
            //other list in link part of tail node.
            if(head1 == null) 
            { 
                tail.next = head2; 
                break; 
            } 
            if(head2 == null) 
            { 
                tail.next = head1; 
                break; 
            } 
            //comparing the data of the two lists and storing the node 
            //with smaller data in link part of the tail node.
            if(head1.data <= head2.data) 
            { 
                tail.next = head1;
                //if data in first list is smaller, we move to 
                //the next node in it.
                head1 = head1.next; 
            }  
            else
            { 
                tail.next = head2; 
                //if data in second list is smaller, we move to 
                //the next node in it.
                head2 = head2.next; 
            } 
              
            //moving to the next node.
            tail = tail.next; 
        } 
        //returning the merged list attached to dummy.
        return dummyNode.next; 
}  
}

