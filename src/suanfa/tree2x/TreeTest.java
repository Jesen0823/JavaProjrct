package suanfa.tree2x;

public class TreeTest {

    static class Tree {
        Tree left = null;
        Tree right = null;
        int value;

        Tree(int v) {
            this.value = v;
        }
    }

    private static void preList(Tree node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preList(node.left);
        preList(node.right);
    }
    private static void midList(Tree node) {
        if (node == null) return;
        midList(node.left);
        System.out.print(node.value + " ");
        midList(node.right);
    }
    private static void endList(Tree node) {
        if (node == null) return;
        endList(node.left);
        endList(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        /**
         *        3
         *      /   \
         *     6     7
         *    / \    / \
         *   8   9  10  0
         *       /\
         *      11 4
         * */
        Tree n3 = new Tree(3);
        Tree n6 = new Tree(6);
        Tree n7 = new Tree(7);
        Tree n8 = new Tree(8);
        Tree n9 = new Tree(9);
        Tree n10 = new Tree(10);
        Tree n0 = new Tree(0);
        Tree n11 = new Tree(11);
        Tree n4 = new Tree(4);
        n3.left = n6;
        n3.right = n7;
        n6.left = n8;
        n6.right = n9;
        n7.left = n10;
        n7.right = n0;
        n9.left = n11;
        n9.right = n4;
        String source = String.join(
                "",
            "       3       \n",
            "     /   \\    \n",
            "    6     7    \n",
                "   / \\    / \\   \n",
                "  8   9  10  0   \n",
                "     / \\      \n",
                "    11 4        \n"
        );
        System.out.println(source);

        System.out.println("\n 先序遍历：");
        preList(n3);
        System.out.println("\n 中序遍历：");
        midList(n3);
        System.out.println("\n 后序遍历：");
        endList(n3);
    }
}
