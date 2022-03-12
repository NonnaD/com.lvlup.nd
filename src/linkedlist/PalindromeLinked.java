package linkedlist;

import java.lang.reflect.Array;
import java.util.*;

public class PalindromeLinked {

    public static void main(String[] args) {
        int fast = 0;
        int slow = 0;

        int[] arr = {1,2,3,4,5,6,7,8};

        System.out.println(arr.length);
        while(fast < arr.length){
            fast+=2;
            slow++;
        }
        System.out.println(arr[fast-1] + "f  " +  fast);
        System.out.println(arr[slow] + "f  " +  slow);
    }

     /* Definition for singly-linked list.*/
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }






        public boolean isPalindromeBruteForce(ListNode head) {
            //Brute force
            //converte to array reverse array compare with original if equals - polindrome
            List<Integer> l = new ArrayList();

            while(head != null){
                l.add(head.val);
                head = head.next;
            }

            List<Integer> reversed = new ArrayList(l);
            Collections.reverse(reversed);
            return l.equals(reversed);
        }
}



