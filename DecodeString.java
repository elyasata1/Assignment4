import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder current = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                counts.push(count);
            } else if (s.charAt(i) == '[') {
                result.push(current);
                current = new StringBuilder();
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = current;
                current = result.pop();
                int count = counts.pop();
                for (int j = 0; j < count; j++) {
                    current.append(temp);
                }
                i++;
            } else {
                current.append(s.charAt(i));
                i++;
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString ("3[a]2[bc]"));
        System.out.println(decodeString ("3[a2[c]]"));
        System.out.println(decodeString ("2[abc]3[cd]ef"));
    }
}