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
 */

public class Queue 
{

}
