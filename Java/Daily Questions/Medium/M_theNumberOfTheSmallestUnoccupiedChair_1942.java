class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a,b) -> a[0] - b[0]);

        int nextChair = 0;
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        TreeSet<Integer> availableChairs = new TreeSet<>();
        for (int[] time : times){
            int arrival = time[0];
            int leave = time[1];

            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival){
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int curChair;
            if (!availableChairs.isEmpty()){
                curChair = availableChairs.first();
                availableChairs.remove(curChair);
            }
            else{
                curChair = nextChair++;
            }
            leavingQueue.offer(new int[]{leave, curChair});
            if (arrival == targetArrival){
                return curChair;
            }
        }
        return 0;
    }
}
