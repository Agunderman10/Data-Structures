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
 *     
 * What is a heap?
 * 
 *     A heap is a tree based data structure that satisfies the heap invariant(also called heap property): If A is a 
 *     parent of B then A is ordered with respect to B for all nodes A, B in the heap. What this means is that in a 
 *     heap, the value of the parent node is always greater than or equal to the value of the child node for all nodes.
 *     Or the other way around, that the parent node is always less than or equal to the value of the child node for all
 *     nodes in the heap. This means that we end up getting two types of heaps, Max Heaps and Min Heaps. Both of the 
 *     following are actually binary heaps, meaning that every node has exactly two children, the nodes that you 
 *     cannot see are null values I have not yet drawn in. Min Heaps are often seen in binomial heaps. Also note that
 *     not all heaps are binary heaps, they can have any number of branches.
 *     
 *        8                     0
 *       / \                   / \
 *      7   6                 2   3
 *     / \  |                /\   /\
 *    3   2 5               4  5  6 4
 *    Max Heap               Min Heap
 *    
 *    Remember, if a tree violates the heap invariant then it is NOT a heap. Also note, if a structure contains a 
 *    cycle(where nodes form a cycle by pointing at one another) it is not a tree and therefore NOT a heap.
 *    
 * Why Are We Interested In Heaps?
 * 
 *     Heaps form the underlying data structure for priority queues. Sometimes, people even refer to priority queues
 *     as heaps, although this isn't technically correct since again the priority queue is an abstract data type 
 *     meaning it can be implemented with other data structures also. 
 *     
 * When and Where is a Priority Queue used?
 * 
 *     Used in certain implementations of Dijkstra's Shortest Path Algorithm to fetch the next node we want to explore.
 *     
 *     Any time you need to dynamically fetch the 'next best' or 'next worst' element.
 *     
 *     Used in Huffman coding (which is often used for loss-less data compression).
 *     
 *     Best First Seach(BFS) algorithms such as A* use Priority Queues to continuously grab the next most promising
 *     node in the graph as it's being traversed.
 *     
 *     Used by Minimum Spanning Tree(MST) algorithms.
 * 
 */

public class PriorityQueue 
{

}

















