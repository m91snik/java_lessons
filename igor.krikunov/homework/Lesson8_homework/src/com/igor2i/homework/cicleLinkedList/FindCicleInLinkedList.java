package com.igor2i.homework.cicleLinkedList;

/**
 * Created by igor2i on 09.08.2015.
 */
class FindCicleInLinkedList {

    /**
     * алгоритм черепахи и зайца
     * @param head
     * @return
     */
    public LNode detectCycle(LNode head) {

        LNode slow = head;
        LNode fast = head;

        while (fast != null && fast.nextNode != null){
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.nextNode == null){
            return null;
        }

        slow = head;
        while (slow != fast){
            slow = slow.nextNode;
            fast = fast.nextNode;
        }

        //точка начала петли
        return fast;
    }

}
