package zuoshensuanfa.erchashu;

/**
 * 介绍前缀树
 * 何为前缀树？如何生成前缀树？
 * 例子：
 * <p>
 * 一个字符串类型的数组arr1，另一个字符串类型的数组arr2。arr2中有哪些字符，是arr1中
 * 出现的?请打印。arr2中有哪些字符，是作为arr1中某个字符串前缀出现的?请打印。arr2
 * 中有哪些字符，是作为arr1中某个字符串前缀出现的?请打印arr2中出现次数最大的前缀。
 */
public class PrefixTree {

    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        /**
         * nexts[0] == null 没有走向a的路
         * nexts[0] != null 有走向'a'的路
         */
        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26]; // a~z
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("xyz"));
        trie.insert("xyz");
        System.out.println(trie.search("xyz"));
        trie.delete("xyz");
        System.out.println(trie.search("xyz"));
        trie.insert("xyz");
        trie.insert("xyz");
        trie.delete("xyz");
        System.out.println(trie.search("xyz"));
        trie.delete("xyz");
        System.out.println(trie.search("xyz"));
        trie.insert("xyza");
        trie.insert("xyzac");
        trie.insert("xyzab");
        trie.insert("xyzad");
        trie.delete("xyza");
        System.out.println(trie.search("xyza"));
        System.out.println(trie.prefixNumber("xyz"));

    }
}
