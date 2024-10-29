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
        /* Clarify
        given two sorted linked list heads containing ints
        merge the two lists into one sorted list
        return the head of the sorted list 
        */

        /* Approach
        create new ListNode to hold the sorted list head
        create new ListNode dummy to hold current value
        while loop iterates through list1 & list2 when both != null
            if statement checks list1 node value <= list2 node value
                add list1 node to sorted list
                point list1 to next node
            else list1 node value > list2 node value
                add list2 node to sorted list
                point list2 to next node
        if statement checks list1 != null
            set rest of sorted list to list1 remaining values
        else list2 != null
            set rest of sorted list to list2 remaining values
        return merged list head
        */

        ListNode head = new ListNode();
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = new ListNode(list1.val);
                current = current.next;
                list1 = list1.next;
            }
            else {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            current.next = list1;
        }
        else {
            current.next = list2;
        }
        // head was set to empty node on creation, set to next node to get the actual sorted list head
        return head.next;

        /* Test
        Input: list1 = [1,2], list2 = [1,3,4]
        1 = 1 >> current = [null,1] >> list1 = [2]
        2 > 1 >> current = [null,1,1] >> list2 = [3,4]
        2 < 3 >> current = [null,1,1,2] >> list1 = null
        list2 != null >> current = [null,1,1,2,3,4]
        Output: [1,1,2,3,4]

        Input: list1 = [], list2 = []
        skip loop >> current = [null, null]
        Output: null

        Input: list1 = [], list2 = [0]
        list2 != null >> current = [null,0]
        Output: [0]
        */

        /* Optimize
        O(n) runtime, iterates through while loop based on given list length
        O(n) space, create Linked List data structure based on given list length
        */
    }
}