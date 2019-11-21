/*
 * What is a Tree? (Generic Trees)
 * 
 *     A tree is an undirected graph which satisfies any of the following definitions. There are more definitions, but
 *     these are the most popular ones:
 *     
 *         An acyclic connected graph
 *         
 *         A connected graph with N nodes and N-1 edges
 *         
 *         A graph in which any two vertices are connected by exactly one path
 *     
 *     If we have a rooted tree then we will want to have a reference to the root node of our tree. It does not always
 *     matter which node is selected to be the root node because any node can root the tree.
 *     
 *     A child is a node extending from another node. A parent in the inverse of this. For example, in the visual below
 *     A is the parent of B and B is the child of A.
 *     
 *     A
 *     ^
 *     B
 *     
 *     Q: What is the parent of the root node?
 *     
 *     A: It has no parent, although it may be useful to assign the parent of the root node to be itself.
 *     
 *     A leaf node is a node with NO children. These will be at the very bottom of the tree. For example, D, E, F and G
 *     are leaf nodes below:
 *     
 *         A
 *        / \
 *       B   C
 *      / \ / \
 *     D  E F  G
 *     
 *     A subtree is a tree entirely contained within another. They are usually denoted using triangles. Note: Subtrees
 *     may consist of a single node. 
 *     
 * What is a Binary Tree(BT)?
 * 
 *     A binary tree is a tree for which every node has at most two child nodes.
 *     
 * What is a Binary Search Tree(BST)?
 * 
 *     A Binary Search Tree is a binary tree that satisfies the BST invariant: left subtree has smaller elements than
 *     the value of the current node and the right subtree has larger elements than the value of the current node.
 *     
 * Is this a valid BST?
 * 
 *      3
 *     / \
 *     3 4
 *    
 *     It depends on whether you want to allow duplicate values in your tree. BST operations allow for duplicate values,
 *     but most of the time we are only interested in having unique elements inside our tree.
 *    
 *            5
 *           / \
 *          4   7
 *         /   / \
 *        3   6   8
 *        
 *     Yes. The values smaller than the current node are the left children and the nodes larger than the current node
 *     are the right children.
 *    
 *            D
 *           / \
 *          C   Y
 *         /   / \
 *        A   X   Z
 *        
 *     Yes. We are not limited to only using numbers. Any data that can be ordered can be place inside a BST. 
 *    
 * When and Where are Binary Search Trees used?
 * 
 *     Implementation of some map and set ADTs(Abstract Data Types)
 *     
 *     Balanced Binary Search Trees
 *     
 *     Red Black Trees
 *     
 *     AVL Trees
 *     
 *     Splay Trees
 *     
 *     etc...
 *     
 *     Used in implementation of Binary Heaps
 *     
 *     Syntax trees (used by compiler and calculators)- parsing an arithmetic expression and you place it in an abstract
 *     syntax tree and then you can simplify your expression. So whatever you punch into your calculator gets parsed
 *     into a binary tree and evaluated.
 *     
 *     Treap - a probabilistic data structure (uses a random BST)
 *     
 * Time Complexity of BSTs
 * 
 *     Operation    Average    Worst
 *     Insert      O(log(n))   O(n)
 *     Delete      O(log(n))   O(n)
 *     Remove      O(log(n))   O(n)
 *     Search      O(log(n))   O(n)
 *                logarithmic linear
 *     
 *     Adding Elements to a Binary Search Tree
 *     BST elements must be comparable so that we can order them inside the tree. When inserting an element
 *     we want to compare its value to the value stored in the current node we're considering to decide
 *     on one of the following:
 *     
 *         Recurse down left subtree (< case)
 *         Recurse down right subtree (> case)
 *         Handle finding a duplicate value (= case)
 *         Create a new node (found a null leaf)
 *         
 *     Let's say we want to insert(7). Let's take a look at what this will be like. This null BST is all we
 *     have at the moment:
 *     
 *     null
 *     
 *     But we want to insert(7) so this null root becomes our 7 that we're inserting 20. The 20 will become
 *     the right child of the 7 because it's larger than the 7. I show this below:
 *     
 *         7
 *          \
 *           20
 *           
 *     Next, we want to insert(5). Once again, we start comparing the new element to the root. In this case,
 *     the 5 we're inserting is smaller than the root(7). As a result, the 5 we're inserting becomes the
 *     left child of the 7. This is shown below:
 *     
 *         7
 *        / \
 *       5   20
 *       
 *     Next, we want to insert(15). Let's see what this looks like. Starting at the root, we see that this
 *     15 is larger than the root(7). So, we move to the 7's right child 20. Here, we compare the 20 and the 
 *     15. 15 is smaller, so the 15 becomes the left child of the 20. This is shown below:
 *     
 *         7
 *        / \
 *       5   20
 *          /
 *         15
 *         
 *     Now, we want to insert(4). This looks like such:
 *     
 *         7
 *        / \
 *       5   20
 *      /    /
 *     4    15
 *     
 *     But what if we want to insert(4) again? In this case, we have already encountered a value that is
 *     already in the tree. If our tree is set up to support duplicate values then we'd add another node, 
 *     but otherwise we do nothing. 
 *     
 *     On average the insertion time will be logarithmic, but in the worst case this could degrade to linear
 *     time. This type of linear behavior is very bad, and is the reason why balanced binary search trees were
 *     invented. 
 *     
 * Removing elements from a BST
 * 
 *     Removing elements from a BST can be seen as a two step process. 
 *     
 *     1) Find the element we wish to remove (if it exists)
 *     2) Replace the node we want to remove with its successor (if any) to maintain the BST invariant
 *     
 *     Recall the BST invariant: left subtree has smaller elements and right subtree has larger elements
 *     
 *         Find phase: When searching our BST for a node with a particular value one of four things will 
 *             happen:
 *         
 *             1) We hit a null node at which point we know the value does not exist within our BST
 *             2) Comparator value equal to 0 (we found it!)
 *             3) Comparator value is less than 0 (the value, if it exists, is in the left subtree)
 *             4) Comparator value greater than 0 (the value, if it exists, is in the right subtree)
 *             
 *         Remove phase:
 *             4 cases:
 *             
 *             1) Node to remove is a leaf node
 *                 If the node we wish to remove is a leaf node then we may do so without side effect
 *                 
 *             2) Node to remove has a right subtree, but no left subtree
 *                 In this case, the successor of the node we are trying to remove will be the root node of
 *                 right subtree
 *                 
 *             3) Node to remove has a left subtree, but no right subtree
 *                 In this case, the successor of the node we are trying to remove will be the root node of
 *                 left subtree
 *                 
 *             4) Node to remove has both left and right subtrees
 *                 Q: In this case, in which subtree will the successor of the node we are trying to remove be?
 *                 A: The answer is both! The successor can either be the largest value in the left subtree
 *                     or the smallest value in the right subtree.
 *                     
 *             Justification for why there could be more than one successor is:
 *                 The largest value in the left subtree satisfies the BST invariant since it:
 *                     1) Is larger than everything in the subtree. This follows immediately from the
 *                     definition of being the largest.
 *                     2) Is smaller than everything in the right subtree because it was found in the left 
 *                     subtree.
 *                     
 *                     but also...
 *                     
 *                 The smallest value in the right subtree satisfies the BST invariant since it:
 *                     1) Is smaller than everything in the right subtree. This follows immediately from the
 *                     definition of being the smallest
 *                     2) Is larger than everything in the left subtree because it was found in the right
 *                     subtree.
 *                     
 *                     As a result, there are two possible successors.
 * 
 * Tree Traversals (Preorder, Inorder, Postorder, Level order)
 * 
 *     These three types of traversals are naturally defined recursively:
 *         Preorder -> preorder prints BEFORE the recursive calls
 *         Inorder -> inorder prints between the recursive calls
 *         Post Order -> post order prints after the recursive calls
 *         
 *         Preorder Traversal
 *             preorder(node):
 *                 if node == null: return
 *                 print(node.value)
 *                 preorder(node.left)
 *                 preorder(node.right)
 *             
 *                                    A
 *                                   / \
 *                                  B   C
 *                                 /\  / \
 *                                D  E F  G  
 *                                
 *                  Therefore, starting at A, we'd go to B, then to D, back up to B, explore E, back to
 *                  B, up to A, down to C, down to F, back up to C, then down to G before going back up
 *                  to A and leaving the function. As you can see, we traverse through the tree following
 *                  the left subtree until we must go to the right.
 *             
 *             Print the value of the current node then traverse the left subtree followed by the right
 *             subtree.
 *          
 *          Inorder Traversal
 *              inorder(node):
 *                  if node == null: return
 *                  inorder(node.left)
 *                  print(node.value)
 *                  inorder(node.right)
 *              
 *                                   11
 *                                  /  \
 *                                 6    15
 *                                / \  /  \
 *                               3  8 13  17
 *                               
 *                   Therefore, starting at 11, we'd go to 6, and then to 3. Notice how we don't print the
 *                   values until we've traversed the entire left subtree. Next, we go back up to 6, then 
 *                   to 8, then to 6, before going to 11 and starting on the right subtree. We then move 
 *                   to the 15, then to the 13, back to the 15, then to the 17 before pushing everything
 *                   off of the call stack, moving back up to the 11, and exiting the function.
 *                   
 *                      With that in mind, we would print 1, 3, 6, 8, 11, 13, 15, and 17 only
 *                      
 *                      NOTICE that with a BST the values printed by the inorder traversal are in
 *                      increasing order! This is why it's called an inorder traversal. HOWEVER, this is
 *                      only guaranteed when using a Binary Search Tree.
 *                   
 *              Traverse the left subtree, then print the value of the node and continue traversing the
 *              right subtree. (In this example, we're using a binary search tree)
 *          
 *          Postorder Traversal
 *              postorder(node):
 *              if node == null: return
 *              postorder(node.left)
 *              postorder(node.right)
 *              print(node.value)
 *              
 *                                   11
 *                                  /  \
 *                                 6    15
 *                                / \  /  \
 *                               3  8 13  17
 *                   
 *                  Therefore, we start at 11, move down to 6, and then 3. We print 3 since it has no
 *                  subtrees, so we count this as exploring both subtrees, and then we move back to 6,
 *                  down to 8, print 8 since it has no subtrees, back to 6, print 6 since we explored 
 *                  both of its subtrees, then to 11 and we move to the right subtree. We don't print 11
 *                  yet because we haven't explored both of it's subtrees. We move to 15, then to 13, print
 *                  13, then to 15, down to 17, print 17, then to 15 again, print it, and back up to 11 
 *                  where we print it. 
 *                  
 *                  We would print 3, 8, 6, 13, 17, 15, 11
 *                  
 *                  
 *              Traverse the left subtree followed by the right subtree then print the value of the node.
 *              
 *         Level Order Traversal
 *             A level order transversal is essentially a breadth first search from the root node which
 *             requires the usage of a queue.
 *             
 *                                  11
 *                                 /  \
 *                                6    15
 *                               / \  /  \
 *                              3  8  13  17
 *                              
 *                   Starting with 11, we print 11, then print 6 and 15, and then we print 3, 8, 13, and 17.
 *                   To obtain this ordering we want to do a Breadth First Search (BFS) from the root node 
 *                   down to the leaf nodes. To do a BFS we will need to maintain a Queue of the nodes
 *                   left to explore. Our queue will begin with only the root node, and finish when the 
 *                   queue is empty. At each iteration we add the left child and then the right child of the
 *                   current node to our queue. 
 *                   
 *                   So, again, we start with the 11 in the queue. Then, we poll() 11 from the queue and 
 *                   add() its children: the 6 and 15. Next, we move to 6 and add() its children to the 
 *                   queue. We also add the 15 since it's another child of the 11. Our queue, at the moment,
 *                   would contain 15, 3, and 8. Now, we poll() 15 from the queue, and add() its children:
 *                   13 and 17. Now, we move to 3 and add() 3's children to the queue, in which case it has
 *                   none, so we can't add them to the queue. In fact we have reached the leaf nodes, so 
 *                   we are done. 
 *                   
 *             In a Level Order traversal, we want to print the nodes as they appear one layer at a time
 *     
 */

