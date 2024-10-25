package com.andrei.add_two_numbers;

public class App {

    public static void main(String[] args) {
        // l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(9);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l2.next = l22;
//        l22.next = l23;

        ListNode rez = addTwoNumbers(l1, l2);

        while (rez != null) {
            System.out.println(rez.val);
            rez = rez.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstDigit;
        int secondDigit;
        int count = 0;

        ListNode helper = new ListNode(0);
        ListNode tail = helper;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                firstDigit = l1.val;
            } else {
                firstDigit = 0;
            }

            if (l2 != null) {
                secondDigit = l2.val;
            } else {
                secondDigit = 0;
            }

            if (firstDigit + secondDigit + count >= 10) {
                tail.next = new ListNode((firstDigit + secondDigit + count) % 10);
                tail = tail.next;
                count = 1;
            } else {
                tail.next = new ListNode(firstDigit + secondDigit + count);
                tail = tail.next;
                count = 0;
            }

            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = null;
            }

            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = null;
            }

            if (l1 == null && l2 == null && count == 1){
                tail.next = new ListNode(1);
            }
        }

        return helper.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

