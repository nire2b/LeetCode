package first.hot100;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode node) {
        this.val = x;
        this.next = node;
    }
}

public class linkList_04 {
    public static void main(String[] args) {
        Solution_04 solution04 = new Solution_04();
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        solution04.addTwoNumbers(node1, node8);
    }
}

class Solution_04 {
    //160.相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 1, lenB = 1;
        ListNode temp = headA;
        while (temp.next != null) {
            temp = temp.next;
            lenA++;
        }
        temp = headB;
        while (temp.next != null) {
            temp = temp.next;
            lenB++;
        }
        int n = lenA - lenB;
        int len = Math.min(lenA, lenB);
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                headA = headA.next;
            }
            for (int i = 0; i < len; i++) {
                if (headA == headB) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                headB = headB.next;
            }
            for (int i = 0; i < len; i++) {
                if (headA == headB) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (headA == headB) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
        }
        return null;
    }

    //206.反转链表
    public ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode res = head;
        ListNode pre = null;
        while (res != null) {
            temp = res.next;
            res.next = pre;
            pre = res;
            res = temp;
        }
        return pre;
    }

    //234.回文链表
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        } else if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = revers(slow.next);//黑箱方法，该方法是反转链表
        while (res != null) {
            if (head.val == res.val) {
                head = head.next;
                res = res.next;
            } else {
                return false;
            }
        }
        return true;
    }

    //141.环形链表
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //142.环形链表Ⅱ
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //21.合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else if (list1.val >= list2.val) {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return head.next;
    }

    //2.两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + n;
            if (val >= 10) {
                n = 1;
                cur.val = val - 10;
            } else if (val < 10) {
                n = 0;
                cur.val = val;
            }
            l1 = l1.next;
            l2 = l2.next;
            cur.next = new ListNode();
            cur = cur.next;
        }
        ListNode temp = l1 == null ? l2 : l1;
        while (temp != null) {
            int val = temp.val + n;
            if (val >= 10) {
                n = 1;
                cur.val = val - 10;
            } else if (val < 10) {
                n = 0;
                cur.val = val;
            }
            temp = temp.next;
            cur.next = new ListNode();
            cur = cur.next;
        }
        if (n == 1) {
            cur.val = 1;
        }
        head = revers(head);
        if (head.val == 0) {
            head = revers(head.next);
        } else {
            head = revers(head);
        }
        return head;
    }

    //19.删除链表的倒数第N个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        int len = 1;
        ListNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
            len++;
        }
        n = len-n;
        if(n==0){
            return head.next;
        }
        temp = head;
        ListNode pre = temp;
        for (int i = 0;i<n;i++){
            pre = temp;
            temp = temp.next;
        }
        pre.next = temp.next;
        return head;
    }

    //24.两两交换链表中的结点
    

    //反转链表方法
    public ListNode revers(ListNode head) {
        ListNode temp;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
