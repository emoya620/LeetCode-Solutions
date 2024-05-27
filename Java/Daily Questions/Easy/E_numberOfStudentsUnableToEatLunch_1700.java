class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList();
        Queue<Integer> sandwichQueue = new LinkedList();

        for (int n : students){
            studentQueue.add(n);
        }

        for (int n : sandwiches){
            sandwichQueue.add(n);
        }

        int curStudents = 0;
        while (!sandwichQueue.isEmpty()){
            if (sandwichQueue.peek() == studentQueue.peek()){
                curStudents = 0;
                studentQueue.remove();
                sandwichQueue.remove();
                continue;
            }

            curStudents++;
            int n = studentQueue.remove();
            studentQueue.add(n);
            if (curStudents > studentQueue.size()){
                return studentQueue.size();
            }
        }
        return 0;
    }
}
