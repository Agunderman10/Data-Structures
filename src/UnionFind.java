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
 */

public class UnionFind 
{
	
}