// this binary tree is a generic type binary search tree
// notes how this binary search tree takes any type that is comparable
// we need comparable types so we know how to insert them into the BST accordingly
public class BinaryTree <T extends Comparable<T>>
{
	// tracks the number of nodes in this BST
    private int nodeCount = 0;
    
    // this BST is a rooted tree so we maintain a handle on the root node
    private Node root = null;
    
    // internal node containing node references
    // and the actual node data
    private class Node
    {
    	T data; // some comparable type T
    	Node left, right;
    	public Node(Node left, Node right, T elem)
    	{
    		this.data = elem;
    		this.left = left;
    		this.right = right;
    	}
    }
    
    // check if this binary tree is empty
    public boolean isEmpty()
    {
    	return size() == 0;
    }
    
    // get number of nodes in this binary search tree
    public int size()
    {
    	// this will be incremented or decremented as we add or remove elements
    	return nodeCount;
    }
    
    // add an element to this binary tree. returns true if we successfully perform an insertion
    public boolean add(T elem)
    {
    	// check if the value already exists in this BST, if it does ignore adding it
    	if(contains(elem))
    	{
    		return false;
    	}
    	else
    	{
    		root = add(root, elem);
    		nodeCount++;
    		return true;
    	}
    }
    
    // private method to recursively add a value in the binary tree
    private Node add(Node node, T elem)
    {
    	// base case: found a leaf node
    	if(node == null)
    	{
    		node = new Node(null, null, elem);
    	}
    	else
    	{
    		//place lower elements values in left subtree
    		if(elem.compareTo(node.data) < 0)
    		{
    			node.left = add(node.left, elem);
    		}
    		else
    		{
    			node.right = add(node.right, elem);
    		}
    	}
    	return node;
    }
    
