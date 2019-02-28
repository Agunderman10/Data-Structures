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
 *    
 */

public class BinaryTree 
{

}
