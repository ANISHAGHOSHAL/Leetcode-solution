class Solution {
public:   
    ListNode* reverseList(ListNode* head) {
        ListNode*Prev=nullptr;
        ListNode*Next=nullptr;
        while(head){
            Next=head->next;
            head->next=Prev;
            Prev=head;
            head=Next;
        }
        head=Prev;
        return head;
    }

};