    // remove a value from this binary tree, if it exists
    public boolean remove(T elem)
    {
    	// make sure the node we want to remove actually exists before we remove it
    	if(contains(elem))
    	{
    		root = remove(root, elem);
    		nodeCount--;
    		return true;
    	}
    	return false;
    }
    
    // recursive method to remove node
    private Node remove(Node node, T elem)
    {
    	if(node == null)
    	{
    		return null;
    	}
    	
    	int cmp = elem.compareTo(node.data);
    	
    	// dig into left subtree, the value we're looking for is smaller than the current value
    	if(cmp < 0)
    	{
    		node.left = remove(node.left, elem);
    	}
    	// dig into right subtree, the value we're looking for is greater than the current value
    	else if(cmp > 0)
    	{
    		node.right = remove(node.right, elem);
    	}
    	// found the node we wish to remove
    	else 
    	{
    		// this is the case with only a right subtree or no subtree at all. in this situation just
    		// swap the node we wish to remove with its original child.
    		if(node.left == null)
    		{
    			Node rightChild = node.right;
    			
    			node.data = null;
    			node = null;
    			
    			return rightChild;
    			
    			// this is the case with only a left subtree or no subtree at all. in this situation we
    			// just swap the node we wish to remove with its left child
    		}
    		else if(node.right == null)
    		{
    			Node leftChild = node.left;
    			node.data = null;
    			node = null;
    			
    			return leftChild;
    			
    			// when removing a node from a binary search tree with two links the successor of the node
    			// being removed can either be the largest value in the left subtree or the smallest value
    			// in the right subtree. in this implementation we have decided to find the smallest value
    			// in the right subtree which can be found by traversing as far left as possible in the 
    			// right subtree.
    		}
    		else
    		{
    			// find leftmost node in the right subtree
    			Node tmp = digLeft(node.right);
    			
    			// swap the data
    			node.data = tmp.data;
    			
    			// go into the right subtree and remove the leftmost node we found and swapped data with.
    			// this prevents us from having two nodes in our tree with the same value
    			node.right = remove(node.right, tmp.data);
    			
    			// if instead we wanted to find the largest node in the left subtree as opposed to the
    			// smallest node in the right subtree here is what we could do:
    			// Node tmp = digRight(node.left);
    			// node.data = tmp.data;
    			// node.left = remove(node.left, tmp.data);
    		}
    	}
    	return node;
    }
    
