import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/5/problem/B
     * 
     * 280 ms / 3800 KB
     * 
     * Store each line in the input into a list, and keep track of the longest
     * string seen so we know how long the top and bottom lines will be and
     * how much whitespace we'll need for padding.
     * 
     * To process lines with an even amount of whitespace, just divide the
     * amount by 2 and attach it to the beginning and end of the string. For
     * lines with an odd amount of whitespace, we need to alternate between
     * giving the left and right sides more padding for each line, which we
     * can do with a boolean flag.
     * 
     * TC/SC - O(mn)/O(mn) for m = # lines in the input, n = max length of a
     * line in the input
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int max = 0; // max length of string
        List<String> list = new ArrayList<>();
        
        while (s.hasNextLine()) {
            String line = s.nextLine();
            max = Math.max(max, line.length());
            list.add(line);
        }

        System.out.println(repeat('*', max + 2));

        // align left first
        boolean alignLeft = true;

        for (String str : list) {
            int whitespace = max - str.length();

            // even (easy) case: divide by 2
            if (whitespace % 2 == 0) {
                System.out.print('*' + repeat(' ', whitespace / 2));
                System.out.print(str);
                System.out.println(repeat(' ', whitespace / 2) + '*');
            }
            // odd (hard) case: alternate between aligning left and right
            else {
                if (alignLeft) {
                    System.out.print('*' + repeat(' ', whitespace / 2));
                    System.out.print(str);
                    System.out.println(repeat(' ', whitespace / 2 + 1) + '*');
                }
                else {
                    System.out.print('*' + repeat(' ', whitespace / 2 + 1));
                    System.out.print(str);
                    System.out.println(repeat(' ', whitespace / 2) + '*');
                }

                alignLeft = !alignLeft;
            }
        }

        System.out.println(repeat('*', max + 2));

        s.close();
    }

    private static String repeat(char c, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++)
            sb.append(c);

        return sb.toString();
    }
}