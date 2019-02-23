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
 */

public class UnionFind 
{
	
}
