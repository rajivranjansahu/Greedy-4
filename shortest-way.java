// TC: O(n*m)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ShortestWayToFormString {

    // Function to compute the minimum number of subsequences from 'source' required to form 'target'
    public int shortestWay(String source, String target) {
        int count = 0;          // Counts the number of subsequences used
        int i = 0;              // Pointer for target
        
        // Process the target until all characters are covered
        while (i < target.length()) {
            int prev = i;     // Record the position in target at the start of this pass
            // Iterate through the source string
            for (int j = 0; j < source.length() && i < target.length(); j++) {
                if (source.charAt(j) == target.charAt(i)) {
                    i++;    // Move to the next character in target if there's a match
                }
            }
            // If no progress has been made, then forming the target is impossible
            if (prev == i) {
                return -1;
            }
            count++;  // One full pass over source is counted as one subsequence used
        }
        
        return count;
    }

    public static void main(String[] args) {
        ShortestWayToFormString solver = new ShortestWayToFormString();
        Scanner scanner = new Scanner(System.in);
        
        // Input handling
        System.out.print("Enter source string: ");
        String source = scanner.next();
        System.out.print("Enter target string: ");
        String target = scanner.next();
        
        int result = solver.shortestWay(source, target);
        if (result == -1) {
            System.out.println("Impossible to form target from source.");
        } else {
            System.out.println("Minimum number of subsequences needed: " + result);
        }
        
        scanner.close();
    }
}
