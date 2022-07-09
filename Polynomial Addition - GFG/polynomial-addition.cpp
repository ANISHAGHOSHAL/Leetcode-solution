// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

/* Link list Node */
struct Node
{
    int coeff;
    int pow;
    struct Node* next;
    
    Node(int c, int p){
        coeff = c;
        pow = p;
        next = NULL;
    }
    
};


void append(struct Node** head_ref, struct Node **tail_ref,
            int new_data, int new_data1)
{
    struct Node* new_node = new Node(new_data, new_data1);
    
    if (*head_ref == NULL)
        *head_ref = new_node;
    else
        (*tail_ref)->next = new_node;
    *tail_ref = new_node;
}

void printList(struct Node *head)
{
    struct Node *temp = head;
    
    while (temp != NULL)
    {
       printf("%d %d ", temp->coeff, temp->pow);
       temp  = temp->next;
    }
}

Node* addPolynomial(Node *p1, Node *p2);


void create_node(int x, int y, struct Node **temp)
{
    struct Node *r, *z;
    z = *temp;
    if(z == NULL)
    {
        r = new Node(x, y);
        *temp = r;
        r->next = NULL;
    }
    else
    {
        r->next = new Node(x, y);
        r = r->next;
        r->next = NULL;
    }
}
 

/* Driver program to test above function*/

 // } Driver Code Ends
/* Structure of Node used
struct Node
{
    int coeff;
    int pow;
    struct Node* next;
    
    Node(int c, int p){
        coeff = c;
        pow = p;
        next = NULL;
    }
    
};
*/

class Solution{
  public:
    Node* addPolynomial(Node *p1, Node *p2)
    {
        Node *sum = NULL;      // head of sum polynomial
        Node *ptr = NULL;
        
        while( p1 || p2 )
        {
            int p,c;
            
            if(p1==NULL)
            {
                // if p1 is NULL we pick values from p2
                p = p2->pow;
                c = p2->coeff;
                p2 = p2->next;
            }
            
            else if(p2==NULL)
            {
                // if p2 is NULL we pick values from p1
                p = p1->pow;
                c = p1->coeff;
                p1 = p1->next;
            }
            
            else
            {
                int pow1 = p1->pow, pow2 = p2->pow;
                
                p = max( pow1, pow2 );       // picking max power
                
                c = (p1->coeff)*(pow1 >= pow2) + (p2->coeff)*(pow2 >= pow1);
                // picking coefficient of greater power
                
                if (pow1 >= pow2) p1 = p1->next;
                if (pow2 >= pow1) p2 = p2->next;
            }
            
            if(!ptr)
                sum = ptr = new Node(c,p);
                // creating head of sum plynomial
            else
            {
                // adding new quantity to polynomial
                ptr->next = new Node(c,p);
                ptr = ptr->next;
            }
        }
        return sum;
    }


};



// { Driver Code Starts.
int main()
{
    
    int t;
    cin>>t;
    while(t--)
    {
        struct Node *poly1 = NULL, *poly2 = NULL, *poly = NULL;
        struct Node *tail1  = NULL,*tail2 = NULL;
        int n;
        cin>>n;
        for(int i=0;i<n;i++)
        {
            int x,y;
            cin>>x>>y;
            	append(&poly1,&tail1,x,y);
        }
        
         int m;
        cin>>m;
        for(int i=0;i<m;i++)
        {
            int x,y;
            cin>>x>>y;
            	append(&poly2,&tail2,x,y);
        }
        Solution obj;
        Node *sum = obj.addPolynomial(poly1,poly2);
        for(Node* ptr=sum ; ptr ; ptr=ptr->next  )
        {
            // printing polynomial
            cout<< ptr->coeff << "x^" << ptr->pow;
            if(ptr->next) cout<<" + ";
        }
        cout<<endl;
       
    }

}
  // } Driver Code Ends