    // helper method to find the leftmost node
    private Node digLeft(Node node)
    {
    	Node cur = node;
    	while(cur.left != null)
    	{
    		cur = cur.left;
    	}
    	return cur;
    }
    
    // helper method to find the rightmost node
    private Node digRight(Node node)
    {
    	Node cur = node;
    	while(cur.right != null)
    	{
    		cur = cur.right;
    	}
    	return cur;
    }
    
    // returns true if the element exists in the tree
    public bool contains(T elem)
    {
    	return contains(root, elem);
    }
    
    // private recursive method to find an element in the tree
    private boolean contains(Node node, T elem)
    {
    	// base case: reached bottom, value not found
    	if(node == null)
    	{
    		return false;
    	}
    	
    	int cmp = elem.compareTo(node.data);
    	
    	// dig into the left subtree because the value we're looking for is smaller than the current value
    	if(cmp < 0)
    	{
    		return contains(node.left, elem);
    	}
    	// dig into the right subtree because the value we're looking for is greater than the current value
    	else if(cmp > 0)
    	{
    		return contains(node.right, elem);
    	}
    	// we found the value we were looking for
    	else 
    	{
    		return true;
    	}
    }
    
    // computes the height of the tree, O(n)
    public int height()
    {
    	return height(root);
    }
    
