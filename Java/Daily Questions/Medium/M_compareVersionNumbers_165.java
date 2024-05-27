class Solution {
    public int compareVersion(String version1, String version2) {
        Queue<Integer> q1 = new LinkedList<>();
        int index = 0;
        String curNum = "0";
        while (index <= version1.length()){
            if (index == version1.length()){
                q1.add(Integer.parseInt(curNum));
                curNum = "0";
            }
            else if (version1.charAt(index) == '.'){
                q1.add(Integer.parseInt(curNum));
                curNum = "0";
            }
            else if (version1.charAt(index) != '0' && !curNum.equals("0")){
                curNum += version1.substring(index, index+1);
            }
            else if (version1.charAt(index) != '0'){
                curNum = version1.substring(index, index+1);
            }
            else{
                curNum += "0";
            }
            index++;
        }

        Queue<Integer> q2 = new LinkedList<>();
        index = 0;
        curNum = "0";
        while (index <= version2.length()){
            if (index == version2.length()){
                q2.add(Integer.parseInt(curNum));
                curNum = "0";
            }
            else if (version2.charAt(index) == '.'){
                q2.add(Integer.parseInt(curNum));
                curNum = "0";
            }
            else if (version2.charAt(index) != '0' && !curNum.equals("0")){
                curNum += version2.substring(index, index+1);
            }
            else if (version2.charAt(index) != '0') {
                curNum = version2.substring(index, index+1);
            }
            else{
                curNum += "0";
            }
            index++;
        }

        while (!q1.isEmpty() && !q2.isEmpty()){
            int val1 = q1.remove();
            int val2 = q2.remove();

            System.out.println("Val1 = " + val1 + " Val2 = " + val2);

            if (val1 > val2){
                return 1;
            }
            else if (val2 > val1){
                return -1;
            }
        }

        if (q1.size() > q2.size()){
            while (!q1.isEmpty()){
                if (q1.remove() != 0){
                    return 1;
                }
            }
        }
        else if (q2.size() > q1.size()){
            while (!q2.isEmpty()){
                if (q2.remove() != 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
