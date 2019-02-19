/*
 * What is a Priority Queue?
 *     
 *     A priority queue is an abstract data type(ADT) that operates similar to a normal queue except that each element
 *     has a certain priority. The priority of the elements in the priority queue determine the order in which elements
 *     are removed from the priority queue. In other words, elements with a higher priority are dequeued first.
 *     
 *     Note: Priority queues only support comparable data, meaning the data inserted into the priority queue must be
 *     able to be ordered in some way either from least to greatest or greatest to least. This is so that we are able 
 *     to assign relative priorities to each element. 
 *     
 *     Suppose all of these values below are inserted into a PQ with an ordering imposed on the numbers to be from 
 *     least to greatest. So in other words, the smaller numbers have a higher priority over the larger numbers, so 
 *     the smaller numbers will be removed from the priority queue first. Below is our queue:
 *     
 *     1 -> 3 -> 4 -> 8 -> 14 -> 22
 *     
 *     We poll() from the priority queue and it dequeues the smallest element(remember the smallest elements
 *     have the highest priority in this example) Our new queue would look like this:
 *     
 *     3 -> 4 -> 8 -> 14 -> 22
 *     
 *     Notice that we removed the 1, because it was the smallest number and therefore had the highest priority.
 *     Next we add(2) to the priority queue. Our new priority queue looks as such:
 *     
 *     2 -> 3 -> 4 -> 8 -> 14 -> 22
 *     
 *     Note: polling values will not always result in an ordered sequence. We are only guaranteed that the next number
 *     removed from a priority queue is the smallest number that was currently in the priority queue. 
 *     
 *     So how does the Priority Queue know which element is the next smallest to element remove? As humans we can see 
 *     the numbers visually, but fundamentally how does the machine do it? Does it sort all of the elements inside of 
 *     the Priority Queue before polling? No, in fact that would be highly ineffective. Instead, it uses what is called
 *     a heap.
 */

public class PriorityQueue 
{

}
