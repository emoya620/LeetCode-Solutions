class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        PriorityQueue<Integer> seatQueue = new PriorityQueue<>();
        PriorityQueue<Integer> studentQueue = new PriorityQueue<>();

        for (int i = 0; i < seats.length; i++){
            seatQueue.offer(seats[i]);
            studentQueue.offer(students[i]);
        }

        int moves = 0;
        while (!seatQueue.isEmpty()){
            int seat = seatQueue.poll();
            int student = studentQueue.poll();

            if (student > seat){
                while (student > seat){
                    student--;
                    moves++;
                }
            }
            else if (student < seat){
                while (student < seat){
                    student++;
                    moves++;
                }
            }
        }
        return moves;
    }
}
