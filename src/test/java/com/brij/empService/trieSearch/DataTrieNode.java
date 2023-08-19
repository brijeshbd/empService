package com.brij.empService.trieSearch;

public class DataTrieNode {
    static class TrieNode{
        TrieNode[] child;
        boolean eow;
        TrieNode(){
            child = new TrieNode[26];
            for(int i=0;i<26;i++)
                child[i]=null;
            eow=false;
        }
    };

    public static TrieNode root = new TrieNode();

    public static void insert(String s){
        int level;
        int length = s.length();
        TrieNode curr = root;
        for(level=0;level<length;level++){
            int index = s.charAt(level) - 'a';
            if(curr.child[index] == null){
                curr.child[index] = new TrieNode();
            }
            curr = curr.child[index];
        }
        curr.eow=true;
        System.out.println("Done With One String...");
    }

    public static boolean searchString(String s){
        for(int i=0;i<s.length();i++){
            int in = s.charAt(i)-'a';
            TrieNode Node = root.child[in];
            if(Node==null) return false;
            if(i==s.length()-1 && !Node.eow)
                return false;

            root = Node;
        }
        return true;
    }

}
