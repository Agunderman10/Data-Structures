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
 *     
 * Removing Elements from Binary Heap in O(log(n))
 * 
 *     The inefficientcy of the removal algorithm comes from the fact that we have to perform a linear search to find
 *     out where an element is indexed at. What if instead we did a lookup using a Hashtable to find out where a node
 *     is indexed at?
 *     
 *     A hashtable provides a constant time lookup and update for mapping from a key(the node value) to a value(the 
 *     index).
 *     
 *     Caveat: what if there are two or more nodes with the same value? What problems would that cause?
 *     Dealing with this multiple value problem: Instead of mapping one value to one position we will map one value to 
 *     multiple positions. We can maintain a Set or Tree Set of indexes for which a particular node value(key) maps to.
 *     
 *     Note that in our heap below we have multiple duplicate variables. We have 3 2s, and 2 7s.
 *     
 *               OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                 0,2,6       |           2                          0
 *     |     7                  1,4        |          / \                        / \ 
 *     |     11                  3         |         7   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *                                                 11 7 13 2                  3  4 5  6
 *                                                 
 *     The Hash Table is how we are going to keep track of the values of the indexes for the elements(their positions).
 *     If nodes start moving in the tree we also need to keep track of that. For example, if a Bubble Up or Bubble
 *     Down occurs, we need to keep track of that and where the swaps go to so we can update them in the map. 
 *     Let's say for example that we wish to swap 7 and 13. If we switch those values in our heap, then we also need
 *     to switch them in the hash table so we know where they are. Observe the changes below.
 *     
 *               OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                 0,2,6       |           2                          0
 *     |     7                  1,5        |          / \                        / \ 
 *     |     11                  3         |         7   2                      1   2
 *     |     13                  4         |        / \ / \                    / \ / \ 
 *                                                 11 13 7 2                  3  4 5  6
 *                                                 
 *     Notice the Position values in the map change as the positions in the heap change. 
 *     
 *     Question: If we want to remove a repeated node in our heap, which node do we remove and does it matter which one
 *     we pick? 
 *     
 *     Answer: No, it doesn't matter which node we remove as long as we satisfy the heap invariant in the end. 
 * 
 * Manipulating a Binary Heap with Hash Table
 * 
 *               OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                 0,2,6       |           2                          0
 *     |     7                  1,4        |          / \                        / \ 
 *     |     11                  3         |         7   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *                                                 11 7 13 2                  3  4 5  6
 *                                                 
 *     Above is the information for our binary heap. We have all of our values stored in a hash table and the heap
 *     is also shown. If we want to insert 3, what do we do? Firstly, just like before, we add the new node into the 
 *     insertion position in the bottom left of our Heap. We also need to add the new node to our hash table so we can
 *     track it. This is all shown below. Take note of all of the changes. 
 *     
 *               OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                 0,2,6       |           2                          0
 *     |     7                  1,4        |          / \                        / \ 
 *     |     11                  3         |         7   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *     |     3                   7         |       11 7 13 2                  3  4 5  6
 *                                                /                          /
 *                                               3                          7
 *                                               
 *     Now that the 3 is inserted, we need to make sure that the heap invariant is satisfied. Currently it is not. 
 *     Notice that we are dealing with a Min Heap. Since it is not, we need to bubble up the 3. We switch the 3 and 
 *     the 11. The heap invariant is still not satisfied because 3 is still a child of 7, which is larger. As a result,
 *     we must bubble up the 3 again and switch the 3 and the 7. Our heap invariant is now satisfied because the root,
 *     2, is smaller than its child of 3. Remember, when we switch the nodes in the heap we must also switch the values
 *     in the hash table so we can continue to track them. The 3 has been inserted successfully, this is shown below:
 *     
 *                OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                 0,2,6       |           2                          0
 *     |     7                  3,4        |          / \                        / \ 
 *     |     11                  7         |         3   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *     |     3                   1         |       7  7 13 2                  3  4 5  6
 *                                                /                          /
 *                                               11                         7
 *                                               
 *     Our next instruction is to remove 2 from the heap. So which 2 should we remove? Remember, we have 3 of them.
 *     Well, as said before, it doesn't matter which 2 that we remove as long as we satisfy the heap invariant in the 
 *     end. We need to think in terms of simplicity. If we remove the last 2 we can immediately satisfy the heap 
 *     invariant with one swap, but for learning purposes we will remove the first 2 that we come to, which in this 
 *     case shows up at index 0, the root. When we remove items from a Binary Heap with a Hash Table we do not have to
 *     use a linear scan to find the desired element. This is good because we can just do a lookup in the Hash Table,
 *     saving us valuable time. Remember, we swap the element we want to remove with the last element in the tree, in
 *     this case we swap the root and the last element. So, 2 now becomes the last element and the 11 becomes the root.
 *     We then can remove the last node. Don't forget to update the Hash Table values while we do this. We now have the
 *     following Heap and Hash Table. 
 *     
 *                 OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                  2,6        |          11                          0
 *     |     7                  3,4        |          / \                        / \ 
 *     |     11                  0         |         3   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *     |     3                   1         |       7  7 13 2                  3  4 5  6
 *                                                                           
 *     At this point we have successfully removed the 2, but the heap invariant is not satisfied because our root has
 *     a child that is smaller than itself and this is a Min Heap. So what do we need to do? We need to bubble the 11 
 *     down. We bubble the 11 down, remember we bubble it down to the smaller child's side, so we bubble our 11 down to
 *     the 2 which is 11's right child. The heap invariant is still not satisfied because the 11 still has a child 
 *     which is smaller than itself. Ergo, we bubble the 11 down once again in the position of the 2. Our heap
 *     invariant is now satisfied and we have successfully removed the 2. Don't forget the change the values in the
 *     Hash Table. You should have the following Heap and Hash Table. 
 *     
 *                OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                  0,2        |           2                          0
 *     |     7                  3,4        |          / \                        / \ 
 *     |     11                  6         |         3   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *     |     3                   1         |       7  7 13 11                 3  4 5  6
 *     
 *     Now, let's say we wish to call the poll() method and remove the root. What do we do? We do the same thing we've
 *     been doing when we remove elements. We switch the root, in this case, and the last element, or 11. Your new 
 *     Heap and Hash Table should look like this:
 *     
 *                OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                  2,6        |           11                         0
 *     |     7                  3,4        |          / \                        / \ 
 *     |     11                  0         |         3   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *     |     3                   1         |       7  7 13 2                  3  4 5  6
 *     
 *     We then can remove the 2 from the Heap. We also now need to satisfy the Heap invariant because we upset it by
 *     switching the last element to the root of the heap. The 11 has two children, 2 and 3. 2 is smaller so it is the
 *     child node that we are going to swap the 11 with. Swap the 11 and the 2. The heap invariant is still not 
 *     satisfied so we need to swap the 11 with its smallest child node. In this case, that is 2 again. We swap the
 *     two nodes, and now our heap invariant is satisfied. Your Heap and Hash Table should look like this:
 *     
 *                OUR HASHTABLE
 *     |Node Value(Key)  Position(s)(Value)|       Our Heap                  Index Tree
 *     |     2                  0,2        |           2                          0
 *     |     7                  3,4        |          / \                        / \ 
 *     |     11                  6         |         3   2                      1   2
 *     |     13                  5         |        / \ / \                    / \ / \ 
 *     |     3                   1         |       7  7 13 11                 3  4 5  6
 *                                                                          
 */

