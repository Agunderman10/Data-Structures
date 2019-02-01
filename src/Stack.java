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
 * 
 * 
 */

public class Stack {

}
