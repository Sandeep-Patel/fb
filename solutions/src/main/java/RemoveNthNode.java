public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public class ListNode {
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


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void printLinkedList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }
    
    void check(ListNode expectedHead, ListNode outputHead) {
        boolean result = true;
        ListNode tempExpectedHead = expectedHead;
        ListNode tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.val == outputHead.val);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    ListNode createLinkedList(int[] arr) {
        ListNode head = null;
        ListNode tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new ListNode(v);
                tempHead = head;
            } else {
                head.next = new ListNode(v);
                head = head.next;
            }
        }
        return tempHead;
    }
    
    public void run() {

        int[] arr_1 = {1, 2, 3};
        int[] expected1 = {1, 3};
        ListNode head_1 = createLinkedList(arr_1);
        ListNode expected_1 = createLinkedList(expected1);
        ListNode output_1 = removeNthFromEnd(head_1, 2);
        check(expected_1, output_1);

        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {2, 18, 24, 3, 5, 9, 6, 12};
        ListNode head_2 = createLinkedList(arr_2);
        ListNode expected_2 = createLinkedList(expected2);
        ListNode output_2 = removeNthFromEnd(head_2, 4);
        check(expected_2, output_2);



        // Add your own test cases here

    }
    public static void main(String[] args) {
        new RemoveNthNode().run();
    }
}
