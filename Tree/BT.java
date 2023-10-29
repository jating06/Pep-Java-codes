import java.util.*;
class BT {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;

        }
    }

    static int idx = 0;
    public static Node construct(int[] arr) {
        if (idx >= arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }

        Node node = new Node(arr[idx++]); // Node* node=new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);

        return node;
    }
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static int size(Node node) {
        if (node == null) {
            return 0;

        }
        int size = size(node.left) + size(node.right);
        return size + 1;
    }
    public static int height(Node node) {
        if (node == null) {
            return -1;

        }
        int height = Math.max(height(node.left), height(node.right));
        return height + 1;

    }

    public static int maximum(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        int left = maximum(node.left);
        int right = maximum(node.right);
        max = Math.max(left, Math.max(right, node.data));
        return max;
    }

    public static int minimum(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        int left = minimum(node.left);
        int right = minimum(node.right);
        min = Math.min(left, Math.min(right, node.data));
        return min;

    }
    static ArrayList < Integer > NodeToRootPath;
    public static void NodeToRootPath(Node node, int data) {
        if (node == null) {
            return;
        }
        if (node.data == data) {
            NodeToRootPath.add(data);
            return;
        }
        NodeToRootPath(node.left, data);
        NodeToRootPath(node.right, data);
        if (NodeToRootPath.size() > 0) {
            NodeToRootPath.add(node.data);
            return;
        }
    }
    public static ArrayList < Node > NodeToRootPath_02(Node node, int data) {
        ArrayList < Node > res = new ArrayList < Node > ();
        if (node == null) {
            return res;
        }

        if (node.data == data) {

            res.add(node);
            return res;
        }

        res = NodeToRootPath_02(node.left, data);
        if (res.size() > 0) {
            res.add(node);
            return res;
        }

        res = NodeToRootPath_02(node.right, data);
        if (res.size() > 0) {
            res.add(node);
            return res;
        }

        return res;
    }

    public static int lca(Node node, int n1, int n2) {
        ArrayList < Node > a1 = NodeToRootPath_02(node, n1);
        ArrayList < Node > a2 = NodeToRootPath_02(node, n2);
        int i = a1.size() - 1;
        int j = a2.size() - 1;
        while (i >= 0 && j >= 0 && a1.get(i).data == a2.get(i).data) {
            i--;
            j--;
        }
        return a1.get(i).data;
    }
    static Node lca = null;
    public static boolean lca_02(Node node, int n1, int n2) {
        if (node == null) {
            return false;
        }
        boolean selfDone = false;
        if (node.data == n1 || node.data == n2) {
            selfDone = true;
        }

        boolean left = lca_02(node.left, n1, n2);
        if (lca != null) {
            return true;
        }

        boolean right = lca_02(node.right, n1, n2);
        if (lca != null) {
            return true;
        }

        if ((left && selfDone) || (right & selfDone) || (right & left)) {

            lca = node;

        }
        return left || right || selfDone;


    }
    public Node lcaDeepestLeaves(Node node) {
        int lh = height(node.left);
        int rh = height(node.right);
        if (lh == rh) {
            return node;
        }
        if (lh > rh) {
            return lcaDeepestLeaves(node.left);
        }
        return lcaDeepestLeaves(node.right);
    }

    public static void kLevelsDown(Node node, int k, Node blocker) {
        if (node == null || node == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }
        kLevelsDown(node.left, k - 1, blocker);
        kLevelsDown(node.right, k - 1, blocker);

    }
    public static void kLevelsDown_02(Node node, int k) { //without blocker
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }
        kLevelsDown_02(node.left, k - 1);
        kLevelsDown_02(node.right, k - 1);

    }
    public static void kNodesAway(Node node, int target, int k) {
        ArrayList < Node > path = NodeToRootPath_02(node, target);
        Node blocker = null;
        for (int i = 0; i < path.size(); i++) {
            if (k - i < 0) break;
            kLevelsDown(path.get(i), k - i, blocker);
            blocker = path.get(i);
        }
    }
    public static int kNodesAway_02(Node root, int target, int K) {
        if (root == null) return -1;

        if (root.data == target) {
            kLevelsDown(root, K, null);
            return 1;
        }

        int leftdistance = kNodesAway_02(root.left, target, K);
        if (leftdistance != -1) {
            if (K - leftdistance >= 0) kLevelsDown(root, K - leftdistance, root.left);
            return leftdistance + 1;
        }

        int rightdistance = kNodesAway_02(root.right, target, K);
        if (rightdistance != -1) {
            if (K - rightdistance >= 0) kLevelsDown(root, K - rightdistance, root.right);
            return rightdistance + 1;
        }

        return -1;

    }

    public static int kNodesAway_03(Node node, int target, int k) {
        if (node == null) {
            return -1;
        }
        if (node.data == target) {
            kLevelsDown_02(node, k);
            return 1;
        }

        int leftDistance = kNodesAway_03(node.left, target, k);
        if (leftDistance != -1) {
            if (k - leftDistance == 0) System.out.print(node.data);
            else
                kLevelsDown_02(node.right, k - leftDistance - 1);
            return leftDistance + 1;
        }
        int rightDistance = kNodesAway_03(node.right, target, k);
        if (rightDistance != -1) {
            if (k - rightDistance == 0) System.out.print(node.data);
            else
                kLevelsDown_02(node.left, k - rightDistance - 1);
            return rightDistance + 1;
        }


        return -1;


    }

    public static int Diameter(Node node) { // O(n2) Solution
        if (node == null) {
            return 0;
        }
        int ld = Diameter(node.left);
        int rd = Diameter(node.right);

        int lh = height(node.left);
        int rh = height(node.right);

        int myDia = lh + rh + 2;
        int MaxDiameter = Math.max(ld, Math.max(myDia, rd));

        return MaxDiameter;

    }
    static int diameter = 0;
    public static int Diameter_02(Node node) { // O(n) Solution
        if (node == null) {
            return -1;
        }
        int lh = Diameter_02(node.left);
        int rh = Diameter_02(node.right);
        diameter = Math.max(diameter, lh + rh + 2);
        return Math.max(lh, rh) + 1;

    }
    static class DiaPair {
        int height;
        int diameter;
        DiaPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
        DiaPair() {

        }
    }
    public static DiaPair Diameter_03(Node node) { // O(n2) Solution
        if (node == null) {
            return new DiaPair(-1, 0);
        }
        DiaPair lp = Diameter_03(node.left);
        DiaPair rp = Diameter_03(node.right);
        DiaPair myPair = new DiaPair();
        myPair.height = Math.max(lp.height, rp.height) + 1;
        myPair.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));
        return myPair;

    }

    //https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
    static int ms;
    public static int leafToLeaf(Node root) {
        ms = (int) - 1e8;
        leafToLeaf(root);
        return ms;
    }


    public static int leafToLeaf_(Node node) {
        if (node == null) return 0;

        int ls = leafToLeaf(node.left);
        int rs = leafToLeaf(node.right);

        if (node.left != null && node.right != null) {
            ms = Math.max(ms, ls + rs + node.data);
            return Math.max(ls, rs) + node.data;
        }

        return (node.left == null ? rs : ls) + node.data;
    }



    static int maxsum;
    public static int NodeToNodeMAXSUM_(Node root) { // leetcode 124
        maxsum = (int) - 1e8;
        NodeToNodeMAXSUM(root);
        return maxsum;
    }


    public static int NodeToNodeMAXSUM(Node node) {
        if (node == null) return 0;

        int ls = NodeToNodeMAXSUM(node.left);
        int rs = NodeToNodeMAXSUM(node.right);
        int max = Math.max(ls, rs);
        maxsum = Math.max(maxsum, max + node.data);

        maxsum = Math.max(maxsum, ls + rs + node.data);
        maxsum = Math.max(maxsum, node.data);
        return Math.max(node.data, max + node.data);
    }

    public static void levelOrder_01(Node node) {
        LinkedList < Node > q1 = new LinkedList < > ();
        LinkedList < Node > q2 = new LinkedList < > ();
        q1.push(node);
        int level = 0;
        while (q1.size() != 0) {
            Node top = q1.removeFirst();
            System.out.print(top.data + " ");
            if (top.left != null) {
                q2.addLast(top.left);
            }
            if (top.right != null) {
                q2.addLast(top.right);
            }
            if (q1.size() == 0) {
                level++;
                System.out.println();
                LinkedList < Node > temp = new LinkedList < > ();
                temp = q1;
                q1 = q2;
                q2 = temp;
            }

        }
        System.out.println();
        System.out.println(level);
    }

    public static void levelOrder_02(Node node) {
        LinkedList < Node > q1 = new LinkedList < > ();

        q1.push(node);
        q1.addLast(null);
        int level = 0;
        while (q1.size() != 1) {


            Node top = q1.removeFirst();

            System.out.print(top.data + " ");
            if (top.left != null) {
                q1.addLast(top.left);
            }
            if (top.right != null) {
                q1.addLast(top.right);
            }
            if (q1.getFirst() == null && q1.size() > 1) {
                System.out.println();
                q1.removeFirst();
                q1.addLast(null);
                level++;
            }


        }
        System.out.println();
        System.out.println(level + 1);
    }

    public static void levelOrder_03(Node node) {
        LinkedList < Node > q1 = new LinkedList < > ();

        q1.push(node);

        int level = 0;
        while (q1.size() != 0) {

            int size = q1.size();
            while (size-- > 0) {
                Node top = q1.removeFirst();
                System.out.print(top.data + " ");
                if (top.left != null) {
                    q1.addLast(top.left);

                }
                if (top.right != null) {
                    q1.addLast(top.right);
                }
            }
            System.out.println();
            level++;
        }
        System.out.println();
        System.out.println(level);

    }


    public static int leftMost = 0;
    public static int rightMost = 0;

    public static int width(Node node, int lvl) {
        if (node == null) return 0;

        int lw = width(node.left, lvl - 1);
        int rw = width(node.right, lvl + 1);
        leftMost = Math.min(lw, leftMost);
        rightMost = Math.max(rw, rightMost);
        return lvl;

    }

    public static void width_(Node node, int lvl) { // without return type
        if (node == null) return;
        leftMost = Math.min(leftMost, lvl);
        rightMost = Math.max(rightMost, lvl);
        width_(node.left, lvl - 1);
        width_(node.right, lvl + 1);
    }

    public static void verticalPrint(Node node) {

        class VP {
            Node self;
            int level;
            VP(Node self, int level) {
                this.self = self;
                this.level = level;
            }
        }
        width(node, 0);
        int width = -(leftMost) + rightMost;
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        for (int i = 0; i < width + 1; i++)
            ans.add(new ArrayList < > ());
        LinkedList < VP > q1 = new LinkedList < > ();

        q1.push(new VP(node, 0));


        while (q1.size() != 0) {

            int size = q1.size();

            while (size-- > 0) {
                VP top = q1.removeFirst();
                ans.get(top.level + Math.abs(leftMost)).add(top.self.data);
                if (top.self.left != null) {
                    q1.addLast(new VP(top.self.left, top.level - 1));

                }
                if (top.self.right != null) {
                    q1.addLast(new VP(top.self.right, top.level + 1));
                }


            }




        }
        System.out.println(ans);


    }
    public static void verticalPrintSum(Node node) {

        class VP {
            Node self;
            int level;
            VP(Node self, int level) {
                this.self = self;
                this.level = level;
            }
        }
        width(node, 0);
        int width = -(leftMost) + rightMost;
        int ans[] = new int[width + 1];

        LinkedList < VP > q1 = new LinkedList < > ();
        q1.push(new VP(node, 0));


        while (q1.size() != 0) {

            int size = q1.size();

            while (size-- > 0) {
                VP top = q1.removeFirst();
                ans[top.level] += top.self.data;
                if (top.self.left != null) {
                    q1.addLast(new VP(top.self.left, top.level - 1));

                }
                if (top.self.right != null) {
                    q1.addLast(new VP(top.self.right, top.level + 1));
                }


            }




        }
        System.out.println(ans);


    }

    //View=====================================================================

    public static void leftView(Node node) {
        LinkedList < Node > q1 = new LinkedList < > ();

        q1.push(node);

        int level = 0;
        while (q1.size() != 0) {

            int size = q1.size();
            System.out.print(q1.getFirst().data + " ");
            while (size-- > 0) {
                Node top = q1.removeFirst();

                if (top.left != null) {
                    q1.addLast(top.left);

                }
                if (top.right != null) {
                    q1.addLast(top.right);
                }
            }


        }

    }


    public static void rightView(Node node) {
        LinkedList < Node > q1 = new LinkedList < > ();

        q1.push(node);

        int level = 0;
        Node prev = null;
        while (q1.size() != 0) {

            int size = q1.size();

            while (size-- > 0) {
                Node top = q1.removeFirst();

                if (top.left != null) {
                    q1.addLast(top.left);

                }
                if (top.right != null) {
                    q1.addLast(top.right);
                }
                prev = top;

            }
            System.out.print(prev.data + " ");



        }

    }

    public static void BottomView(Node node) {
        class VP {
            Node self;
            int level;
            VP(Node self, int level) {
                this.self = self;
                this.level = level;
            }
        }
        width(node, 0);
        int width = -(leftMost) + rightMost;
        int ans[] = new int[width + 1];

        LinkedList < VP > q1 = new LinkedList < > ();
        q1.push(new VP(node, 0));


        while (q1.size() != 0) {

            int size = q1.size();

            while (size-- > 0) {
                VP top = q1.removeFirst();
                ans[top.level + Math.abs(leftMost)] = top.self.data;
                if (top.self.left != null) {
                    q1.addLast(new VP(top.self.left, top.level - 1));

                }
                if (top.self.right != null) {
                    q1.addLast(new VP(top.self.right, top.level + 1));
                }


            }




        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public static void TopView(Node node) {
        class VP {
            Node self;
            int level;
            VP(Node self, int level) {
                this.self = self;
                this.level = level;
            }
        }
        width(node, 0);
        int width = -(leftMost) + rightMost;
        int ans[] = new int[width + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        LinkedList < VP > q1 = new LinkedList < > ();
        q1.push(new VP(node, Math.abs(leftMost)));


        while (q1.size() != 0) {

            int size = q1.size();

            while (size-- > 0) {
                VP top = q1.removeFirst();
                if (ans[top.level] == -1)
                    ans[top.level] = top.self.data;
                if (top.self.left != null) {
                    q1.addLast(new VP(top.self.left, top.level - 1));

                }
                if (top.self.right != null) {
                    q1.addLast(new VP(top.self.right, top.level + 1));
                }


            }




        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int leftDMost = 0;
    public static void Diagnolwidth(Node node, int lvl) {
        if (node == null) 
            return;

        Diagnolwidth(node.left, lvl - 1);
        Diagnolwidth(node.right, lvl);
        leftDMost = Math.min(lvl, leftDMost);
    }
    public static void DiagnolTraversal(Node node) {
        class DP {
            Node node;
            int level;
            DP(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }
        Diagnolwidth(node, 0);
        ArrayList < ArrayList < Integer >> width = new ArrayList < > ();
        for (int i = 0; i < -leftDMost + 1; i++) {
            width.add(new ArrayList < > ());
        }

        LinkedList < DP > q = new LinkedList < > ();
        q.addLast(new DP(node, -leftDMost));
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                DP top = q.removeFirst();
                width.get(top.level).add(top.node.data);
                if (top.node.left != null) {
                    q.addLast(new DP(top.node.left, top.level - 1));
                }
                if (top.node.right != null) {
                    q.addLast(new DP(top.node.right, top.level));
                }
            }
        }
        System.out.println(width);




    }

    static Node head = null;
    static Node prev = null;


    public static void TreeToDLL_(Node node) {
        if (node == null) {
            return;
        }
        TreeToDLL_(node.left);
        if (head == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;

        }
        prev = node;

        TreeToDLL_(node.right);



    }


    public static void TreeToDLL(Node node) {
        TreeToDLL_(node);
        while (head != null) {
            System.out.println(head.data);
            head = head.right;
        }
    }

    
    static Node pred = null;
    static Node succ = null;
    static Node previous = null;
    public static void PreAndSucc(Node node, int data) {
        if (node == null) return;


        if (node.data == data && pred == null) {
            pred = previous;
        } else if (previous != null && previous.data == data && succ == null) {
            succ = node;
        }
        previous = node;
        PreAndSucc(node.left, data);
        PreAndSucc(node.right, data);
    }
    static class tpair {
        Node node;
        int state;
        tpair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void ItrPreorder(Node node) {
        Stack < tpair > st = new Stack < > ();
        st.push(new tpair(node, -1));

        while (st.size() != 0) {
            tpair top = st.peek();
            if (top.state == -1) {

                System.out.print(top.node.data + " ");
                top.state++;
            } else if (top.state == 0) {
                if (top.node.left != null)
                    st.push(new tpair(top.node.left, -1));
                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null)
                    st.push(new tpair(top.node.right, -1));
                top.state++;
            } else {
                st.pop();
            }
        }

    }
    static class thpair {
        Node node;
        int state;
        int lh;
        int rh;
        int h;
        boolean isleft = false;

        thpair(Node node, int state, boolean isleft) {
            this.node = node;
            this.state = state;
            this.isleft = isleft;
            int lh = -1;
            int rh = -1;
            int h = -1;


        }
    }
    public static void ItrHeight(Node node) {
        Stack < thpair > st = new Stack < > ();
        st.push(new thpair(node, -1, false));
        thpair ans = null;
        while (st.size() > 0) {
            thpair top = st.peek();
            if (top.state == -1) {
                if (top.node.left != null)
                    st.push(new thpair(top.node.left, -1, true));
                top.state++;
            } else if (top.state == 0) {
                if (top.node.right != null)
                    st.push(new thpair(top.node.right, -1, false));
                top.state++;
            } else if (top.state == 1) {
                top.h = Math.max(top.lh, top.rh) + 1;
                top.state++;
            } else {
                ans = st.pop();
                if (st.size() > 0) {
                    top = st.peek();
                    if (ans.isleft == true) {
                        top.rh = ans.h;
                    } else {
                        top.lh = ans.h;
                    }
                }
            }
        }
        System.out.println(ans.h - 1);

    }
    static Node rightMostOfLeft(Node node, Node curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
    }
    static void morrisInorder(Node node) {
        Node curr = node;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.data);
                curr = curr.right;
            } else {
                Node leftNode = curr.left;
                Node rightMostOfLeft = rightMostOfLeft(leftNode, curr);
                if (rightMostOfLeft.right == null) { //create a thread
                    rightMostOfLeft.right = curr;
                    curr = curr.left;
                } else { // break the thread
                    rightMostOfLeft.right = null;
                    System.out.println(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
    }
    static void morrisPreorder(Node node) {
        Node curr = node;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.data);
                curr = curr.right;
            } else {
                Node leftNode = curr.left;
                Node rightMostOfLeft = rightMostOfLeft(leftNode, curr);
                if (rightMostOfLeft.right == null) { //create a thread
                    System.out.println(curr.data);
                    rightMostOfLeft.right = curr;
                    curr = curr.left;
                } else { // break the thread
                    rightMostOfLeft.right = null;

                    curr = curr.right;
                }
            }
        }
    }
    public static Node constructFromPreAndIn(int isi, int iei, int psi, int pei, int in [], int pre[]) {
        if (isi > iei || psi > pei) {
            return null;
        }
        Node node = new Node(pre[psi]);
        int idx = isi;
        while ( in [idx] != node.data) {
            idx++;
        }
        int tel = idx - psi;
        node.left = constructFromPreAndIn(isi, idx - 1, psi + 1, psi + tel, in , pre);
        node.right = constructFromPreAndIn(idx + 1, iei, psi + tel + 1, pei, in , pre);
        return node;
    }
    public static Node constructFromPostAndIn(int isi, int iei, int psi, int pei, int in [], int pre[]) {
        if (isi > iei || psi > pei) {
            return null;
        }
        Node node = new Node(pre[pei]);
        int idx = isi;
        while ( in [idx] != node.data) {
            idx++;
        }
        int tel = idx - isi;
        node.left = constructFromPostAndIn(isi, idx - 1, psi, psi + tel - 1, in , pre);
        node.right = constructFromPostAndIn(idx + 1, iei, psi + tel, pei - 1, in , pre);
        return node;
    }
    public static Node constructFromPostAndPre(int ppsi, int ppei, int psi, int pei, int post[], int pre[]) {
        if (ppsi > ppei || psi > pei) {
            return null;
        }
        if (ppsi == ppei) {
            return new Node(post[ppsi]);
        }
        Node node = new Node(pre[psi]);
        int idx = ppsi;
        while (post[idx] != pre[psi + 1]) {
            idx++;
        }
        int tel = idx - ppsi + 1;
        node.left = constructFromPostAndPre(ppsi, ppsi + tel - 1, psi + 1, psi + tel, post, pre);
        node.right = constructFromPostAndPre(ppsi + tel, ppei - 1, psi + tel + 1, pei, post, pre);

        return node;
    }
    class constructFromInAndLevelOrder {
        HashMap < Integer, Integer > hs = new HashMap < > ();
        Node buildTree(int inord[], int level[]) {
            hs = new HashMap < > ();
            for (int i = 0; i < inord.length; i++) {
                hs.put(inord[i], i);
            }

            return buildTree_(inord, level, 0, inord.length - 1);
        }
        Node buildTree_(int inord[], int level[], int isi, int iei) {
            if (isi > iei) {
                return null;
            }
            int idx = 0;
            Node node = new Node(level[0]);

            while (inord[idx] != node.data) {
                idx++;
            }


            int k1 = 0;
            int k2 = 0;
            int levelLeft[] = new int[idx - isi];
            int levelRight[] = new int[iei - idx];
            for (int i = 1; i < level.length; i++) {
                int j = hs.get(level[i]);
                if (j >= isi && j < idx) {
                    levelLeft[k1] = level[i];
                    k1++;
                } else {
                    levelRight[k2] = level[i];
                    k2++;
                }
            }
            node.left = buildTree_(inord, levelLeft, isi, idx - 1);
            node.right = buildTree_(inord, levelRight, idx + 1, iei);
            return node;
        }

    }


    public static void AllLeftNodes(Node node) {
        while (node != null) {
            s1.push(node);
            node = node.left;
        }
    }
    public static void AllRightNodes(Node node) {
        while (node != null) {
            s2.push(node);
            node = node.right;
        }
    }
    static Stack < Node > s1 = new Stack < > ();
    static Stack < Node > s2 = new Stack < > ();


    //leetcode 653
    public static void targetSum(Node node, int tar) {


        AllLeftNodes(node);
        AllRightNodes(node);
        while (s1.size() != 0 && s2.size() != 0 && s1.peek() != s2.peek()) {
            Node n1 = s1.peek();
            Node n2 = s2.peek();
            int sum = n1.data + n2.data;
            if (sum == tar) {
                System.out.println(n1.data + " " + n2.data);
                AllLeftNodes(s1.pop().right);
                AllRightNodes(s2.pop().left);
            } else if (sum < tar) {
                AllLeftNodes(s1.pop().right);

            } else {
                AllRightNodes(s2.pop().left);



                );
            }
        }

    }

    static int sum = 0;
    static void imageMultiplication(Node img1, Node img2) {
        if (img1 == null || img2 == null) {
            return;
        }
        sum += img1.data * img2.data;
        imageMultiplication(img1.left, img2.right);
        imageMultiplication(img1.right, img2.left);
    }

    class BoundaryTraversal {
        ArrayList < Integer > ans = new ArrayList < > ();
        void AllLeftNodes(Node node) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                return;
            }
            if (node.left != null) {
                ans.add(node.data);
                AllLeftNodes(node.left);
            } else {
                ans.add(node.data);
                AllLeftNodes(node.right);
            }

        }
        void AllLeafNodes(Node node) {
            if (node == null) {
                return;

            }

            AllLeafNodes(node.left);
            if (node.left == null && node.right == null) {
                ans.add(node.data);
                return;
            }
            AllLeafNodes(node.right);

        }
        void AllRightNodes(Node node) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                return;
            }
            if (node.right != null) {

                AllRightNodes(node.right);
                ans.add(node.data);
            } else {

                AllRightNodes(node.left);
                ans.add(node.data);
            }
        }
        ArrayList < Integer > printBoundary(Node node) {
            ans.add(node.data);
            AllLeftNodes(node.left);
            AllLeafNodes(node);

            AllRightNodes(node.right);
            return ans;

        }
    }
    public static void connect(Node p) {
        p.nextRight = null;
        connect_(p);
    }

    public static void connect_(Node p) {
        {
            if (p == null) {
                return;
            }
            if (p.left != null) {
                p.left.nextRight = p.right;
            }
            if (p.right != null) {
                if (p.nextRight != null) {
                    p.right.nextRight = p.nextRight.left;
                } else {
                    p.right.nextRight = null;
                }
            }
            connect_(p.left);

            connect_(p.right);
        }
    }
    public void flatten(TreeNode root) {
        flatten_(root);
    }
    public TreeNode flatten_(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode LKT = flatten_(root.left);
        TreeNode RKT = flatten_(root.right);

        if (root.left != null && root.right != null) {
            TreeNode Right = root.right;
            root.right = root.left;
            LKT.right = Right;
            root.left = null;
            return RKT;
        } else
        if (root.left == null && root.right != null) {

            return RKT;
        } else
        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            return LKT;
        }

        return root;
    }



    public static void main(String args[]) {
       
        Node root = construct(input);
        width(root, 0);
        System.out.println(leftMost);
        System.out.println(rightMost);


    }
}