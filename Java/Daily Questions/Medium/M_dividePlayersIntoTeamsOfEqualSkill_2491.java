class Solution {
    // Time Complexity: O(nlogn) | Space Complexity: O(1)
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int avgSkill = skill[0] + skill[skill.length-1];
        long chemistry = 0;
        int left = 0;
        int right = skill.length-1;
        while (left < right){
            if (skill[left] + skill[right] != avgSkill){
                return -1;
            }
            chemistry += skill[left] * skill[right];
            left++;
            right--;
        }
        return chemistry;
    }
}
