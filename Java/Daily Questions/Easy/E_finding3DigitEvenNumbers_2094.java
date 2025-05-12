// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int n : digits){
            count[n]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            if (count[i] == 0){
                continue;
            }
            count[i]--;

            for (int j = 0; j < 10; j++){
                if (count[j] == 0){
                    continue;
                }
                count[j]--;

                for (int k = 0; k < 10; k+=2){
                    if (count[k] == 0){
                        continue;
                    }
                    ans.add(i*100 + j*10 + k);
                }
                count[j]++;
            }
            count[i]++;
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++){
            arr[i] = ans.get(i);
        }

        return arr;
    }
}
