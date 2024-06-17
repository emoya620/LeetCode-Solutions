class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        if(boxes == null || warehouse == null){
            return 0;
        } 

        Arrays.sort(boxes);
        int numRooms = warehouse.length, numBoxes = boxes.length;
        int bp = numBoxes - 1, rpLeft = 0, rpRight = numRooms - 1;
        int pushedBoxes = 0;
        while(bp >= 0 && rpLeft <= rpRight) {
            if(warehouse[rpLeft] >= boxes[bp]) {
                pushedBoxes++;
                rpLeft++;
            }
            else if(warehouse[rpRight] >= boxes[bp]) {
                pushedBoxes++;
                rpRight--;
            }
            bp--;
        }
        return pushedBoxes;
    }
}
