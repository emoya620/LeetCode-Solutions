class Solution {
    public String reversePrefix(String word, char ch) {
        int index = 0;

        while (index < word.length()){
            if (word.charAt(index) == ch){
                break;
            }
            index++;
        }

        if (index == word.length()){
            return word;
        }

        String firstHalf = "";
        String secondHalf = word.substring(index+1);

        while (index >= 0){
            firstHalf += word.charAt(index);
            index--;
        }

        return firstHalf + secondHalf;
    }
}
