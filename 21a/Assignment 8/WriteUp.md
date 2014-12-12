## 1. Find a Cycle in a Graph ##

```ruby

create empty list

def findCycle(vertex, startingVertex, graph)
  if vertex is not marked
    visit vertex
    mark vertex
    add vertex to list
    if vertex = startingVertex 
      return
    else
      for each edge of each vertex
        findCycle(vertex, startingVertex, graph)
      end
    end
  end
end

```

The algorithm operates recursively until it finds the starting vertex, which at that point it returns, leaving a list that contains the entire cycle.

## 2. Prove Bipartite Graphs ##

> A graph G is bipartite if its vertices can be partitioned into two sets EVEN(G) and ODD(G) so that every edge has one of its end points in each set; that is the endpoints of each edge have opposite parity (one is even and the other is odd).

> A. Prove that if an undirected connected graph G is bipartite, it has no odd length cycles. B. Prove that if an undirected connected graph G has no odd-length cycles, it is bipartite. Hint: Perform a breadth-first search to partition the vertices into even and odd depth.

A. For a graph to bipartite, its total number of nodes must be even.
B. 

## 3. What happens in different Graphs ##

Consider the following four types of graphs:

- directed graphs
- undirected graphs
- bi-connected graphs
- trees (where edges are directed from a vertex to its children)

Assuming that a depth-first search may start at any vertex, for each of these types of graphs, which of the following can occur in a depth-first search forest; justify your answers:

- back edges
- forward edges
- cross edges
- more than one child of the vertex used to start the depth-first search • more than one tree in the forest


## 4. Topological Sort on Matrices ##


