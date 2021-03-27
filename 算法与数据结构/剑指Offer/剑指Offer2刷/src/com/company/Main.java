package com.company;


import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().dicesProbability(2);
    }


    // 3、数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    // 4、二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int rowNum = 0;
        int columnNum = column - 1;
        while (rowNum < row && columnNum >= 0) {
            if (target == matrix[rowNum][columnNum]) {
                return true;
            } else if (target > matrix[rowNum][columnNum]) {
                rowNum++;
            } else {
                columnNum--;
            }
        }
        return false;
    }

    // 5、替换空格
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (" ".equals(str)) {
                sb.append("%20");
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    // 6、从尾到头打印链表
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    // 7、重建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelp(preorder, map, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelp(int[] preorder,
                                   HashMap<Integer, Integer> map,
                                   int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int inorderRootNum = map.get(preorder[root]);
        int leftRootNum = root + 1;
        int rightRootNum = root + inorderRootNum - left + 1;
        node.left = buildTreeHelp(preorder, map, leftRootNum, left, inorderRootNum - 1);
        node.right = buildTreeHelp(preorder, map, rightRootNum, inorderRootNum + 1, right);
        return node;
    }

    // 9、用两个栈实现队列
    class CQueue {
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty() && stack1.isEmpty()) {
                return -1;
            } else if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    // 10-1、斐波那契数列
    public int fib(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    // 10-2、青蛙跳台阶
    public int numWays(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    // 11、旋转数组的最小数字
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[right];
    }

    // 12、矩阵中的路径
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        char[] words = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (existHelp(board, words, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existHelp(char[][] board, char[] words, boolean[][] visited,
                                     int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j > board[0].length ||
                visited[i][j] || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = existHelp(board, words, visited, i + 1, j, k + 1) ||
                existHelp(board, words, visited, i - 1, j, k + 1) ||
                existHelp(board, words, visited, i, j + 1, k + 1) ||
                existHelp(board, words, visited, i, j - 1, k + 1);
        visited[i][j] = false;
        return res;
    }

    // 13、机器人的运动范围
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCountHelp(0, 0, k, visited);
    }

    private int movingCountHelp(int i, int j, int k, boolean[][] visited) {
        int sum = movingCountSum(i) + movingCountSum(j);
        if (i >= visited.length || j >= visited[0].length ||
                sum > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + movingCountHelp(i + 1, j, k, visited) + movingCountHelp(i, j + 1, k, visited);
    }

    private int movingCountSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // 14-1、剪绳子
    public int cuttingRope1(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int num1 = n / 3;
        int num2 = n % 3;
        if (num2 == 0) {
            return (int) Math.pow(3, num1);
        } else if (num2 == 1) {
            return (int) (Math.pow(3, num1 - 1) * 4);
        } else {
            return (int) (Math.pow(3, num1) * 2);
        }
    }

    // 14-2、剪绳子
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int p = 1000000007;
        long rem = 1;
        long x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if (b == 0) {
            return (int) (rem * 3 % p);
        } else if (b == 1) {
            return (int) (rem * 4 % p);
        } else {
            return (int) (rem * 6 & p);
        }
    }

    // 15、二进制中1的个数
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum += 1;
            // 消除最右边的1
            n &= n - 1;
        }
        return sum;
    }

    // 16、数值的整数次方
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            //因为数字溢出问题，导致Integer.MIN_VALUE的相反数还是他自己，
            // 所以会一直调用，直到最后出现堆栈溢出异常。
            // 所以有一种方式就是把1/x提取出来一个
            return myPow(1 / x, -n - 1) * 1 / x;
        } else {
            return n % 2 == 1 ? x * myPow(x * x, n / 2) : myPow(x * x, n / 2);
        }
    }

    // 17、打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    // 18、删除链表的节点
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        pre.next = head;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = head;
            head = head.next;
        }
        return res.next;
    }

    // 19、正则表达式匹配
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 2; i < n; i += 2) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = p.charAt(j - 1) == '*' ?
                        // p的*号前一个字符不出现
                        // p的*号前一个字符出现一次
                        // p的*号前一个字符需要出现多次：s的匹配回到前一个字符，p判断*号前一个字符
                        // p的*号前一个字符为.
                        dp[i][j - 2] || dp[i][j - 1] ||
                                dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') :
                        // 正常字符：s的前一个字符和p的前一个字符相匹配，同时比较该位置的p和s
                        // 。：s的前一个字符和p的前一个字符相匹配，p在该位为.
                        dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
            }
        }
        return dp[m - 1][n - 1];
    }

    // 20、表示数值的字符串

    // 21、调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 != 0) {
                left++;
            }
            if (nums[right] % 2 == 0) {
                right--;
            }
        }
        return nums;
    }

    // 22、链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = head;
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }

    // 24、反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 25、合并两个排序的链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode pre = new ListNode(-1);
        ListNode res = pre;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return res.next;
    }

    // 26、树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructure(A.left, B) && isSubStructure(A.right, B) && isSubStructureHelp(A, B);
    }

    private boolean isSubStructureHelp(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSubStructureHelp(A.left, B.left) && isSubStructureHelp(A.right, B.right);
    }

    // 27、二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    // 28、对称的二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSubStructureHelp(left.right, right.left) && isSubStructureHelp(left.left, right.right);
    }

    // 29、顺时针打印矩阵
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int x = 0;
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    // 30、包含min函数的栈
    class MinStack {

        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public MinStack() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            if (stack2.isEmpty() || stack2.peek() >= x) {
                stack2.push(x);
            }
            stack1.push(x);
        }

        public void pop() {
            if (stack1.peek().equals(stack2.peek())) {
                stack2.pop();
            }
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }

    // 31、栈的压入、弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) {
            return true;
        }
        int k = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int value : pushed) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popped[k]) {
                stack.pop();
                k++;
            }
        }
        return stack.isEmpty();
    }

    // 32-1、从上到下打印二叉树
    public int[] levelOrder1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // 32-2、从上到下打印二叉树
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }

    // 32-3、从上到下打印二叉树
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node);
                }
                if (node.right != null) {
                    queue.offer(node);
                }
                // 奇数层——除2为0——加在尾部
                if (res.size() % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    // 偶数层——除2为1——加在头部
                    list.addFirst(node.val);
                }
            }
            res.add(list);
        }
        return res;
    }


    // 33、二叉搜索树的后序遍历序列
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verifyPostorderHelper(postorder, postorder.length - 1, 0);
    }

    private boolean verifyPostorderHelper(int[] postorder, int rootNum, int leftStart) {
        if (leftStart >= rootNum) {
            return true;
        }
        int rightStart = leftStart;
        while (postorder[rightStart] < postorder[rootNum]) {
            rightStart++;
        }
        int temp = rightStart;
        while (temp < rootNum) {
            if (postorder[temp] > postorder[rootNum]) {
                temp++;
            } else {
                return false;
            }
        }
        return verifyPostorderHelper(postorder, rightStart - 1, leftStart) &&
                verifyPostorderHelper(postorder, rootNum - 1, rightStart);
    }

    // 34、二叉树中和为某一值的路径
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        pathSumHelper(root, sum, path, res);
        return res;
    }

    private void pathSumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        pathSumHelper(root.left, sum, path, res);
        pathSumHelper(root.right, sum, path, res);
        path.remove(path.size() - 1);
    }

    // 35、复杂链表的复制
    public Node1 copyRandomList(Node1 head) {
        if (head == null) {
            return null;
        }

        Node1 cur = head;
        while (cur != null) {
            Node1 copyNode1 = new Node1(cur.val);
            copyNode1.next = cur.next;
            cur.next = copyNode1;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node1 res = cur.next;
        Node1 moveNode1 = cur.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            while (moveNode1 != null) {
                moveNode1.next = moveNode1.next.next;
                moveNode1 = moveNode1.next;
            }
        }
        return res;
    }

    // 36、二叉搜索树与双向链表
    private Node2 treeToDoublyListPre;
    private Node2 treeToDoublyListHead;

    public Node2 treeToDoublyList(Node2 root) {
        if (root == null) {
            return null;
        }

        Node2 pre = null;
        treeToDoublyListHelper(root);

        treeToDoublyListHead.left = treeToDoublyListPre;
        treeToDoublyListPre.right = treeToDoublyListHead;
        return treeToDoublyListHead;
    }

    public void treeToDoublyListHelper(Node2 root) {
        if (root == null) {
            return;
        }
        treeToDoublyListHelper(root.left);
        if (treeToDoublyListPre != null) {
            treeToDoublyListPre.right = root;
        } else {
            treeToDoublyListHead = root;
        }
        root.left = treeToDoublyListPre;
        treeToDoublyListPre = root;
        treeToDoublyListHelper(root.right);
    }

    // 37、序列化二叉树
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        ArrayList<String> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val + "");
                } else {
                    list.add("#");
                }
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        int max = list.size() - 1;
        for (int i = max; i >= 0; i--) {
            if ("#".equals(list.get(i))) {
                list.remove(i);
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder("[" + list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(",").append(list.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] dataArr = data.substring(1, data.length() - 1).split(",");
        int index = 0;
        boolean isLeft = true;
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < dataArr.length; i++) {
            if (!"#".equals(dataArr[i])) {
                TreeNode node = new TreeNode(Integer.parseInt(dataArr[i]));
                if (isLeft) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.offer(node);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }

    // 38、字符串的排列
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        int index = 0;
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        permutationHelper(chars, index, res);
        return res.toArray(new String[res.size()]);
    }

    private void permutationHelper(char[] chars, int index, List<String> res) {
        if (index == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            permutationSwap(chars, index, i);
            permutationHelper(chars, index + 1, res);
            permutationSwap(chars, index, i);
        }
    }

    private void permutationSwap(char[] chars, int index, int i) {
        char temp = chars[index];
        chars[index] = chars[i];
        chars[i] = temp;
    }

    // 39、数组中出现次数超过一半的数字
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int k = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                k = nums[i];
            }
            sum += k == nums[i] ? 1 : -1;
        }
        return k;
    }

    // 40、最小的k个数
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        getKthFromEndSort(arr, k, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void getKthFromEndSort(int[] arr, int k, int start, int end) {
        if (start >= end || start >= k) {
            return;
        }
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        getKthFromEndSort(arr, k, start, right);
        getKthFromEndSort(arr, k, left, end);
    }

    // 41、数据流中的中位数
    class MedianFinder {

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return minHeap.peek();
            }
        }
    }

    // 42、连续子数组的最大和
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre < 0) {
                cur = nums[i];
            } else {
                cur = pre + nums[i];
            }
            pre = cur;
            max = Math.max(max, cur);
        }
        return max;
    }

    // 43、1-n整数中1出现的次数
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                // 高位决定1的次数
                res += high * digit;
            } else if (cur == 1) {
                // 高位的1次数 + 低位的次数
                res += high * digit + low + 1;
            } else {
                // 高位的1次数 + 本位的1的次数
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    // 44、数字序列中某一位的数字
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    // 45、把数组排成最小的数
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        minNumberQuickSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private void minNumberQuickSort(String[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        minNumberSort(arr, 0, arr.length - 1);
    }

    private void minNumberSort(String[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        String pivot = arr[start];
        while (left <= right) {
            while (left <= right && (pivot + arr[left]).compareTo(arr[left] + pivot) > 0) {
                left++;
            }
            while (left <= right && (pivot + arr[right]).compareTo(arr[right] + pivot) < 0) {
                right--;
            }
            if (left <= right) {
                String temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        minNumberSort(arr, left, end);
        minNumberSort(arr, start, right);
    }

    // 46、把数字翻译成字符串
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int f2 = 0;
        int f1 = 0;
        int f = 1;
        for (int i = 0; i < str.length(); i++) {
            f2 = f1;
            f1 = f;
            f = 0;
            f += f1;
            if (i == 0) {
                continue;
            }
            String pre = str.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                f += f2;
            }
        }
        return f;
    }

    // 47、礼物的最大价值
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    // 48、最长不含重复字符的子字符串
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int temp = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int num = map.getOrDefault(arr[i], -1);
            map.put(arr[i], i);
            temp = temp < i - num ? temp + 1 : i - num;
            max = Math.max(max, temp);
        }
        return max;
    }

    // 49、丑数
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int f2 = dp[a] * 2;
            int f3 = dp[b] * 3;
            int f5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(f2, f3), f5);
            if (dp[i] == f2) {
                a++;
            }
            if (dp[i] == f3) {
                b++;
            }
            if (dp[i] == f5) {
                c++;
            }
        }
        return dp[n - 1];
    }

    // 50、第一个只出现一次的字符
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    // 51、数组中的逆序对
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[nums.length];

        return reversePairsHelper(copy, 0, nums.length - 1, temp);
    }

    private int reversePairsHelper(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairsHelper(nums, left, mid, temp);
        int rightPairs = reversePairsHelper(nums, mid + 1, right, temp);

        // 优化——已经前后两个部分排序完成则无需合并
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int sumPairs = reversePairsMerge(nums, left, mid, right, temp);
        return leftPairs + rightPairs + sumPairs;
    }

    private int reversePairsMerge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int count = 0;
        int leftStart = left;
        int rightStart = mid + 1;

        for (int i = left; i <= right; i++) {
            if (leftStart > mid) {
                nums[i] = temp[rightStart];
                rightStart++;
            } else if (rightStart > right) {
                nums[i] = temp[leftStart];
                leftStart++;
            } else if (temp[leftStart] <= temp[rightStart]) {
                nums[i] = temp[leftStart];
                leftStart++;
            } else {
                nums[i] = temp[rightStart];
                rightStart++;
                count += (mid - leftStart + 1);
            }
        }
        return count;
    }

    // 52、两个链表的第一个公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            node1 = node1.next == null ? headB : node1.next;
            node2 = node1.next == null ? headA : node2.next;
        }

        return node1;
    }

    // 53-1、在排序数组中查找数字
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchHelper(nums, target) - searchHelper(nums, target - 1);
    }

    private int searchHelper(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 53-2、0-(n-1)中缺失的数字
    public int missingNumber(int[] nums) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 54、二叉搜索树的第K大节点
    private int kthLargestK = 0;
    private int kthLargestRes = 0;

    public int kthLargest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        this.kthLargestK = k;
        kthLargestHelper(root);
        return kthLargestRes;
    }

    public void kthLargestHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        kthLargestHelper(root.right);
        if (--kthLargestK == 0) {
            kthLargestRes = root.val;
            return;
        }
        kthLargestHelper(root.left);
    }

    // 55-1、二叉树的深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepthHelper(root.left);
        int right = maxDepthHelper(root.right);

        return Math.max(left, right) + 1;
    }

    // 55-2、平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalancedHelper(root) > -1;
    }

    private int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedHelper(root.left);
        if (left == -1) {
            return -1;
        }
        int right = isBalancedHelper(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    // 56-1、数组中数字出现的次数
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int first = 0;
        int second = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((div & nums[i]) == 1) {
                first ^= nums[i];
            } else {
                second ^= nums[i];
            }
        }
        int[] res = new int[2];
        res[0] = first;
        res[1] = second;
        return res;
    }

    // 56-2、数组中数字出现的次数2
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cur = 0;
            int div = 1;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (div << i)) > 0) {
                    cur++;
                }
            }
            if (cur % 3 == 1) {
                res ^= div << i;
            }
        }
        return res;
    }

    // 57-1、和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if ((nums[left] + nums[right]) == target) {
                break;
            } else if ((nums[left] + nums[right]) > target) {
                left++;
            } else {
                right--;
            }
        }
        res[0] = nums[left];
        res[1] = nums[right];
        return res;
    }

    // 57-2、和为s的连续正数序列
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        int sum = 3;
        while (left < right) {
            if (sum == target) {
                int[] arr = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    // 58-1、翻转单词顺序
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (!"".equals(arr[i])) {
                sb.append(" ").append(arr[i]);
            }
        }
        return sb.toString();
    }

    // 58-2、左旋转字符串
    public String reverseLeftWords1(String s, int n) {
        if (s == null || s.length() == 0 || n == 0) {
            return s;
        }
        int k = n % s.length();
        return s.substring(k) + s.substring(0, k);
    }

    public String reverseLeftWords2(String s, int n) {
        if (s == null || s.length() == 0 || n == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    // 59-1、滑动窗口的最大值
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = k;
        List<Integer> list = new ArrayList<>();
        while (right <= nums.length) {
            int max = nums[left];
            for (int i = left; i < right; i++) {
                max = Math.max(max, nums[i]);
            }
            list.add(max);
            left++;
            right++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    // 59-2、队列的最大值
    class MaxQueue {

        LinkedList<Integer> queue;
        LinkedList<Integer> help;

        public MaxQueue() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public int max_value() {
            if (help.isEmpty()) {
                return -1;
            } else {
                return help.peekFirst();
            }
        }

        public void push_back(int value) {
            queue.offerLast(value);
            while (!help.isEmpty() || help.peekLast() < value) {
                help.removeLast();
            }
            help.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            } else {
                if (queue.peekFirst().equals(help.peekFirst())) {
                    help.removeFirst();
                }
                return queue.pollFirst();
            }
        }
    }

    // 60、n个骰子的点数
    public double[] dicesProbability(int n) {
        if (n <= 0) {
            return new double[0];
        }

        double[] dp = new double[70];
        // 初始化第一个骰子
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }

        // 从第二个开始
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * n; j >= i; j--) {
                // 因为是从后往前逐个累加，在加到当前点数时，
                // 必须把原先存放的n-1个骰子的数据置0，否则累加出错。
                dp[j] = 0;
                for (int k = 1; k <= 6; k++) {
                    // 如果不加此判据，会取到n-2个骰子的数据，
                    // 此时可认为是“脏数据”，会导致累加出错。
                    // 从实际情况来分析，n-1个骰子的最小值就是n-1，
                    // 不会比这再小，因此此处的判据是 i-1，而不是0
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[j] += dp[j - k];
                }
            }
        }

        double num = Math.pow(6, n);
        double[] res = new double[(n * 6) - n + 1];
        for (int i = 0, j = n; i < (n * 6) - n + 1; i++, j++) {
            res[i] = dp[j] / num;
        }
        return res;
    }

    // 61、扑克牌中的顺子
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);

        int zeroNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
            }
        }
        return nums[nums.length - 1] - nums[zeroNum] < 5;
    }

    // 62、圆圈中最后剩下的数字
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    // 63、股票的最大利润
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int max = 0;
        int minPrices = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            }
            max = Math.max(max, prices[i] - max);
        }
        return max;
    }

    // 64、求1+2+...+n
    public int sumNums1(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNums1(n - 1);
    }

    public int sumNums2(int n) {
        boolean flag = n > 0 && (n += sumNums2(n - 1)) > 0;
        return n;
    }

    // 65、不用加减乘除做加法
    public int add(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp + b;
        }
        return a;
    }

    // 66、构建乘积数组
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }

        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }

        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] *= temp;
        }
        return res;
    }

    // 67、把字符串转换成整数
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int start = 0;
        int sign = 1;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '-') {
            sign = -1;
            start = 1;
        } else if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] < '0' || chars[0] > '9') {
            return 0;
        }

        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;
        for (int i = start; i < chars.length; i++) {
            char temp = chars[i];
            if (temp < '0' || temp > '9') {
                break;
            }
            if (res > bndry || (res == bndry && temp > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (temp - '0');
        }
        return res * sign;
    }

    // 68-1、二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    // 68-2、二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}