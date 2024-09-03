class Solution {
    public int getLucky(String s, int k) {
        String str = "";
        for (Character c : s.toCharArray()){
            int val = c - 'a' + 1;
            str += Integer.toString(val);
        }

        for (int i = 0; i < k; i++){
            int sum = 0;
            for (Character c : str.toCharArray()){
                sum += Integer.valueOf(c - '0');
            }
            str = Integer.toString(sum);
        }
        return Integer.valueOf(str);
    }
}
