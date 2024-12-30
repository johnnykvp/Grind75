/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /* Clarify
    given head of a linked list
    determine if it has a cycle in it
    cycle: node that can be reached again by continuously iterating to next pointer
    */

    /* Approach
    create a Set that stores nodes
    while loop iterates through given linked list until null
        if statement checks current node is found in set
            return true
        add nodes to the list
    return false
    */

    /*
    public boolean hasCycle(ListNode head) {
        Set<ListNode> storage = new HashSet<>();
        while (head != null) {
            if (storage.contains(head)) {
                return true;
            }
            storage.add(head);
            head = head.next;
        }
        return false;
    }
    */

    /* Optimize
    O(n) runtime, iterates through while loop based on given linked list size
    O(n) space, create Set based on given linked list size
    can be done in O(1) space
    */

    /* Re-approach
    two pointers, one which iterates by 1 node and other which iterates by 2
    eventually the "slower" pointer will catch up to the "faster" pointer in a cycle
    
    if statement checks head is null
        return false
    create slow, fast node pointers equal to head
    while loop iterates through linked list until null
        if statement checks slow pointer equals fast pointer
            return true
        set slow to next node, set fast to next next node
    return false
    */

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        // Check next fast node to handle null pointer on no cycle
        while (fast.next != null && fast.next.next != null) {
            if (head.next == fast.next.next) {
                return true;
            }
            head = head.next;
            fast = fast.next.next;
        }
        return false;
    }
    /* Test
    Input: head = [3,2,0,-4], pos = 1
    head.next = 2, fast.next.next = 0 >> head.next = 0, fast.next.next = 2 >>
    head.next = -4, fast.next.next = -4
    Output: true

    Input: [1]
    head.next = null
    Output: false
    */
}