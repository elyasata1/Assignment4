import java.util.Stack;

public class allBrackets {
    public static String isTogether(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return "no";
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return "no";
                }
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }

    public static void main(String[] args) {
        System.out.println(isTogether("{[()]}"));
        System.out.println(isTogether("{[(])}"));
        System.out.println(isTogether("{{[[(())]]}}"));
    }
}