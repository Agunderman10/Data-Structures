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
 *     Best First Search(BFS) algorithms such as A* use Priority Queues to continuously grab the next most promising
 *     node in the graph as it's being traversed.
 *     
 *     Used by Minimum Spanning Tree(MST) algorithms.
 * 
 * Complexity Analysis for Priority Queue with Binary Heap
 * 
 *     Binary Heap construction: O(n) linear time.
 *     Polling: O(log(n)) logarithmic time because we possible have to re-shuffle the heap to satisfy the heap invariant.
 *     Peeking: O(1) constant time.
 *     Adding: O(log(n)) logarithmic time because we possibly have to re-shuffle the heap to satisfy the heap invariant.
 *     Naive Removing: O(n) linear time. Removing an element that is not the root element. We potentially have to scan
 *     all of the elements in the PQ.
 *     Advanced Removing with help from a Hash Table: O(log(n)) logarithmic time. Using a hash table to help optimize
 *     this operation does take up linear space and also adds some overhead to the binary heap implementation.
 *     Naive contains: O(n) linear time.
 *     Contains check with help of a Hash Table: O(1) constant time. Using a hash table to optimize this operation does
 *     take up linear space and also adds some overhead to the binary heap implementation.
 *     
 * Turning Min PQ into Max PQ
 *     
 *     Problem: Often the standard library of most programming languages only provide a Min PQ which sorts by smallest
 *     elements first, but sometimes we need a Max PQ.
 *     
 *     Since elements in a priority queue are comparable they implement some sort of comparable interface which we can 
 *     simply negate, or invert, to achieve a Max heap.
 *     
 *     Let x and y be numbers in the priority queue. For a Min Priority Queue, if x <= y then x comes out before y, so
 *     the negation of this is if x >= y then y comes out before x. As a result of this negation, if we want to remove
 *     elements from a negated Priority Queue then we would remove the largest numbers. To demonstrate this, imagine we 
 *     have the following Priority Queue.
 *     
 *     2 13 3 5 11 7
 *     
 *     Note, it is a Priority Queue in which we have negated, or reversed the comparator. We will now remove the 
 *     elements according to the negated comparator. We remove according to the largest number now because it is a 
 *     negated Priority Queue. As a result, we grab the 13, then the 11, then the 7, and so on.
 *     
 *     An alternative method for numbers is to negate the numbers as you insert them into the PQ and negate them again
 *     when they are taken out. This has the same effect as negating the comparator. Let's see how this works. Assume
 *     we have the following numbers.
 *     
 *     2, 3, 5, 7, 11, 13
 *     
 *     We need to negate them, so we make reverse all of them to their opposite, or, in this case, negative format. 
 *     Our numbers are now -2, -3, -5, -7, -11, and -13. Now we continue as we would if we wanted to remove all of the
 *     numbers in a regular non-negated Priority Queue. We remove the smallest number until there are no numbers left. 
 *     The -13 is obviously the smallest of these numbers so we remove the -13, then the -11, then the -7, and so on
 *     and so forth. Remember we negate all of these numbers after we remove them so our end result is 13, 11, 7, 5, 3,
 *     and 2 in that order. Remember this will only work with numbers. 
 *     
 * Turning Min PQ into Max PQ with Strings 
 * 
 *     Suppose lex is a comparator for strings which sorts strings in lexicographic order(the default in most 
 *     programming languages). Then let nlex be the negation, or inverse, of lex, and also let S1 and S2 be some
 *     non-null strings. Lexicographic order simply means alphabetical/lexical order.
 *     
 *     lex(S1, S2) = -1 if S1 < S2 lexicographically
 *     
 *     lex(S1, S2) = 0 if S1 = S2 lexicographically
 *     
 *     lex(S1, S2) = +1 if S1 > S2 lexicographically
 *     
 *     nlex(S1, S2) = -(-1) = +1 if S1 < S2 lexicographically
 *     
 *     nlex(S1, S2) = -(0) = 0 if S1 = S2 lexicographically
 *     
 *     nlex(S1, S2) = -(+1) = -1 if S1 > S2 lexicographically
 */

public class PriorityQueue 
{

}

















