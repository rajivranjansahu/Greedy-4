// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    // Helper function to determine the minimum rotations required to make all values equal to x.
    // Returns -1 if it's impossible.
    public int check(int x, int[] A, int[] B, int n) {
        int rotationsA = 0;  // Counts rotations needed if aligning to value x from A.
        int rotationsB = 0;  // Counts rotations needed if aligning to value x from B.

        for (int i = 0; i < n; i++) {
            // If neither side has the target value, it's impossible.
            if (A[i] != x && B[i] != x) {
                return -1;
            } else if (A[i] != x) {  // A[i] is not x, so we would need to rotate this domino to bring x from B.
                rotationsA++;
            } else if (B[i] != x) {  // B[i] is not x, so we would need to rotate this domino to bring x from A.
                rotationsB++;
            }
        }
        // Return the minimum rotations required from the two possibilities.
        return Math.min(rotationsA, rotationsB);
    }

    public int minDominoRotations(int[] A, int[] B) {
        // Try aligning by using the first domino's top value.
        int rotations = check(A[0], A, B, A.length);
        
        // If a valid rotation count was found or both domino faces are the same,
        // then no need to check the other face.
        if (rotations != -1 || A[0] == B[0]) {
            return rotations;
        } else {
            // Else, try aligning by using the first domino's bottom value.
            return check(B[0], A, B, A.length);
        }
    }
}
