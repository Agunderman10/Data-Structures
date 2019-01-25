/*
 * What is a Linked List?
 *     A linked list is a sequential list of nodes that hold data which point to other nodes also containing data.
 *     Each node has a pointer to the next node. The last node will point to null meaning there are no other
 *     nodes at this point. The last node always has a null reference. 
 *     Data->Data->Data->Data->null
 *     
 * Where are Linked Lists used?
 *     Used in many list, queue, and stack implementations because of great time complexity for adding and removing 
 *     elements. Great for creating circular lists making the pointer of the last node point to the first node. 
 *     Circular linked lists are used to model repeating event cycles like having a round robbin ordering. Can 
 *     easily model real world objects such as trains. Used in separate chaining, which is present in certain 
 *     Hashtable implementations to deal with hashing collisions. Often used in the implementation of adjacency 
 *     lists for graphs.
 *     
 * Terminology
 *     Head: the first node in a linked list
 *     Tail: the last node in a linked list
 *     Pointer(aka reference): reference to another node
 *     Node: an object containing data and pointer(s). Often represented as structs or classes when actually implemented
 *     3 -> 84 -> 85 -> 21 -> 90 -> 29 -> 44 -> 30
 *     ^head   ^pointer       ^node             ^tail
 *     
 * Singly vs Doubly Linked Lists
 *     Singly linked lists only hold a reference to the next node. In the implementation you always maintain a 
 *     reference to the head of the linked list and a reference to the tail node for quick additions/removals.
 *     3 -> 84 -> 85 -> 21 -> 90 -> 29 -> 44 -> 30
 *     
 *     With Doubly linked lists each node holds a reference to the next and previous node. In the implementation you
 *     always maintain a reference to the head and the tail of the doubly linked list to do quick additions/removals
 *     from both ends of your list.
 *     15 <-> 6 <-> 23 <-> 4 <-> 7 <-> 71 <-> 5 <-> 50
 *     
 * Singly and Doubly Linked Lists Pros and Cons
 *     Singly Linked List Pros:
 *         Uses less memory. Pointers to nodes can take up a lot of memory. If you are running on a 64 bit machine
 *         then pointers take 8 bytes each. On a 32 bit machine they take 4 bytes each. A singly linked lists means
 *         you only need one pointer for each node. This is a lot less memory than a doubly linked list.
 *         Singly Linked Lists also have a simpler implementation.
 *         
 *     Singly Linked List Cons:
 *         Cannot easily access previous elements because we don't have access to them with pointers only pointing 
 *         to the next element. You would have to traverse from the head of the linked list all the way to the end
 *         and back around to find the previous element.
 *         
 *     Doubly Linked List Pros:
 *         Can be traversed backwards because pointers point both ways. Also having a reference to a node we want to
 *         remove means that we can remove it in constant time and hash the whole you create. 
 *         
 *     Doubly Linked List Cons:
 *         Takes 2x the memory because there are two times the pointers.
 *         
 * Implementation Details
 *     Inserting with Singly Linked List:
 *         head            tail
 *         5 -> 23 -> 7 -> 13
 *         
 *         Insert 11 where the third node is: 
 *         First thing we do is create a new pointer that points to the head, which is 5 in this case. This is 
 *         the first step in almost all linked list operations. We now want to seek up to but not including the 
 *         node we want to remove. So now we advance our traversal pointer to the 23, because it is the next node 
 *         after 5 that 5's pointer points to. Now we're ready to insert the next node. Remember, we are traversing
 *         up to but not including the node where we want to insert. So we want to insert into the third position but
 *         we stop at the 2nd node. We now create the next node of 11. We then make 11 point to 7. This is shown below.
 *         
 *         head trav       tail
 *         5 -> 23 -> 7 -> 13
 *                    ^
 *                    11
 *         
 *         The next step is to now make the previous node(in this case the second node of 23)'s pointer point to the 
 *         new node, in this case the 11. This is shown below.
 *         
 *         head trav       tail
 *         5 -> 23 -> 7 -> 13
 *              |     ^
 *              ----> 11
 *              
 *         Remember we have access to 23's next pointer because we have a reference to it with the traversal.
 *         Now we can flatten out the linked list and see that we successfully have inserted 11 into the linked list.
 *         
 *         head                  tail
 *         5 -> 23 -> 11 -> 7 -> 13
 *         
 *     Inserting with Doubly Linked List:
 *         head               tail
 *         5 <-> 23 <-> 7 <-> 13
 *         
 *         Insert 11 where the third node is:
 *         Trickier because of all of the pointers everywhere but it is the same concept. Note that the doubly linked
 *         list has pointers not only for the next node, but also for the previous node. We will also have to change
 *         those in the insertion phase. First thing we do is create a new traversal pointer that points to the
 *         head(5 in this case). All we need to do is advance that traversal pointer until we are on the node 
 *         before the desired insertion node, in this case we need to advance to the 2nd node because we want to 
 *         insert on the third node. So we advance the traverser by one and now we are on 23, the second node. Because
 *         this is the node before where we want to insert we stop traversing. Next, we create the new node of 11 and
 *         we have it point at 7. We also need to point 11's previous node pointer to point at 23 because it is the
 *         previous node. We have access to the previous node because of our traverser. Now we make 7's previous node
 *         pointer point at 11 and NOT 23 so we can go backwards through the linked list later. Remember we are working
 *         with a doubly linked list. Next we need to make 23's next node pointer point to the 11 so we can later
 *         traverse forward through the linked list. In total we changed exactly 4 pointers. If we flatten out the
 *         list we can now see that we successfully inserted 11 into the third node's spot. 
 *         
 *         head                      tail
 *         5 <-> 23 <-> 11 <-> 7 <-> 13
 *               ^traversal
 *               
 *     Removing from a Singly Linked List:
 *     
 *         head                tail
 *         7 -> 0 -> 4 -> 9 -> 15
 *    trav1^    ^trav2
 *         
 *         Remove 9 from the Singly Linked List:
 *         In this example we are going to use two pointers. We can use one, but for visual effect it will be easier
 *         to show how this works with two. trav1 points to the head, and trav2 points to the head's next node. Now
 *         what we are going to do is advance both travs until we find the node that we want to remove with trav2.
 *         When we find the node we want to remove, in this case 9, we stop. Now we create another pointer(temp) to the
 *         node that we wish to remove so that we can de-allocate its memory later. After this, we advance trav2 
 *         to the node after the node we wish to remove. This is all represented below:
 *         
 *         head           temp tail
 *         7 -> 0 -> 4 -> 9 -> 15
 *              trav1^         ^trav2
 *         
 *         Note that trav1 is pointing at the node 4 which is before the node we want to remove(node 9) and that
 *         trav2 is pointing at node 15 because it is the node after the one we want to remove(node 9). At this point 
 *         node 9 is ready to be removed. We now set trav1's next pointer to point at trav2. We can now remove the
 *         temp pointer that is connected to node 9. This removes node 9. Always remember to clean up your memory
 *         to avoid memory leaks. This is especially important in C and C++ and other programming languages where 
 *         you have to manage your memory. Now you can see that 9 is gone and our singly linked list is shorter.
 *         This is shown below:
 *         
 *         head           tail
 *         7 -> 0 -> 4 -> 15
 *              trav1^    ^trav2
 *     
 *     Removing from a Doubly Linked List:
 *     
 *         head                    tail
 *         7 <-> 0 <-> 4 <-> 9 <-> 15
 *                   
 *         Remove 9 from the Doubly Linked List:
 * 
 */



public class LinkedList {

}
