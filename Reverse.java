//Lab7 - Stack Exercises - tjudge
//Assignment was to reverse a string (specifically sentences with a period)
//And reverse a number
//Mary had a little lamb. Its fleece was white as snow. - Were the given test sentences
import java.util.*;
public class Reverse
{
    public static void main(String[] args) {
        Reverse main = new Reverse();
        Scanner scanner = new Scanner(System.in);
//inputs for both
        System.out.println("Enter a sentence to be reversed.");
        main.reverseString(scanner.nextLine());

        System.out.println("\nEnter an integer (number) to be reversed.");
        main.ReverseNumber(scanner.nextInt());

    }

//Number Reversal
    void ReverseNumber(int number) { //
        Stack<Integer> stack = new Stack<>();
        int digit;

        while (number != 0) {
            digit = number % 10;
            stack.push(digit);
            number = number / 10;
        }
        System.out.println("For testing");
        System.out.println("Top element in the stack: " + stack.peek());
        System.out.println("Elements in the stack: " + stack);

        int rev_num = 0;
        int power = 0;

        while (!stack.isEmpty()) {
            digit = stack.pop();
            rev_num = rev_num + digit * (int) Math.pow(10, power);
            power = power + 1;
        }

        System.out.println("\nReversed Number\n" + rev_num);
    }

//String Reversal
    void reverseString(String input) {
        Stack<String> stack = new Stack<>();
        String[] splitInput = input.split(" ");
        System.out.println("For testing");

        for(String word : splitInput)
        {
            if(word.contains("."))
            {
                word = word.replace(".", "");
                stack.push(word);
                makeStringPretty(stack);
                stack.clear();
            }
            else
            {
                stack.push(word);
             }

        }
    }

    void makeStringPretty(Stack<String> stack)
    {

        System.out.println("Top element in the stack: " + stack.peek()); // These lines could be removed
//        int position = stack.search("little");
//       System.out.println("Position of little: " + position);
        System.out.println("Elements in the stack: " + stack);
        System.out.print("\nReversed Sentence\n");
        StringBuilder reversedSentence = new StringBuilder();
        String word;

        int stackSize = stack.size();

        for(int i = 0 ; i < stackSize ; i++)
        {
            word = stack.pop().toLowerCase();

            if(i == 0)
            {
                String firstLetter = word.substring(0, 1);
                word =  firstLetter.toUpperCase() + word.substring(1);
                reversedSentence.append(word);
            }
            else if(i == (stackSize - 1))
            {
                reversedSentence.append(" ").append(word).append(". ");
            }
            else
            {
                reversedSentence.append(" ").append(word);
            }
        }

        System.out.print(reversedSentence + "\n");
    }

}
