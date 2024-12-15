class Solution {
    // Time Complexity: O(N * log(N)) | Space Complexity: O(N)
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        for (int[] curClass : classes){
            int passes = curClass[0];
            int students = curClass[1];
            double gain = calculateGain(passes, students);
            maxHeap.offer(new double[]{gain, passes, students});
        }

        while (extraStudents-- > 0){
            double[] current = maxHeap.poll();
            double gain = current[0];
            int passes = (int) current[1];
            int students = (int) current[2];
            maxHeap.offer(new double[]{calculateGain(passes + 1, students + 1), passes + 1, students + 1});
        }

        double ratio = 0;
        while (!maxHeap.isEmpty()){
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int students = (int) current[2];
            ratio += (double) passes / students;
        }
        return ratio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents){
        return (double) (passes + 1) / (totalStudents + 1) - (double) passes / totalStudents;
    }
}
