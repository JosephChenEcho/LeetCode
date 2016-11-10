/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;

/**
 *
 * @author jochen
 */
//211. Add and Search Word - Data structure design
public class WordDictionary {
    
    class Trie{
        Trie[] child;
        char ch;
        boolean end = false;
        public Trie(char ch){
            this.ch = ch;
            child = new Trie[26];
        }
    }
    
    Trie root = new Trie('0');
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        Trie node = root;
        for(char ch: word.toCharArray()){
            if(node.child[ch - 'a'] == null)
                node.child[ch - 'a'] = new Trie(ch);
            node = node.child[ch - 'a'];
        }
        node.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Trie node = root;
        return search(node, word, 0);
    }
    
    public boolean search(Trie node, String word, int cur){
        if(cur == word.length() && node.end == true)
            return true;
        if(cur >= word.length())
            return false;
        char ch = word.charAt(cur);
        boolean res = false;
        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(node.child[i] != null)
                    res |= search(node.child[i], word, cur + 1);
            }
        }else if(node.child[ch - 'a'] == null){
            return false;
        }else{
            res |= search(node.child[ch - 'a'], word, cur + 1);
        }
        
        return res;
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
