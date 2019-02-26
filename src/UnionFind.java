/*
 * Union Find - also sometimes called a Disjoint Set
 * 
 * What is Union Find?
 * 
 *     Union Find is a data structure that keeps track of elements which are split into one or more disjoint sets. It
 *     has two primary operations: find and union. 
 *     
 *     Find - given an element the UnionFind will tell you what group that element belongs to. 
 *     Union - merges two groups together 
 *     
 * When and Where is Union Find used?
 * 
 *     Kruskal's Minimum Spanning Tree Algorithm
 *     
 *     Grid Percolation - where there are a bunch of dots on a grid and we are trying to see if there is a path from 
 *     the bottom of the grid to the top of the grid. Union Find solves this problem efficiently by merging together
 *     paths.
 *     
 *     Network Connectivity
 *     
 *     Least Common Ancestor in Trees
 *     
 *     Image Processing
 * 
 * Union Find Time Complexity Analysis
 * 
 *     Construction: O(n) linear time.
 *     Union: a(n) amortized constant time.
 *     Find: a(n) amortized constant time.
 *     Get Component Size: a(n) amortized constant time.
 *     Check if Connected: a(n) amortized constant time.
 *     Count Components: O(1) constant time.
 *     
 *     Amortized constant time - almost constant time, but not quite constant time. 
 *     
 * Kruskal's Minimum Spanning Tree Algorithm and Union Find
 * 
 *     Given a graph G = (V,E) we want to find a Minimum Spanning Tree in the graph(it may not be unique). A Minimum
 *     Spanning Tree is a subset of the edges which connect all vertices in the graph with the minimal total edge cost.
 *     
 *     So if we're given a graph with some vertices and some edges, the minimum spanning tree is a subset of the edges 
 *     which connects to all of the vertices and does so at a minimal cost. 
 *     
 *     I will not explain Minimum Spanning Trees here because they would be difficult to draw so it may be a good idea
 *     to stop here and learn those before continuing. 
 *     
 *     Note: a Minimum Spanning Tree is not necessarily unique, so if there is another Minimum Spanning Tree it may 
 *     also have the same weight as the first tree. 
 *     
 *     So, how does it work? We can break it up into 3 steps:
 *     1. Sort edges by ascending edge weight.
 *     2. Walk through the sorted edges and look at the two nodes the edge belongs to, if the nodes are already unified
 *     we don't include this edge(doing so would create a cycle which we don't want), otherwise we include it and 
 *     unify the nodes.
 *     3. The algorithm terminates when every edge has been processed or all the vertices have been unified. 
 *     
 *     The Union operation is used to merge different groups in a Minimum Spanning Tree and the Find operation is used
 *     to find what group different nodes in the tree belong to. These are very important to ensure that we don't
 *     create a cycle.
 *     
 *     The underlying data structure that allows us to find a Minimum Spanning Tree in this way is Union Find.
 *     
 * Union Find and Operations
 * 
 *     Now we're going to talk about the Union and Find operations we can do on the Union Find, or the disjoint set. 
 *     To begin using Union Find, first construct a bijection(a mapping) between your objects and the integers in the 
 *     range [0, n).
 *     
 *     Note: this step is not necessary in general, but it will allow us to construct an array-based Union Find which 
 *     is very efficient and very easy to work with. I will show what this means below:
 *     
 *     D    B          F
 *       A     E    C
 *       
 *     0 1 2 3 4 5
 *     
 *     So if we have some random objects, the letters above, and we want to assign a mapping to them, then we can do so
 *     arbitrarily as long as each element maps to exactly one number. Our random bijection is shown below:
 *     
 *     0 1 2 3 4 5
 *     ^ ^ ^ ^ ^ ^
 *     D A B E C F
 *     
 *     This is our random bijection. We want to store these mappings, perhaps, in a hash table so we can perform a 
 *     lookup on them later and determine what everything is mapped to. Next, we are going to construct and array. Each
 *     index is going to have an associated object - this is possible through our bijection(mapping). For example, 
 *     in our bijection D was mapped to 0, A was mapped to 1, and so on so forth. This array is shown below:
 *     
 *     indexes  0 1 2 3 4 5
 *     elements D A B E C F
 *     
 *     Now we begin our Union example, note: this example will not use path compression, see the following:
 *     
 *     elements D A B E C F
 *     value    0 1 2 3 4 5 (or root nodes)
 *     indexes  0 1 2 3 4 5
 *     
 *     Notice our array. The value of each element in the array is its index because originally each node is its own
 *     root node. Picture a bunch of nodes that are unconnected, each node would be its own tree, and therefore its
 *     own root. As we Union nodes you will notice that we are going to change the values in our array to map to other
 *     letters. Specifically, the way we are going to do this is: for some index i, index i's parent is going to be 
 *     whatever index is at position i. For instance, if we want to unify D and F, so Union(D, F), we look at D and F,
 *     and we discover that D has a root node of 0, and F has a root node of 5. So either D is going to become F's
 *     parent or F is going to become D's parent. In this case we will choose D for the parent. We will now switch 
 *     the value of F to be the same value of D, or the same root node. So, F's value now becomes 0. This is shown 
 *     below. 
 *     
 *     elements D A B E C F
 *     value    0 1 2 3 4 0 (or root nodes)
 *     indexes  0 1 2 3 4 5
 *     
 *     Since D is now F's parent you can visualize what we are doing here by looking at the visual below:
 *     
 *     D
 *     ^
 *     F
 *     
 *     D becomes the parent of F, and F becomes the child node of D. If we want to Union A and C now, so Union(A, C),
 *     we will once again switch the values to match. In this example I am going to choose the smallest value to be 
 *     the parent every time. So, our A becomes the parent of C. We switch C's value to match A, so C's value becomes
 *     1. This is shown below:
 *     
 *     elements D A B E C F
 *     value    0 1 2 3 1 0 (or root nodes)
 *     indexes  0 1 2 3 4 5
 *     
 *     And our visual is shown below:
 *     
 *     D A
 *     ^ ^
 *     F C
 *     
 *     Now we want to Union B and E, so Union(B, E). Once again, I will choose the smallest index to be the parent, so
 *     B becomes E's parent. E's new value becomes 2. This is shown below:
 *     
 *     elements D A B E C F
 *     value    0 1 2 2 1 0 (or root nodes)
 *     indexes  0 1 2 3 4 5
 *     
 *     And our visual is shown here:
 *     
 *     D A B
 *     ^ ^ ^
 *     F C E
 *     
 *     Let's say we have another node in the mix that we want to Union. We have G, and we want to Union with E. So this
 *     is Union(G, E). Notice that E's value is 2, but we know that B is also 2 since B is the root node of E. When
 *     we merge groups we always merge the smaller groups into larger groups. So, our G merges into our B & E group.
 *     The G becomes the child of B, because B is the parent node, instead of E. This is shown below:
 *     
 *     elements D A B E C F G
 *     value    0 1 2 2 1 0 2 (or root nodes)
 *     indexes  0 1 2 3 4 5 6
 *     
 *     And our visual is shown below:
 *     
 *     D A   B
 *     ^ ^  / \
 *     F C E   G
 *     
 *     Let's say we want to merge two groups instead of just individual nodes, how do we do this? This is very similar
 *     to how we've merged individual nodes. We want to union C and B, so Union(C, B). C's root node is A with value
 *     1, and B is its own root. B's tree has 3 nodes and A's tree has only 2 nodes, therefore, we are going to be 
 *     merging A's tree into B's tree. Once again, the root of C's tree will merge with the root of B's tree, so A
 *     merges with B and the entire tree now has a value of 2. This is shown below:
 *     
 *     elements D A B E C F G
 *     value    0 2 2 2 2 0 2 (or root nodes)
 *     indexes  0 1 2 3 4 5 6
 *     
 *     And our visual is shown below:
 *     
 *     D    B
 *     ^   /|\
 *     F  E A G
 *          |
 *          C
 *     (This example does not use path compression)
 *     
 *     We also could merge the two remaining trees, but I am not going to cover that because you would simply need to
 *     merge D's tree into B's tree and you're done. 
 * 
 * Summary
 * 
 *     Find Operation- To find which component a particular element belongs to find the root of that component by
 *     following the parent nodes until a self loop is reached(a node who's parent is itself), basically until we find
 *     the root of that component.
 *     
 *     Union Operation- To unify two elements find which are the root nodes of each component and if the root nodes
 *     are different make one of the root nodes be the parent of the other. 
 */

public class UnionFind 
{
	
}








