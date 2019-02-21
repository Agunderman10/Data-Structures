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
 *     
 *     Using nlex instead of lex would effectively turn a Min Heap into a Max Heap. Let's look at an example.
 *     
 *     Assume we have the string values XX, FZ, A, B, X, and XR. By adding all of these strings to the Priority Queue 
 *     with the lex comparator we expect to get the order in the following:
 *     
 *     A, B, FZ, X, XR, XX
 *     
 *     Now let's do the same thing with nlex. By doing this we should obtain the opposite sequence from the lex 
 *     sequence. We should obtain that order in the following:
 *     
 *     XX, XR, X, FZ, B, A
 *     
 * Adding Elements to a Binary Heap
 * 
 *     Ways of Implementing a Priority Queue: A very popular way to implement a Priority Queue is to use some kind of 
 *     heap because this gives them the best possible time complexity for the operations we want to complete. The 
 *     Priority Queue is an Abstract Data Type(ADT) hence heaps are not the only way to implement PQs. As an example, 
 *     we could use an unsorted list, but this would not give us the best possible time complexity. 
 *     
 *     Remember, a Priority Queue is NOT a heap.
 *     
 *     There are many types of heaps that we could use to implement a PQ including:
 *     
 *     Binary Heaps
 *     Fibonacci Heaps
 *     Binomial Heaps
 *     Pairing Heaps
 *     
 *     For simplicity, we are going to use a Binary Heap. 
 *     
 * Priority Queue with Binary Heap
 * 
 *     A binary heap is a binary tree that supports the heap invariant. In a binary tree every node has exactly two 
 *     children. We went over the heap invariant and what binary trees look like above. A Complete Binary Tree is a 
 *     tree in which at every level, except possibly the last is completely filled and all the nodes are as far left
 *     as possible. Maintaining a complete binary tree is very, very important because it gives us an insertion point
 *     no matter what the tree looks like, or what values are in it. 
 *     
 *     We need to understand how to represent one of these binary heaps, and there is a canonical way of doing this,
 *     and that is to use an array. Using an array is a convenient way of doing this because when we are maintaining
 *     this complete binary tree property the insertion position is simply the last index in the array. This is not
 *     the only way we can represent the heap, we can also represent the heap using objects and pointers and 
 *     recursively adding and removing nodes as needed, but the array construction is very elegant and also very, very
 *     fast. Below I have the array indexes lined up with the tree values to help you visualize what I'm talking about
 *     here. Below is tree visuals and the array visuals. 
 *     
 *         Representing Binary Heaps with an Array
 *         
 *         |9|8|7|6|5|1|2|2|2|3|4 |0 |1 |2 |1 | tree values
 *         ------------------------------------
 *         |0|1|2|3|4|5|6|7|8|9|10|11|12|13|14| array indexes
 *         
 *         Index Tree                                        Actual Heap
 *              0                                                9   
 *             / \                                              / \
 *            /   \                                            /   \
 *           1      2--\                                      8     7--\
 *          / \    /    \                                    / \   /    \
 *        3   4    5     6                                 6   5   1     2
 *       / \ / \  / \   /  \                             / \  / \ / \   / \ 
 *      7  8 9 10 11 12 13 14                            2  2 3 4 0 1   2 1
 *      
 *      Heap values are very convenient to access when using an array. For example:
 *      
 *      Let i be the parent node index
 *      
 *      Left child index = 2i + 1
 *      Right child index = 2i + 2
 *      (zero based array, if it was one based then you could just subtract one)
 *            
 *      Using this, we can tell how easy it is to find the child nodes of any parent in the heap. 
 *      Seeing this put into use let's say we have index 2(value 7). The left child is 1. If we want to find this with
 *      our formula it would be 2i + 1 or 2(2) + 1, which is index 5, or number 7 on the tree. 
 *      
 * Adding Elements to Binary Heap
 * 
 *     Now we want to know, how do I add nodes to the Binary Heap AND maintain the heap invariant, because without 
 *     the heap invariant the binary heap is useless. Let's say we want to insert a 1 to the binary heap below. A 1 
 *     should be at the root, since we are dealing with a Min Heap, but instead of inserting 1 at the root of the heap
 *     directly what we do is we put 1 at the bottom left of the tree in the insertion position we mentioned earlier.
 *     We then perform what's called "bubbling up". This is sometimes called swimming or even sifting up. So, we insert
 *     our 1 as shown below, in the insertion position. Now we find that we are in violation of the heap invariant, 
 *     because the 1 is the smallest element and it is at the bottom of the Min Heap. So what do we do?
 *     
 *                5
 *               / \
 *              6   12
 *             / \  / \
 *            8  1
 *            
 *     What we do is we swap 1 and 6, but now we are still in violation of the heap invariant because 6 is greater than
 *     1 and we find that 1 is a child of 5. So what do we do? You guessed it! We swap them again. Now our 1 is the
 *     root of our tree and the heap invariant has been maintained successfully. 
 *     
 *     Now we have the number 13 that we want to insert. Once again, we put 13 into the insertion position as shown 
 *     below. Remember the insertion position is the bottom left most spot on the tree. 
 *     
 *                1
 *               / \
 *              5   12
 *             / \  / \
 *            8  6 13
 *     
 *     We check to see if the 13 needs to bubble up at all and we find that it doesn't because its parent node is 
 *     smaller. We now want to insert 4 into the heap. We put it into the insertion position. Can you find where it 
 *     goes? We add 4 as the right child to the 12 node. Then, because this is a Min Heap we can see that the Heap
 *     invariant is not satisfied. We bubble up the 4 and switch the 4 and 12. Now, the heap invariant is restored.
 *     The correct heap is below.
 *     
 *                1
 *               / \
 *              5   12
 *             / \  / \
 *            8  6 13  4
 *            
 *     Remember, maintaining a Complete Binary Tree is very important for maintaining an insertion point. 
 *     
 * Removing Elements from a Binary Heap
 * 
 *     In a Binary Heap, we always want to remove from the root node because it is the node of interest. It is the 
 *     node with the largest priority in a Max or Min heap because the largest or smallest value will be stored here.
 *     When we remove the root we call it polling. The special thing about the root is that we don't need to search for
 *     its index because in an array implementation it has index 0.
 * 
 *     Imagine we have the following Min Heap:
 *     
 *                1
 *               / \
 *              5   12
 *             / \  / \
 *            8  6 13  7
 *            
 *     When we call the poll() method, we want to remove the root. So how do we do this? Remember, we have the
 *     insertion point. The insertion point also happens to be the same place that we will be removing elements from.
 *     When polling, what we need to do is swap the root and the last element in the Binary Heap. So in this case we
 *     switch positions of the 1 and the 7. This is shown below:
 *     
 *                7
 *               / \
 *              5   12
 *             / \  / \
 *            8  6 13  1
 *            
 *     Now that we have the 1 in the insertion position, we can remove it. Our new Binary Heap is shown below:
 *     
 *                7
 *               / \
 *              5   12
 *             / \  / \
 *            8  6 13  
 *            
 *     Next, notice that the heap invariant is no longer satisfied because we are dealing with a Min Heap and the 7 is
 *     larger than the 5. We now need to Bubble Down. Remember we Bubble Down into the smaller nodes so that's why we
 *     bubble down to the 5 instead of the 12. When the nodes are the same, imagine it was 5 and 5, then we would
 *     default with the left node. We switch the 5 and the 7 and our new heap is shown below:
 *     
 *                5
 *               / \
 *              7   12
 *             / \  / \
 *            8  6 13  
 *            
 *     We still aren't done. The 7 has a child node of 6, which is smaller so the heap invariant still is not satisfied.
 *     We need to switch the 6 and the 7. This is shown below.
 *     
 *                5
 *               / \
 *              6   12
 *             / \  / \
 *            8  7 13  
 *     
 *     Next, we want to remove 7. Polling was removing the root, but here we are removing an element that is not the
 *     root. So what do we do? We have to search for 7 even though we don't know its position yet. When we do this,
 *     we start at the root, so in this case 5. Now we must do a linear scan through the Heap to find our element, in 
 *     this case 7. When we eventually find the 7 we now must switch it with the element at the insertion point. 
 *     Therefore, we switch the 7 and the 13. Our heap now looks like this:
 *     
 *                5
 *               / \
 *              6   12
 *             / \  / \
 *            8  13 7
 *            
 *     Now we can remove the 7 as shown below.
 *     
 *                5
 *               / \
 *              6   12
 *             / \  / \
 *            8  13 
 *         
 * Time Complexity for Removing Elements from a Binary Heap
 * 
 *     Polling - O(log(n)) logarithmic time since we're removing the root and we already know where to find it.
 *     Removing - O(n) linear time since we have to find the index of that node to remove before removing it.
 */

public class PriorityQueue 
{

}

















