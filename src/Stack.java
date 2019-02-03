/* What is a stack?
 *     A stack is a one-ended linear data structure which models a real world stack by having two primary operations,
 *     namely push and pop. We can visualize a stack as literally a stack. Think of a stack of books. A visual example
 *     is shown below:
 *     
 *     Data <- this is the top pointer of the stack
 *     Data
 *     Data
 *     Data
 *     
 *     When we remove an item from a stack we call it "pop", adding is called "push". Remember, items in a stack 
 *     always get added and removed from the TOP of the pile. This is commonly known as LIFO, or Last In, First Out.
 * Push and Pop Examples
 *     Let's say we have the stack of items below:
 *     
 *     Apple
 *     Potato
 *     Cabbage
 *     Garlic
 *     
 *     If we want to remove the apple from the stack we call a pop() function. So we do that and our new stack
 *     looks like this:
 *     
 *     Potato
 *     Cabbage
 *     Garlic
 *     
 *     If we want to add an onion to the stack then we have to call a push() function. So we call push(onion) and 
 *     our new stack looks like this:
 *     
 *     Onion
 *     Potato
 *     Cabbage
 *     Garlic
 *     
 *     Next we want to push celery on the stack, so we call push(celery). The new stack looks like this:
 *     
 *     Celery
 *     Onion
 *     Potato
 *     Cabbage
 *     Garlic
 *     
 *     Then we want to remove an item, so we call pop(). The new list looks like this:
 *     
 *     Onion
 *     Potato
 *     Cabbage
 *     Garlic
 *     
 *     REMEMBER we always operate on the top of the stack. We do not have access to any other item in a stack besides
 *     the top. It is critical to understand this to understand how a stack works.
 *     
 * When and Where is a Stack Used?
 * 
 *     Used by undo mechanisms in text editors. 
 *     
 *     Used in compiler syntax checking for matching brackets and braces.
 *     
 *     Can be used to model a pile of books or other real world items. 
 *     
 *     Used behind the scenes to support recursion by keeping track of previous function calls. When a function returns
 *     it pops the current stack frame off the stack and it rewinds to the next function that's on the stack.
 *     
 *     Can be used to do a Depth First Search (DFS) on a Graph. This can be done manually by maintaining your own 
 *     stack or by using recursion. Both will involve using stacks.
 *     
 *     They are also used in browsers to navigate backwards and forwards. 
 * 
 * Complexity Analysis-assuming you implemented the stack using a linked list
 *     Pushing: O(1) constant time because we have a reference to the top of the stack at all times.
 *     Popping: O(1) constant time because we have a reference to the top of the stack at all times.
 *     Peeking: O(1) constant time because we have a reference to the top of the stack at all times.
 *     Searching: O(n) linear time because the element we are searching for may not be at the top of the stack so at
 *         worst case we may have to search through the entire stack.
 *     Size: O(1) constant time because we have to move through the entire stack to find the size.
 *     
 * Example Problem - Brackets
 *     Problem: given a string made up of the following brackets: ()[]{}, determine if the brackets properly match.
 *     Examples of what I mean are shown below:
 *     
 *     [{}] -> valid
 *     (()) -> valid
 *     {] -> invalid
 *     [()]))() -> invalid
 *     []{}({}) -> valid
 *     
 *     Example 1:
 *     
 *     [[{}]()] -> should be valid
 *     
 *     Solution: for every left bracket we encounter we should push those onto the stack. So when we begin, reading
 *     left to right, we push the first left [ bracket onto the stack. Same goes for the next. So our current stack
 *     so far is shown below.
 *     
 *     [ -> this is our current top
 *     [
 *     
 *     We continue and push the { onto the stack. Next we traverse to the next element. This element is a right square
 *     bracket, '}'. So we have encountered a right square bracket now we need to do two checks. First, we need to
 *     check if the stack is empty. If so then the operation is invalid because then the brackets would not be matched.
 *     But, if there are still items in the stack then we pop the top element and check if its value is equal to the
 *     reversed current bracket. For this example the top bracket is equal to the reversed bracket because we have 
 *     {} so we can remove the brackets from the stack. Next we have a right square bracket. Once again, we check if
 *     the stack is empty. In this case, no it isn't. Next we check if the top element of the stack is equal to the 
 *     reversed bracket. Yes it is because we have []. We can remove the []. Now our stack is a single '['. Next, we 
 *     move onto the next element in our bracket sequence. It is a round left bracket '('. We push it onto the stack.
 *     Then we move onto the next bracket. It is a round right bracket ')'. Because it is a right bracket we check if
 *     the list is empty. It is not. Now we check if the top element of the stack '(' equal to the reversed bracket.
 *     It is. So we can remove the ( from the stack. Now, all we are left with is a right bracket ']'. We check if the
 *     stack is empty, no it is not because we have our '['. Then we check if the top element of the stack is equal
 *     to the reversed bracket. Yes, it is. Now we can remove our [ from the stack and we are done processing the 
 *     string. We need to make sure the stack is empty now. Why is that? We do this in case the last few characters 
 *     in the bracket sequence were left brackets in which case they would still be in the stack, but our stack is 
 *     empty so we can conclude that this bracket sequence is valid.
 *     
 *     Example 2:
 *     
 *     [{})[] -> should be invalid
 *     
 *     Solution: We begin this the same as the problem before. We need to push each left bracket onto the stack. Our 
 *     first element in a left bracket '[' so we push this onto our stack. The next item is a left curly brace '{' so 
 *     we push it on the stack as well. Our next item is a right curly brace '}'. Like the problem before we check if
 *     the stack is empty first. It is not. Ergo, we check to see if the top of the stack is equal to the reversed 
 *     bracket. It is, so we remove the left curly bracket '{' from our stack. The next bracket is a round right 
 *     bracket ')'. We check to see if the stack is empty, it is not. Then we check to see if the bracket on the top
 *     of the stack is equal to the reversed brace. It is not. This means that this bracket sequence is invalid.
 *     
 * Pseudo code for the algorithm we just went through:
 *     Let S be a stack.
 *     
 *     For bracket in bracket_string:
 *         reversedBracket = getReversedBracket(bracket)
 *         
 *         if isLeftBracket(bracket)
 *             S.push(bracket)
 *         else if S.isEmpty() or S.pop() != reversedBracket
 *             return false //invalid
 *             
 *     return S.isEmpty() //valid if S is empty
 * 
 */

public class Stack 
{

}
