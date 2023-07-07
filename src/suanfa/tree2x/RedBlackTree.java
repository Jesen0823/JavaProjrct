package suanfa.tree2x;
/**
 * 一个简单的红黑树实现，其中包含插入（insert）、删除（delete）和搜索（search）方法。
 * 每个节点都有一个关键字（key）和颜色（color）属性，颜色可以是红色（RED）或黑色（BLACK）。
 * 插入和删除操作会根据红黑树的性质进行调整，以保持树的平衡和红黑性质。搜索操作根据关键字在树中查找节点。
 *
 * 这只是一个基本的红黑树实现，并不包含其他高级功能，如范围查询等
 * */
/**
 *
 * 二叉树（Binary Tree）、平衡二叉树（Balanced Binary Tree）、二叉搜索树（Binary Search Tree）和红黑树（Red-Black Tree）是常见的树结构，
 * 在计算机科学中具有不同的特性和用途。
 *
 * 二叉树（Binary Tree） 是一种树状结构，其中每个节点最多有两个子节点，分别称为左子节点和右子节点。每个节点最多有一个父节点（除了根节点）。
 * 二叉树可以为空树（没有节点）或非空树（包含至少一个节点）。二叉树的节点可以具有任意数量的子节点，但是常用的是二叉树。二叉树的遍历方式包括前序遍历、中序遍历和后序遍历。
 *
 * 平衡二叉树（Balanced Binary Tree） 是一种特殊的二叉树，它的左子树和右子树的高度差不超过一个固定的整数（通常为1），以确保树的高度保持在较小的范围内。
 * 平衡二叉树的目的是提高树的搜索和插入/删除操作的效率，使得这些操作的时间复杂度保持在较低的水平（通常是对数时间复杂度）。
 *
 * 二叉搜索树（Binary Search Tree，BST） 是一种有序的二叉树，它具有以下性质：
 *
 * 对于树中的每个节点，其左子树中的所有节点的值都小于该节点的值。
 * 对于树中的每个节点，其右子树中的所有节点的值都大于该节点的值。
 * 左子树和右子树也都是二叉搜索树。
 * 由于二叉搜索树的有序性质，它在查找、插入和删除操作上具有高效性能。对于平衡的二叉搜索树，这些操作的时间复杂度通常是对数时间复杂度。
 *
 * 红黑树（Red-Black Tree） 是一种自平衡的二叉搜索树，它在插入和删除操作时能够保持树的平衡性。红黑树具有以下特点：
 *
 * 每个节点都有一个颜色属性，可以是红色或黑色。
 * 根节点和叶子节点（NULL节点）都被视为黑色。
 * 如果节点是红色，那么它的子节点必须是黑色。
 * 从根节点到每个叶子节点的路径上，黑色节点的数量必须相同。
 * 红黑树通过在插入和删除节点时进行颜色调整和旋转操作，确保树的高度保持在较小范围内，从而提供了较好的性能保证。红黑树的插入、删除和搜索操作的时间复杂度都是对数时间复杂度。
 *
 * 总结：
 *
 * 二叉树是树的一种基本形式，每个节点最多有两个子节点。
 * 平衡二叉树是一种保持树的高度较小的二叉树，用于提高搜索和插入/删除操作的效率。
 * 二叉搜索树是一种有序的二叉树，具有高效的查找、插入和删除操作。
 * 红黑树是一种自平衡的二叉搜索树，通过颜色调整和旋转操作来保持树的平衡性，并提供较好的性能保证。
 * */
class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int key;
        Node parent;
        Node left;
        Node right;
        boolean color;

        public Node(int key) {
            this.key = key;
            color = RED;
        }
    }

    private Node root;

    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        newNode.parent = parent;
                        fixRedRedViolation(newNode);
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        newNode.parent = parent;
                        fixRedRedViolation(newNode);
                        break;
                    }
                }
            }
        }
    }

    private void fixRedRedViolation(Node node) {
        while (node != root && node.parent.color == RED) {
            Node parent = node.parent;
            Node grandparent = parent.parent;
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;
                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    node = grandparent;
                } else {
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateRight(grandparent);
                }
            } else {
                Node uncle = grandparent.left;
                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateLeft(grandparent);
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    public void delete(int key) {
        if (root == null) {
            return;
        }
        Node node = search(key);
        if (node == null) {
            return;
        }
        deleteNode(node);
    }

    private void deleteNode(Node node) {
        if (node.left != null && node.right != null) {
            Node successor = minimum(node.right);
            node.key = successor.key;
            node = successor;
        }
        Node child = (node.right == null) ? node.left : node.right;
        if (node.color == BLACK) {
            node.color = getColor(child);
            deleteCase1(node);
        }
        replaceNode(node, child);
        if (node.parent == null && child != null) {
            child.color = BLACK;
        }
    }

    private void deleteCase1(Node node) {
        if (node.parent == null) {
            return;
        }
        deleteCase2(node);
    }

    private void deleteCase2(Node node) {
        Node sibling = getSibling(node);
        if (getColor(sibling) == RED) {
            node.parent.color = RED;
            sibling.color = BLACK;
            if (node == node.parent.left) {
                rotateLeft(node.parent);
            } else {
                rotateRight(node.parent);
            }
        }
        deleteCase3(node);
    }

    private void deleteCase3(Node node) {
        Node sibling = getSibling(node);
        if (node.parent.color == BLACK &&
                getColor(sibling) == BLACK &&
                getColor(sibling.left) == BLACK &&
                getColor(sibling.right) == BLACK) {
            sibling.color = RED;
            deleteCase1(node.parent);
        } else {
            deleteCase4(node);
        }
    }

    private void deleteCase4(Node node) {
        Node sibling = getSibling(node);
        if (node.parent.color == RED &&
                getColor(sibling) == BLACK &&
                getColor(sibling.left) == BLACK &&
                getColor(sibling.right) == BLACK) {
            sibling.color = RED;
            node.parent.color = BLACK;
        } else {
            deleteCase5(node);
        }
    }

    private void deleteCase5(Node node) {
        Node sibling = getSibling(node);
        if (node == node.parent.left &&
                getColor(sibling) == BLACK &&
                getColor(sibling.left) == RED &&
                getColor(sibling.right) == BLACK) {
            sibling.color = RED;
            sibling.left.color = BLACK;
            rotateRight(sibling);
        } else if (node == node.parent.right &&
                getColor(sibling) == BLACK &&
                getColor(sibling.right) == RED &&
                getColor(sibling.left) == BLACK) {
            sibling.color = RED;
            sibling.right.color = BLACK;
            rotateLeft(sibling);
        }
        deleteCase6(node);
    }

    private void deleteCase6(Node node) {
        Node sibling = getSibling(node);
        sibling.color = getColor(node.parent);
        node.parent.color = BLACK;
        if (node == node.parent.left) {
            sibling.right.color = BLACK;
            rotateLeft(node.parent);
        } else {
            sibling.left.color = BLACK;
            rotateRight(node.parent);
        }
    }

    private Node getSibling(Node node) {
        if (node == node.parent.left) {
            return node.parent.right;
        } else {
            return node.parent.left;
        }
    }

    private void replaceNode(Node node, Node child) {
        if (node.parent == null) {
            root = child;
        } else if (node == node.parent.left) {
            node.parent.left = child;
        } else {
            node.parent.right = child;
        }
        if (child != null) {
            child.parent = node.parent;
        }
    }

    private Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node search(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                return current;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    private boolean getColor(Node node) {
        return (node == null) ? BLACK : node.color;
    }
}
