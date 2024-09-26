class MyCalendar {
    ArrayList<int[]> calendar;

    public MyCalendar() {
        this.calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if (calendar.size() == 0){
            calendar.add(new int[]{start, end});
            return true;
        }

        for (int i = 0; i < calendar.size(); i++){
            int curStart = calendar.get(i)[0];
            int curEnd = calendar.get(i)[1];
            if (i == 0 && end <= curStart){
                calendar.add(i, new int[]{start, end});
                return true;
            }
            else if (i == calendar.size() - 1 && start >= curEnd){
                calendar.add(new int[]{start, end});
                return true;
            }
            else if (calendar.size() > 1 && i != calendar.size() - 1 && curEnd <= start && calendar.get(i+1)[0] >= end){
                calendar.add(i+1, new int[]{start, end});
                return true;
            }
            else if (start <= curStart){
                return false;
            }
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
