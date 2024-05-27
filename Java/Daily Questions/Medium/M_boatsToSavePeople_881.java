class Solution {
    public int numRescueBoats(int[] people, int limit) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : people){
            minQueue.add(p);
            maxQueue.add(p);
        }

        int boats = 0;
        int size = maxQueue.size();
        while (size > 1){
            int weight1 = maxQueue.poll();
            int weight2 = minQueue.poll();

            if (weight1 + weight2 <= limit){
                boats++;
                size -= 2;
            }
            else{
                boats++;
                size--;
                minQueue.add(weight2);
            }
        }

        return size == 0 ? boats : boats + 1;
    }
}
