class Solution {
    public int timesBetweenSeconds(String startTime, String endTime) {
        int h1 = Integer.parseInt(startTime.substring(0, 2));
        int m1 = Integer.parseInt(startTime.substring(3, 5));
        int s1 = Integer.parseInt(startTime.substring(6, 8));

        int start = h1 * 3600 + m1 * 60 + s1;

        int h2 = Integer.parseInt(endTime.substring(0, 2));
        int m2 = Integer.parseInt(endTime.substring(3, 5));
        int s2 = Integer.parseInt(endTime.substring(6, 8));

        int end = h2 * 3600 + m2 * 60 + s2;

        return end - start;
    }
    public int secondsBetweenTimes(String startTime, String endTime) {
        return timesBetweenSeconds(startTime, endTime);
    }
}