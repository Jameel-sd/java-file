class Solution {
    public boolean squareIsWhite(String coordinates) {
        // A square is white if the sum of its character ASCII values is odd
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0;
    }
}