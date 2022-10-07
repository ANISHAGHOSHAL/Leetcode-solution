class MyCalendarThree {

    TreeMap<Integer, Integer> map;
    int k;
    
    public MyCalendarThree() {
        map = new TreeMap<>();
        k = 0;
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int sum = 0;
        for(int num : map.values())
            k = Math.max(k, sum += num);
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */