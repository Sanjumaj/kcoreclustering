public class AdjacencyMatrixGenerator {
    public static void main(String[] args) {
       String UTD_ID = "2021608771";
       
        //0001011001
        StringBuilder bit_seq = new StringBuilder();

       
        for (int i = 0; i < UTD_ID.length(); i++) {
            char digit = UTD_ID.charAt(i);
            int num = Character.getNumericValue(digit);
            bit_seq.append(num % 2 == 0 ? "0" : "1");
        }

        StringBuilder bit_seq680 = new StringBuilder();
        
        int repeat=0;
        while(repeat<68){
            bit_seq680.append(bit_seq);
            repeat++;
        }

        String bit_seqString = bit_seq680.toString();

        int[][] adjMatrix = new int[26][26];
        int count = 0;
        //Loop to convert 680 length sequence to 26x26 matrix
        for (int i = 0; i < 26; i++) {
            String bit_seq_sub = bit_seqString.substring(count, count + 26);
            for (int j = 0; j < 26; j++) {
                adjMatrix[i][j] = Character.getNumericValue(bit_seq_sub.charAt(j));
            }
            count += 26;
        }
       //Loop to check isolated nodes
        for (int i = 0; i < 26; i++) {
            boolean isolated = true;
            for (int j = 0; j < 26; j++) {
                if (adjMatrix[i][j] == 1) {
                    isolated = false;
                    break;
                }
            }
            if (isolated) {
                adjMatrix[i][0] = 1;  
                adjMatrix[i][26-1] = 1; 
                adjMatrix[0][i] = 1; 
                adjMatrix[26-1][i] = 1; 
            }
        }
        //Loop to check symmetry

        for (int i = 0; i < 26; i++) {
            adjMatrix[i][i] = 0; 
            for (int j = i + 1; j < 26; j++) {
                adjMatrix[i][j] = adjMatrix[j][i]; 
            }
        }

        // Print the adjacency matrix
       System.out.print("{");
       for (int i = 0; i < 26; i++) {
       System.out.print("{");
        for (int j = 0; j < 26; j++) {
            System.out.print(adjMatrix[i][j] + ",");
        }
        System.out.println("},");
    }
    System.out.print("}");
    }
}
