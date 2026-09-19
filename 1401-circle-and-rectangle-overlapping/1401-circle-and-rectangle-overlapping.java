class Solution {
    public boolean overlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
         // Find closest point of rectangle to circle center
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Distance between circle center and closest point
        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        int distanceSquared = dx * dx + dy * dy;

        // Check if closest point lies inside/on the circle
        return distanceSquared <= radius * radius;
    }
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return overlap(radius, xCenter, yCenter, x1, y1, x2, y2);
    }
}