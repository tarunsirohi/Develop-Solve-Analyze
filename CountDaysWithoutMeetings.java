class Solution {
    public int countDays(int days, int[][] meetings) {
        if(meetings.length==0) return days;
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        int prevStart=meetings[0][0];
        int prevEnd=meetings[0][1];
        int busyDays=0;
        for(int i=1; i<meetings.length; i++){
            int start=meetings[i][0];
            int end=meetings[i][1];
            if(start <= prevEnd + 1){
                prevEnd = Math.max(prevEnd, end);
            }
            else{
                busyDays += (prevEnd - prevStart +1);
                prevEnd=end;
                prevStart=start;
            }
        }
        busyDays += (prevEnd - prevStart+1);
        return days-busyDays;
    }
}