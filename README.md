# Graph Algos

This Java library contains abstract data types, implementations and algorithms
that deal with graph-based data. More formally, the main data type is a multigraph.
The library is fully-documented; It is built using `Gradle` and is tested using
`JUnit 5`. Note that the user is able to configure the basic ADT implementations
and the basic algorithms that are used by the different packages of the library
using the `shared` package.

## Abstract Data Types and Implementations

1.  Graph - a data type that describes a multigraph. The directed-graph and
undirected-graph are two ADTs that represent directed or undirected multigraphs.
The building blocks of each graph are the `Vertex` and `Edge` classes -
that represent vertices and edges in the graph. The implementations of directed
and undirected graphs represent multigraphs as collections of adjacency lists.

2. Disjoint-Set - a data type that maintains equivalence classes. It is
implemented by the disjoint-set forest data structure that represents each
equivalence class as a rooted tree (so the whole structure is represented by a
forest). "Path compression" and "union by rank" principles are utilized in order
to receive good amortized bounds.

3. Priority Queue - a data type that stores key-value entries, capable of
decreasing values and returning the key that belongs to the minimal value.
It is implemented by the Hollow Heap data structure that maintains a DAG.

## Algorithms

1. `Bipartite` class

    1. `isBipartite` - This method checks whether a given undirected graph
    is bipartite. If it is bipartite, it is colored with 0 and 1

2. `Connectivity` class

    1. `are` - This method gets a graph and two vertices `u`,`v` and checks whether
    `u` is reachable from `v`

    2. `find` - This method gets a graph and a vertex `v`, and returns all the
    reachable vertices `v`

    3. `connected` - This method checks whether a given undirected graph is connected

    4. `connectedComponents` - This method returns the connected component of a given
    undirected graph

3. `Cycles` class

    1. `isAcyclic` - This method checks whether a given directed graph is a acyclic

    2. `containsZeroCycle` - This method gets a directed graph with weighted edges
    and checks whether it contains a zero-weight cycle, assuming it does not
    contain any negative-weight cycles.

    3. `containsNegativeCycle` - This method gets a directed graph with weighted
    edges and checks whether it contains a negative-weight cycle.

4. `TopologicalSort` class

    1. `sort` - This method tries to topologically sort a given directed graph.

5. `MST` class

    1. `Kruskal` - This method computes a minimum-spanning tree of a given undirected
    graph using the Kruskal algorithm

    2. `Prim` - This method computes a minimum-spanning tree of a given undirected
    graph using the Prim algorithm

6. `SSSP` class

    1. `BellmanFord` - This method gets a directed graph with weighted edges and a
    source vertex, and computes the shortest paths (i.e. paths with minimal
    weights) from the source to each other vertex in the graph using the Bellman-Ford
    algorithm. If a negative-weight cycle is detected, and empty Optional is returned.

    2. `DAG` - This method gets a DAG with weighted edges and a source vertex,and
    computes the shortest paths (i.e. paths with minimal weights) from the source
    to each other vertex in the graph using an adapted version of Bellman-Ford
    algorithm, which is optimal.

    3. `Dijkstra` - This method gets a directed graph with weighted edges and a source
    vertex, and computes the shortest paths (i.e. paths with minimal weights) from
    the source to each other vertex in the graph using the Dijkstra algorithm,
    assuming all the edges that are placed in a path from the source to
    some other vertex have nonnegative weights.

    4. `unitWeights` - This method gets a graph and a source vertex, and computes
    that shortest paths (i.e. paths with fewest edges) from the source to each other
    vertex in the graph using an optimal BFS-based algorithm.

    5. `shortestPathsGraph` - This method computes the shortest paths graph of a
    given graph by filtering out edges.

7. `SPSP` class - The methods defined in this class solve the single-pair
shortest-path problem using similar algorithms defined in the `SSSP` class.


## Version
1.0.0
