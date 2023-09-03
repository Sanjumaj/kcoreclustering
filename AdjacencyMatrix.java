public class AdjacencyMatrix {
    public static void main(String[] args) {
        
        String bitSequence ="0001000011";

        // Repeat the bit sequence 68 times
        StringBuilder repeatedSequence = new StringBuilder();
        int z=0;
        while(z<68){
            repeatedSequence.append(bitSequence);
            z++;
        }
        String repeatedSequenceString = repeatedSequence.toString();
       // Create the initial adjacency matrix
        int[][] adjacencyMatrix = new int[26][26];
        int sequenceIndex = 0;
        for (int i = 0; i < 26; i++) {
            String subsequence = repeatedSequenceString.substring(sequenceIndex, sequenceIndex + 26);
            for (int j = 0; j < 26; j++) {
                adjacencyMatrix[i][j] = Character.getNumericValue(subsequence.charAt(j));
            }
            sequenceIndex += 26;
        }
        // Adjust the adjacency matrix to reflect the properties of the graph
        for (int i = 0; i < 26; i++) {
            boolean isolatedNode = true;
            for (int j = 0; j < 26; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    isolatedNode = false;
                    break;
                }
            }
            if (isolatedNode) {
                adjacencyMatrix[i][0] = 1;
                adjacencyMatrix[i][26 - 1] = 1;
                adjacencyMatrix[0][i] = 1;
                adjacencyMatrix[26 - 1][i] = 1;
            }
            
        }
        // Make the adjacency matrix symmetric
        for (int i = 0; i < 26; i++) {
            adjacencyMatrix[i][i] = 0;
            for (int j = 0; j < i; j++) {
                adjacencyMatrix[i][j] = adjacencyMatrix[j][i];
            }
        }
        // Print the adjacency matrix
      System.out.print("{");
        for (int i = 0; i < 26; i++) {
            System.out.print("{");
            for (int j = 0; j < 26; j++) {
                System.out.print(adjacencyMatrix[i][j] + ",");
            }
            System.out.println("},");
        }
        System.out.print("}");
    }
}
