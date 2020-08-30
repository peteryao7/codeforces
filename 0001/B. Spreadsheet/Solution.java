import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/1/problem/B
     * 
     * 1776 ms / 3892 KB
     * 
     * It's mostly just doing what the question asks. To discern between RC
     * and Excel format, RC will have at least one digit between the R and C.
     * 
     * To convert from RC to Excel, the main part is converting a base 10
     * integer to A-Z, which is like a base 26 alphabet. 
     * 
     * To convert from Excel to RC, we need to do the opposite, convert from
     * a base 26 alphabet to a base 10 integer.
     * 
     * Look at the stoi() and itos() methods for more info on how to do those.
     * 
     * TC/SC - O(nm)/O(nm) for m = average length of each input Excel/RC string
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            String st = s.next();

            if (isExcel(st))
                System.out.println(ExToRC(st));
            else
                System.out.println(RCToEx(st));
        }

        s.close();
    }

    private static boolean isExcel(String s) {
        return !(s.charAt(0) == 'R' && Character.isDigit(s.charAt(1)) && s.contains("C"));
    }

    private static String ExToRC(String s) {
        int i = 0;

        while (!Character.isDigit(s.charAt(i)))
            i++;

        String col = s.substring(0, i);
        String row = s.substring(i);

        return "R" + row + "C" + Integer.toString(stoi(col));
    }

    private static int stoi(String s) {
        int res = 0;
        int base = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'A' + 1;
            res += val * base;
            base *= 26;
        }

        return res;
    }

    private static String RCToEx(String s) {
        int i = 1; // skip R

        while (Character.isDigit(s.charAt(i)))
            i++;

        int row = Integer.valueOf(s.substring(1, i));
        int col = Integer.valueOf(s.substring(i + 1)); // skip C

        return itos(col) + row;
    }

    private static String itos(int col) {
        StringBuilder sb = new StringBuilder();

        while (col > 0) {
            int rem = col % 26;

            if (rem == 0) {
                sb.append('Z');
                col = col / 26 - 1;
            }
            else {
                sb.append((char) (rem - 1 + 'A'));
                col /= 26;
            }
        }

        return sb.reverse().toString();
    }
}