import java.util.*;

//Binary Heap implementation of a Min Priority Queue
//note: elements we allow into the PQ have to be comparable elements
public class PriorityQueue <T extends Comparable<T>>
{
	//the number of elements currently inside the heap
	private int heapSize = 0;
	
	//the internal capacity of the heap, may be larger than heapSize
	private int heapCapacity = 0;
	
	//a dynamic list to track the elements inside the heap(this is the actual heap)
	private List<T> heap = null;
	
	//This map keeps track of the possible indices of a particular node value that is found in the heap. Having this
	//mapping lets us have O(log(n)) removals and O(1) element containment check at the cost of some additional space
	//and minor overhead
	//Here we can map an element to a TreeSet of Integers. (All of the positions inside our heap)
	private Map<T, TreeSet<Integer>> map = new HashMap<>();
	
	//Construct and initially empty our Priority Queue
	public PriorityQueue()
	{
		this(1);
	}
	
	//Construct a PQ with an initial capacity
	public PriorityQueue(int size)
	{
		heap = new ArrayList<>(size);
	}
	
	//Construct a PQ using heapify in O(n) time
	//if you know all of the elements that are going to be inside your heap, you can actually construct the PQ in 
	//linear time using heapify. We did not talk about this in the documentation, but it can be very, very, useful. 	
	//a great explanation of this can be found here:
	//http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
	public PriorityQueue(T[] elems)
	{
		heapSize = heapCapacity = elems.length;
		heap = new ArrayList<T>(heapCapacity);
		
		//place all elements in heap
		for(int i = 0; i < heapSize; i++)
		{
			mapAdd(elems[i], i);
			heap.add(elems[i]);
		}
		
		//heapify process, O(n)
		for(int i = Math.max(0, (heapSize / 2)-1); i >= 0; i--)
		{
			sink(i);
		}
	}
	
