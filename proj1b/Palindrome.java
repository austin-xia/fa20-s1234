public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        char N;
        Deque<Character> deque = new LinkedLisDeque<>();
        for (int i =0; i < word.length() ; i += 1){
            N = word.charAt(i);
            deque.addLast(N);
        }
        return deque;
    }

    private boolean isPaliindrome_helper (Deque<Character> L) {
        if (L.size() == 1 || L.size() == 0){
            return true;
        } else if (L.removeFirst() == L.removeLast()){
            return isPaliindrome_helper(L);
        } else {
            return false;
        }
    }

    public boolean isPalindrome (String word){
        if (word == null){
            return false;
        } else{
            Deque<Character> Q = wordToDeque(word);
            return isPaliindrome_helper(Q);
        }
    }

    private boolean isPaliindrome_Ghelper (Deque<Character> L, CharacterComparator cc) {
        if (L.size() == 1 || L.size() == 0){
            return true;
        } else if (cc.equalChars(L.removeFirst(), L.removeLast())){
            return isPaliindrome_Ghelper(L,cc);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word == null){
            return false;
        } else{
            Deque<Character> Q = wordToDeque(word);
            return isPaliindrome_Ghelper(Q,cc);
        }
    }








}
