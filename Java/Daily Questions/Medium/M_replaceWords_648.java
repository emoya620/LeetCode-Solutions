class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++){
            for (String root : dictionary){
                if (root.length() < words[i].length() && root.equals(words[i].substring(0, root.length()))){
                    words[i] = root;
                }
            }
        }

        String newSentence = "";
        for (String s : words){
            newSentence += s;
            newSentence += " ";
        }

        return newSentence.substring(0, newSentence.length() - 1);
    }
}
