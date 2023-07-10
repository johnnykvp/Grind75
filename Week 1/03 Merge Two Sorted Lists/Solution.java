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
        Given heads of 2 sorted lists
        Merge both lists into a single sorted list
        Return the head of the merged list
        */

        /* Example
        Input: list1 = [1,2], list2 = [1,3]
        Output: return head [1,1,2,3]

        Input: list1 = [], list2 = []
        Output: return []

        Input: list1 = [], list2 = [0]
        Output: return head [0]
        */

        /* Approach
        Iteratively: O(n) runtime, O(n) space
        Node stores merged list head
        Node stores current pointer on merged list
        while loop iterates through list1 & list2 until reaching end of a list
            if statement checks list1 node <= list2 node
                add list1 node value to merged list
            else 
                add list2 node value to merged list
        if statement checks list1 or list2 is not at the end
            add remaining node with pointers to list
        return merged list head
        */

        // Defaults val to 0
        ListNode head = new ListNode();
        ListNode current = head;
        // Use && instead of ||, null pointer will occur
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
        // Head set to default value node
        return head.next;

        /* Test
        Input: list1 = [1,2], list2 = [1,3]
        1 <= 1 >> head = [1] >> list1 = [2]
        2 > 1 >> current = [1,1] >> list2 = [3]
        2 <= 3 >> current = [1,1,2] >> list1 = null
        current = [1,1,2,3]
        Output: return head [1,1,2,3]

        Input: list1 = [], list2 = []
        Output: return []

        Input: list1 = [], list2 = [0]
        current = [0]
        Output: return head [0]
        */
    }
}