	//PQ construction, O(nlog(n)), use heapify above whenever possible for speed
	public PriorityQueue(Collection<T> elems)
	{
		this(elems.size());
		for(T elem : elems)
		{
			add(elem);
		}
	}
	
	//returns true/false depending on if the PQ is empty
	public boolean isEmpty()
	{
		return heapSize == 0;
	}
	
	//clears everything inside the heap and hash map, O(n)
	public void clear()
	{
		for(int i = 0; i < heapCapacity; i++)
		{
			heap.set(i, null);
		}
		heapSize = 0;
		map.clear();
	}
	
	//return the size of the heap
	public int size()
	{
		return heapSize;
	}
	
	//returns the value of the element with the lowest priority(since this is a Min Heap) in this PQ(return the root).
	//If the PQ is empty null is returned
	public T peek() 
	{
		if(isEmpty())
		{
			return null;
		}
		return heap.get(0);
	}
	
	//removes the root of the heap, O(log(n))
	public T poll()
	{
		return removeAt(0);
	}
	
	//test if an element is in the heap, O(1)
	public boolean contains(T elem) 
	{
		//map lookup to check containment, O(1)
		if(elem == null)
		{
			return false;
		}
		//we can just lookup the value in the map, which is O(1)
		return map.containsKey(elem);
		
		//if we did not use the map we would have to do a linear scan to check for containment, which is O(n).
		/*
		for(int i = 0; i < heapSize; i++)
		{
			if(heap.get(i).equals(elem)) 
			{
				return true;
			}
			return false;
		}
		*/
		
		//The map does add a lot of constant overhead which you may or may not want, people generally don't maintain
		//the map, but I wanted to show that it could be done. People don't usually remove things from the maps much,
		//so the hash map is generally considered unnecessary unless you are removing a LOT of values. 
	}
	
	//adds an element to the PQ, the element must not be null, O(log(n))
	public void add(T elem) 
	{
		//element can't be null
		if(elem == null)
		{
			throw new IllegalArgumentException();
		}
		
		//if there is room for the new element we can go ahead and add it, if not we need to expand the heap
		if(heapSize < heapCapacity)
		{
			heap.set(heapSize, elem);
		}
		else 
		{
			heap.add(elem);
			heapCapacity++;
		}
		
		//add the new values to the map so we can track them
		mapAdd(elem, heapSize);
		
		//swim the new node up to maintain the heap invariant
		swim(heapSize);
		heapSize++;
	}
	
	//tests if the value of node i <= node j
	//this method assumes i and j are valid indices, O(1)
	//helper method that helps us check if node i is less than or equal to node j
	private boolean less(int i, int j)
	{
		T node1 = heap.get(i);
		T node2 = heap.get(j);
		
		//the two nodes are comparable so we can use the compareTo() method
		//comes from the comparable interface we extended earlier
		return node1.compareTo(node2) <= 0;
	}
	
	//bottom up node swim, (log(n))
	private void swim(int k)
	{
		//grab the index of the next parent node WRT to k
		//remember we start our heap at 0
		int parent = (k-1) / 2;
		
		//keep swimming while we have not reached the root and while we're less than our parent
		while(k > 0 && less(k, parent))
		{
			//exchange k with the parent
			swap(parent, k);
			k = parent;
			
			//grab the index of the next parent node WRT to k
			parent = (k-1) / 2;
		}
	}
	
	//top down node sink, O(log(n))
	private void sink(int k)
	{
		while(true) 
		{
			//zero based formulas for our list
			int left = 2 * k + 1; //left node
			int right = 2 * k + 2; //right node
			int smallest = left; // assume left is the smallest node of the two children
			
			//find which is smaller, left or right?
			//if right is smallest set smallest to be right. 
			if(right < heapSize && less(right, left))
			{
				smallest = right;
			}
			
			//stop if we're outside the bounds of the tree
			//or stop early if we cannot sink k anymore
			if(left >= heapSize || less(k, smallest)) 
			{
				break;
			}
			
			//move down the tree following the smallest node
			swap(smallest, k);
			k = smallest;
		}
	}
	
