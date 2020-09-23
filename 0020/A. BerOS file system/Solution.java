import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/20/A
     * 
     * 216 ms / 3728 KB
     * 
     * We can split the string by "/"s so we can get the individual words in
     * the path. If there are multiple consecutive "/"s together, then they
     * just turn into strings of length 0 in the result String array.
     * 
     * Therefore, when we go over every word to append to the result, check if
     * the string's length is greater than 0. If so, append a "/" and the word.
     * Otherwise, skip it.
     * 
     * If it turns out the input only had "/" in it, then the output should be
     * a single "/". That would also mean that, after looping through the
     * split string array, there would be nothing in the result, so append a
     * single "/" for our answer.
     * 
     * TC/SC - O(n)/O(n) for n = path.length()
     * 
     * We can also just print out the "/"s and the words in the path during
     * the loop. There's no point in storing the result string as we aren't
     * returning it.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] path = s.next().split("/");
        StringBuilder sb = new StringBuilder();

        for (String str : path) {
            if (str.length() > 0) {
                sb.append("/");
                sb.append(str);
            }
        }

        if (sb.length() == 0)
            sb.append("/");

        System.out.println(sb);

        s.close();
    }
}