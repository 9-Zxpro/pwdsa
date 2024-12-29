package trie;

public class Trie {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private static Node root;

    public static void insert(String word) { //O(n)
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String key) { //O(n)
        int level = 0;
        int len = key.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    public static void main(String[] args) {
        root = new Node();
        String[] words = {"the", "a", "there", "their", "any", "thee"};
        for (String word : words) {
            insert(word);
            System.out.println("inserted " + word);
        }

        System.out.println("thee -> " + search("thee"));
        System.out.println("thor -> " + search("thor"));

    }


}
