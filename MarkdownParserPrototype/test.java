public class test {
    //6n^4 + 6n^3 + 12n^2 + 5n + 4
    public static int function1 (int n) {
        int c = 0;
        //(1 + 1 + (6n^3 + 6n^2 + 12n + 2) + 1)*n + 2 => 6n^4 + 6n^3 + 12n^2 + 5n + 2
        for (int i = 0; i < n; i++) {
            System.out.println("iteration " + i);
            //(1 + (3n^2 + 3n + 4) + 1)*2n + 2 => 6n^3 + 6n^2 + 12n + 2
            for (int j = 0;  j < 2*n;  j++) {
                //(3n+2) + (3n^2 + 2) => 3n^2 + 3n + 4

                //3n + 2
                for (int k = 0; k < n; k++) {
                    c += k*k;
                }
                //3n^2 + 2
                for (int l = 0;  l < n*n;  l++) {
                    c -= 1;
                }
            }
        }
        return c;
    }

    //4(m^2)n + 4mn + 8n + 5
    public static int[] mostOrdered(int[][] listOfLists) {
        int[] chosen = null;
        int bestResult = Integer.MAX_VALUE;
        // loop over every sublist
        //(1 + 1 + (4m^2 + 4m + 2) + 3 + 1)n + 2 => 4(m^2)n + 4mn + 8n + 2
        for (int[] sublist : listOfLists) {
            int inversions = 0;
            // loop over every pair of elements in the sublist
            //(1 + (4m + 2) + 1)m + 2 => 4m^2 + 4m + 2
            for (int i = 0;  i < sublist.length;  i++) {
                //4m + 2
                for (int j = i + 1;  j < sublist.length;  j++) {
                    //2
                    // if the elements are out of order, count it as an inversion
                    if (sublist[i] > sublist[j]) { inversions++; }
                }
            }

            //3
            // if the number of out-of-order elements in the current list is the best, select it
            if (inversions < bestResult) {
                chosen = sublist;
                bestResult = inversions;
            }
             
        }
        return chosen;
    }

    public static void main(String[] args) {
        // int n = 10;
        // function1(n);

        int n = 1000000;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                count++;
            }
        }

        System.out.println(count);

    }
}