    // recursive helper method to compute the height of the tree
    private int height(Node node)
    {
    	// if we reach a leaf node, return 0
    	if(node == null)
    	{
    		return 0;
    	}
    	
    	// otherwise return the maximum height of the left or right subtree. we do either left or right 
    	// because either the left or the right subtree could be taller than the other.
    	return Math.max(height(node.left), height(node.right)) + 1;
    }
    
    // this method returns an iterator for a given TreeTraversalOrder.
    // you can traverse the tree in 4 different ways: preorder, inorder, postorder, and levelorder
    public java.util.Iterator <T> traverse(TreeTraversalOrder order)
    {
    	switch(order)
    	{
    	case PRE_ORDER:
    		return preOrderTraversal();
    	case IN_ORDER: 
    		return inOrderTraversal();
    	case POST_ORDER:
    		return postOrderTraversal();
    	case LEVEL_ORDER:
    		return levelOrderTraversal();
    		default: 
    			return null;
    	}
    }
    
    // return as iterator to traverse the tree in preorder
    private java.util.Iterator <T> preOrderTraversal() 
    {
    	// code
    	return null;
    }
    
    // return as iterator to traverse the tree in order
    private java.util.Iterator <T> inOrderTraversal() 
    {
    	// code
    	return null;
    }
    
    // return as iterator to traverse the tree in post order
    private java.util.Iterator <T> postOrderTraversal() 
    {
    	// code
    	return null;
    }
    
    // return as iterator to traverse the tree in level order
    private java.util.Iterator <T> levelOrderTraversal() 
    {
    	// code
    	return null;
    }
    
    private enum TreeTraversalOrder
    {
    	PRE_ORDER,
    	IN_ORDER,
    	POST_ORDER,
    	LEVEL_ORDER
    }
}




