	//swap two nodes. Assume i and j are valid, O(1)
	private void swap(int i, int j)
	{
		T i_elem = heap.get(i);
		T j_elem = heap.get(j);
		
		heap.set(i, j_elem);
		heap.set(j, i_elem);
		
		//this is what causes a lot of the overhead for the map. each time we call the swap method we also have to swap
		//values inside the map which can be a lot of overhead. technically maps are constant lookup times, but the 
		//fact that you're doing all of this internal hashing and collisions, etc, it can get costly.
		mapSwap(i_elem, j_elem, i, j);
	}
	
	//removes a particular element in the heap, O(log(n))
	public boolean remove(T element)
	{
		//we know we don't have any null elements in our heap because we don't allow them.
		if(element == null)
		{
			return false;
		}
		
		//linear removal via search, O(n)
		/*
		for(int i = 0; i< heapSize; i++)
		{
			if(element.equals(heap.get(i)))
			{
				removeAt(i);
				return true;
			}
		}
		*/
		//logarithmic removal with map, O(log(n))
		Integer index = mapGet(element);
		if(index != null) 
		{
			removeAt(index);
		}
		
		return index != null;
	}
	
	//Removes a node at  particular index, O(log(n))
	private T removeAt(int i)
	{
		//if heap is empty, can't remove anything
		if(isEmpty())
		{
			return null;
		}
		
		heapSize--;
		T removed_data = heap.get(i);
		//swap index of what we want to remove with the last element
		swap(i, heapSize);
		
		//kill off the node and remove it from our map
		heap.set(heapSize, null);
		mapRemove(removed_data, heapSize);
		
		//removed last element
		if(i == heapSize)
		{
			return removed_data;
		}
		
		T elem = heap.get(i);
		
		//try sinking element
		sink(1);
		
		if(heap.get(i).equals(elem))
		{
			swim(i);
		}
		
		return removed_data;
	}
	
	//Recursively checks if this heap is a Min Heap, this method is just for testing purposes to make sure the heap
	//invariant is still being maintained, called the method with k=0 to start at the root
	public boolean isMinHeap(int k)
	{
		//if we are outside the bounds of the heap return true
		if(k >= heapSize)
		{
			return true;
		}
		
		//get our child nodes
		int left = 2 * k + 1;
		int right = 2 * k + 2;
		
		//make sure that the current node k is less than both of its children left, and right if they exist return 
		//false otherwise to indicate an invalid heap
		if(left < heapSize && !less(k,left)) 
		{
			return false;
		}
		if(right < heapSize && !less(k, right))
		{
			return false;
		}
		
		//recurse on both children to make sure they're also valid heaps
		return isMinHeap(left) && isMinHeap(right);
	} 
	
	//add a node value and its index to the map
	private void mapAdd(T value, int index)
	{
		//using a TreeSet to add and remove elements because we know the TreeSet implementation in java is a balanced
		//binary search tree so all operations on TreeSets are logarithmic
		TreeSet<Integer> set = map.get(value);
		
		//new value being inserted into map
		if(set == null)
		{
			set = new TreeSet<>();
			set.add(index);
			map.put(value, set);
		}
		else 
		{
			set.add(index);
		}
	}
	
	//removes the index at a given value, O(log(n))
	private void mapRemove(T value, int index)
	{
		TreeSet<Integer> set = map.get(value);
		set.remove(index); //TreeSets take O(log(n)) removal time
		if(set.size() == 0)
		{
			map.remove(value);
		}
	}
	
	//extract an index position for the given value. Note: if a value exists multiple times in the heap the highest 
	//index is returned(this has been arbitrarily chosen)
	private Integer mapGet(T value)
	{
		TreeSet<Integer> set = map.get(value);
		if(set != null)
		{
			return set.last();
		}
		
		return null;
	}
	
	//exchange the index of two nodes internally within the map
	private void mapSwap(T val1, T val2, int val1Index, int val2Index)
	{
		Set<Integer> set1 = map.get(val1);
		Set<Integer> set2 = map.get(val2);
		
		set1.remove(val1Index);
		set2.remove(val2Index);
		
		set1.add(val2Index);
		set2.add(val1Index);
	}
	
	@Override
	public String toString()
	{
		return heap.toString();
	}
	
}