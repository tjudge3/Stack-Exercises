
A stack is a  list with a last-in-first-out (LIFO) ordering of its elements.   Stacks are very useful for many applications, such as processing algebraic expressions or reversing the order of lists.   

Exercise 1: 

Write a program using the java.util.Stack data structure that prompts for an integer and reverses it:  7359 becomes 9537.  
Hints:  

  Think of how base-10 works:  A base-10 number is a sum of digit * 100  + digit * 101 + digit * 102, etc.,  where each digit in your number is that digit times a power of 10, that is:   1 x digit + 10 x digit + 100 x digit + ....
Using that understanding, you can use modulo and integer arithmetic to get each digit and add it to a stack.   Algorithm:   Your number % 10 will give you the rightmost number.  Example:  7359 % 10 = 9.   Put the 9 on the stack.   Now divide  7359/10  = 735.  Repeat the process, that is 735 % 10 = 5,  put the 5 on the stack,    735/10 = 73, use 73 % 10 to get the 3.    Keep going,  adding digits to the stack until you run out of numbers.   
 Note: when you pop the numbers of your stack (remove), they will come off the stack reversed.  You will do that below. 
Note: when Stack.isEmpty() tells you whether there are more elements left in the stack so that you will know when to stop.   
while (num != 0) {
   digit = num % 10;
   stack.push(digit);
   num = num / 10;
}

// Now that you are done you may want to verify what is on the stack.
System.out.println("Elements in Stack: " + stack);
Now you create a value for revNum,  your reversed number:  Fact: when you pop the numbers off your stack, they will come off the stack reversed. So loop through the stack elements. Note your Stack.isEmpty() tells you whether there are more elements left in the stack so that you will know when to stop.

But how do we convert the reversed digits back into base 10?   Well,  why not use the power function using powers of 10?   Loop through your stack until you run out of digits. The power variable should be initialized to zero and increase by 1 each time through the loop.

while (! stack.isEmpty()) {
      digit = stk.pop();
       rev_num = rev_num + digit * (int) Math.pow(10, power);
       power = power + 1;
}
// Now just print out rev_num and you're done.   

Exercise 2: 

Write a program SentenceReverser that reverses the words in a sentence by reading words into a Stack until you find a period.  Your program should then pop off the words from the stack.  Begin your reverse sentence with a capital letter and end it with a period.   Your program should be able to handle multiple sentences.  Use while (scan.hasNext()) to capture your input.   Please no spaces before the period.  Also, the first letter of your sentences should start in the upper case.  

Mary had a little lamb.  His fleece was as white as snow.

Becomes:  

Lamb little a had mary. Snow as white as was fleece his.

 

Note: Your test input should include multiple sentences as shown above.  There should NOT be a space before your periods.  

Hints: 
1)   The Scanner class can be used to break a String into words using the space character as the delimiter.  

public  String reverse(String sentence)
{
    String reversed = "";
    Stack<String> stack = new Stack<>();
   Scanner scanner = new Scanner(sentence)
   //  Get the words in a sentence
  while (scanner.hasNext())
  {
    String pushWord = scanner.next();
    // your code here. 
    // Call a method processSentence when you find a period. 
}  
return reversed; 
      
public String processSentence(Scanner scanner, Stack stack, String reversed) {
     // your code here. 
}
2.   How to remove space before a period. 

popWord = popWord.replace(".", "");
 3.  Mask the first letter of a word in upper case: 

String firstLetter = word.substring(0, 1); 
word =  firstLetter.toUpperCase() + word.substring(1);
 4.  Make word all lower case: 

       word=  word.toLowerCase();
