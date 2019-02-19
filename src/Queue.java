/*
 * What is a queue?
 *     A queue is a linear data structure which models real world queues by having two primary operations,
 *     namely enqueue and dequeue. Every queue has a front and a back. A visual representation is shown below.
 *     
 *     elem elem elem elem elem
 *     ^queue front        ^queue back
 *     
 *     In a queue we insert elements through the back and remove through the front. Adding elements to the back of the
 *     queue if called enqueueing and removing an element from the front is called dequeuing. Sometimes enqueue may
 *     also be called adding or offering and dequeuing may be called polling or removing.
 *     
 * Queue behavior example:
 *     
 *     Assume we have the following queue:
 *     
 *     55 -1 33 17 11
 *     ^front      ^back
 *     
 *     If we want to enqueue 12 then we add the item to the back of the list. Queues are FIFO, or first in first out.
 *     So our new queue would look like this:
 *     
 *     55 -1 33 17 11 12
 *     ^front         ^back
 *     
 *     Now if we want to dequeue an element we will be dequeuing the front, so the 55. Our new queue will look like 
 *     this:
 *     
 *     -1 33 17 11 12
 *     ^front      ^back
 *     
 *     Next, we want to dequeue another element, once again it's the front of the list so the -1. The new queue will 
 *     look like this:
 *     
 *     33 17 11 12
 *     
 *     Then we want to enqueue 7. We enqueue this on the back of the queue as such:
 *     
 *     33 17 11 12 7
 *     
 * When and where is a queue used?
 * 
 *     Any waiting line models a queue, such as a line for food at McDonalds.
 *     
 *     Can be used to efficiently keep track of the x most recently added elements to something.
 *     
 *     Web server request management where you want first come first serve. Suppose you have a web server that's idly
 *     waiting for requests from people to use your website and you can only process 5 requests at a time. 12 requests
 *     come in so you process the first 5 and the other 7 requests wait in a queue to be processed. Whenever you finish
 *     processing a request you dequeue the next request and you keep doing this until your queue is empty, aka when 
 *     all of the requests have been processed.
 *     
 *     Breadth first search (BFS) graph traversal.
 *     
 * Complexity Analysis
 *     
 *     Enqueue: O(1) constant time.
 *     Dequeue: O(1) constant time.
 *     Peeking: O(1) constant time.
 *     Contains: O(n) linear time since we potentially have to search through every element of the queue.
 *     Removal: O(n) linear time. This is not in the sense of dequeuing or polling, but in actually removing the element
 *     from the queue internally. This is linear time because we would potentially have to search through all of the 
 *     elements in the queue to find the element we want to remove. 
 *     IsEmpty: O(1) constant time.
 *     
 * Breadth First Search with a Queue explanation:
 *  
 *     The Breadth First Search is performed on a graph by starting at a node and traversing the entire graph, first by
 *     visiting all of the neighbors of the starting node, and then visiting all of their neighbors. When talking
 *     about a graph we are talking about a network such as shown below, not like a bar or line graph.
 *     
 *     4--5--3
 *     |           10
 *     2--7
 *     |
 *     0--2--8    9--2
 *            \   |
 *             9--89
 *             
 *     Assume we start at 3. We search all of the nodes connected to 3, this is only the 5. Then we search the nodes
 *     connected to 5, only 4. Then we search 4's neighbors, only 2. Then we search 2's neighbors, this is 7 and 0.
 *     We continue in this pattern, visiting all of the neighbors of each node. Notice the 10. The 10 is not connected
 *     to the graph and so we cannot visit its node with the Breadth First Search. 
 *     
 * Psuedo code for implementing a Breadth First Search with a queue:
 * 
 *     Let Q be a Queue
 *     Q.enqueue(starting_node)
 *     starting_node.visited = true
 *     
 *     //while our queue is not empty we dequeue an element 
 *     while Q is not empty Do
 *         node = Q.dequeue()
 *         
 *         //for every neighbor that has not been visited yet we enqueue
 *         For neighbor in neighbors(node):
 *             if neighbor has not been visited:
 *                 neighbor.visited = true
 *                 Q.enqueue(neighbor)
 *                 
 * Implementation details for Queues:
 * 
 *     Queues can be implemented in multiple ways, but the most popular ways are to use either arrays, singly linked 
 *     lists, or doubly linked lists. If you're using an array you have to make sure your array is going to be big
 *     enough, if it's a static array. If it's a dynamic array you should be fine.
 *     
 *     This implementation example will be executed with a singly linked list, but the actual code implementation will
 *     be done with a doubly linked list. 
 *     
 *     Firstly, in a queue we will always have a head and a tail pointer. If our queue is empty or has one element in
 *     it both the tail and head pointers will point at the same element as shown below. Initially they are both null.
 *     
 *     Null <- head
 *     ^tail
 *     
 *     As we enqueue more elements we are pushing the tail elements forward so we're enqueueing a new node and making
 *     the tail pointer move to the next element. If we enqueue 5, 1, 6, 17, and 8 then our new queue will look like
 *     this. Notice the placement of the head and tail pointers on the ends of the queue.
 *     
 *     5 -> 1 -> 6 -> 17 -> 8 -> Null
 *     ^head                ^tail
 *     
 *     As we dequeue we instead will be pushing the head forward. If we want to dequeue two elements then we will move
 *     the head pointer forward two elements. We set the current node = to Null so it can be picked up by the garbage
 *     collector and advance the head pointer. Remember, if you are in another programming language that requires 
 *     you to manage your own memory (C/C++) you must delete the nodes manually or you may cause memory leaks. 
 *     
 */

public class Queue 
{

}






