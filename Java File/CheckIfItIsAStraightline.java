public class CheckIfItIsAStraightline {
    public boolean checkStraightLine(int[][] coordinates) {
        // Base case: 2 points always form a straight line
        if (coordinates.length <= 2) {
            return true;
        }
        
        // Get the initial differences using the first two points
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        // Check if all other points maintain the same slope ratio
        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];
            
            // Cross-multiplication to avoid division by zero
            if (dy * (xi - x0) != (yi - y0) * dx) {
                return false;
            }
        }
        
        return true;
    }
}