class AVL {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;
        int balance;

        Node(int data) {
            this.data = data;
            this.height = 0;
            this.balance = 0;
        }

    }
    static void UpdateBalanceAndHeight(Node node) {
        int lh = -1;
        int rh = -1;
        if (node.left != null)
            lh = node.left.height;

        if (node.right != null)
            rh = node.right.height;
        node.height = Math.max(lh, rh) + 1;
        node.balance = lh - rh;
    }
    static Node ll(Node A) { // for ll structure

        Node B = A.left;
        Node BKaRight = B.right;
        B.right = A;
        A.left = BKaRight;
        UpdateBalanceAndHeight(A);
        UpdateBalanceAndHeight(B);

        return B;

    }
    static Node rr(Node A) { // for rr structure
        Node B = A.right;
        Node BKaLeft = B.left;
        B.left = A;
        A.right = BKaLeft;
        UpdateBalanceAndHeight(B);
        UpdateBalanceAndHeight(A);
        return B;
    }
    static Node getRotation(Node A) {
        if (A.balance == 2) {
            if (A.left.balance == 1) {
                return ll(A);
            } else if (A.left.balance == -1) {
                A.left = rr(A.left);
                return ll(A);
            }
        } else if (A.balance == -2) {
            if (A.right.balance == 1) {
                A.right = ll(A.right);
                return rr(A);

            } else if (A.right.balance == -1) {
                return rr(A);
            }
        }
        return A;
    }
    static Node construct(int si, int ei, int input[]) {

        if (si > ei) {
            return null;

        }
        int mid = (si + ei) / 2;
        Node node = new Node(input[mid]);
        node.left = construct(si, mid - 1, input);
        node.right = construct(mid + 1, ei, input);
        UpdateBalanceAndHeight(node);
        return node;
    }
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "[" + node.left.balance + "," + node.left.height + "]";
        str += " <- " + node.data + "[" + node.balance + "," + node.height + "]" + " -> ";
        str += node.right == null ? "." : node.right.data + "[" + node.right.balance + "," + node.right.height + "]";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static Node addData(Node node, int data) {
        if (node == null) return new Node(data);

        if (data > node.data) {
            node.right = addData(node.right, data);
        } else if (data < node.data) {
            node.left = addData(node.left, data);
        }




        return getRotation(node);



    }
    public static int MaxELE(Node node) {
        Node curr = node;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }

    public static Node removeData(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = removeData(node.left, data);
        } else
        if (data > node.data) {
            node.right = removeData(node.right, data);
        } else {
            if (node.left == null || node.right == null) return node.left != null ? node.left : node.right;

            else {

                int maxInleft = MaxELE(node.left);
                node.data = maxInleft;
                node.left = removeData(node.left, maxInleft);
            }


        }

        return getRotation(node);

    }
    public static void main(String args[]) {
       int[] input =  {9,12,14,17,19,23,50,54,67,72,76};

        Node root = construct(0, input.length - 1, input);
        root = addData(root, 30);
        root = addData(root, 60);
        root = addData(root, 70);
        root = addData(root, 80);
        root = addData(root, 90);
        root = removeData(root, 12);

        display(root);
    }
}