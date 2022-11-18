/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /* Questions
        2 parameters? (Yes, 2 linked lists)
        Sorted lists? (Yes, given sorted)
        Duplicate values? (Yes, may have duplicates)
        Same sized lists? (No, may be different size)
        */
        
        /* Approach
        if statements check list1 or list2 is empty
            return the non-empty list
        list node stores merged values, with a dummy header
        current node stores current merged value
        while loop iterates until one list is null
            if statement checks list1 node less than list2 node
                add list1 node to current merge list
                list1 points to next node
            else
                add list2 node to current merge list
                list2 points to next node
            current node points to next node
        if statement checks other list is not empty
            add rest of nodes to list
        return dummy next node 
        */
        
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // Start with a dummy header (return the next of dummy at the end for the actual head)
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        // Iterate until one list is empty
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        // Check the non-empty list
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return dummy.next;
        
        /* Tests
        list1 = [1,2,4], list2 = [1,3,4]
        list1 != null, list2 != null
        >> current.next = 1, list2 = 3, current = 1 >> [*1,2,4], [x,*3,4]
        >> current.next = 1, list1 = 2, current = 1 >> [x,*2,4], [x,*3,4]
        >> current.next = 2, list1 = 4, current = 2 >> [x,x,*4], [x,*3,4]
        >> current.next = 3, list2 = 4, current = 3 >> [x,x,*4], [x,x,*4]
        >> current.next = 4, list2 = null, current = 4 >> [x,x,*4], [x,x,x]
        >> list1 != null >> current.next = 4 >> return dummy next of [null,1,1,2,3,4,4] >> [1,1,2,3,4,4]
        */
        
        /* Optimize
        O(n) runtime, iterates through single while loop
        O(n) space, created linked list based on size of given lists
        */
    }
}