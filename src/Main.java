import model.basic.collection.Stack;

public class Main {
    public static void main(String[] args) {

        try {
            Stack stack = new Stack();

            stack.push("first");
            stack.push("second");
            stack.push("third");


            while (!stack.isEmpty()) {
                System.out.println(stack.pop().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}