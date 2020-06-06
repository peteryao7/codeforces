import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/5/problem/A
     * 
     * 218 ms / 3740 KB
     * 
     * To keep track of the users, we can use a set containing every username
     * in the chat. Then we can add and remove users in O(1). Pull usernames
     * by using substring() on every character after the '+' or '-'.
     * 
     * To calculate the number of bytes sent, get the size of the substring
     * of the message after the ':', then multiply it by the number of users
     * in the chat right now using set.size().
     * 
     * TC/SC - O(n)/O(n) for n = # lines in the input
     * 
     * We actually don't need to keep track of who's who, we just need to know
     * the number of users in the chat at the moment. So we could simply keep
     * an int storing the number of people, and increment it for each '+' and
     * decrement for each '-' seen. That would make the SC O(1).
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str;
        Set<String> set = new HashSet<>();

        int res = 0;

        while (s.hasNextLine()) {
            str = s.nextLine();

            if (str.charAt(0) == '+')
                set.add(str.substring(1));
            else if (str.charAt(0) == '-')
                set.remove(str.substring(1));
            else {
                int msgLength = str.substring(str.indexOf(':') + 1).length();
                res += msgLength * set.size();
            }
        }

        s.close();

        System.out.println(res);
    }
}