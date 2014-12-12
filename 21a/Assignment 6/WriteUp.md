## 1. Proof by Induction on Complete Ternary Tree Height ##

Basis:
  If h = 0, then the tree has a single vertex, and there are 1 = (3^(0 + 1) - 1)/2 vertices.

Inductive: For any height h > 0, assume the formula is true for smaller heights. A tree of height h is formed from a root and three subtrees of height h - 1. By induction, those three subtrees have heights of (3^((h - 1) + 1) - 1) / 2 = (3^h - 1)/2 vertices.
  
Conclusion: Therefore, the entire tree has (3(3^h - 1) + 1)/2 = (3^(k+1) - 1)/2 vertices.

## 2. Find Last List Member Recursively
    
    numberOfNodes = 0
    numberOfEncounters = 0

    func linkedListCounter(node, numberOfEncounters, numberOfNodes, data) -> numberOfNodes {
      if (node.next = nil) {
        return --numberOfNodes
      } else {
        if (date = node.value) {
          linkedListCounter(node.next, numberOfEncounters++, numberOfNodes, data)
        } else {
          linkedListCounter(node.next, numberOfEncounters, numberOfNodes, data)
        }
      }
    }
    
    func finder(node, data, numberOfEncounters, numberOfNodes) -> node {
      if (node.value = date) {
        numberOfEncounters++
        
        if (numberOfEncounters = numberOfNodes) {
          return node
        } else {
          finder(node, data, numberOfEncounters, numberOfNodes)
        }
      } else {
        finder(node, data, numberOfEncounters, numberOfNodes)
      }
    }
    
The method `linkedListCounter` counts how many instances there are of a the target node. `numberOfEncounters` is used by the `finder` method to know when to return a given node, rather than the first one that it just runs into. The base case of `linkedListCounter` just returns the final `numberOfEncounters`. There are, however, two recursive cases. The first increments the `numberOfEncounters` variable if a goal value is encountered, while the second one doesn't.

The method `finder` goes through the list a second time, only returning the target value after it encountered the node value of interest. It implements this by using `numberOfEncounters`, incrementing it until it reaches `numberOfNodes`, and when it reaches `numberOfNodes`, it returns that given node.

## 3. Find Diameter of a Tree ##

    func diameter(node) {
      i = 1
      m = 0
      w = leftMostChild()

      while (w != null) {
        i = i + 1
        m = maximumOf(m, diameter(node))
        w = nextRightChildOf(node) 
      }
      return maximumOf(i, m)
    }

The algorithm runs in linear time, as the algorithm has to visit each node in the tree. In addition, it runs in O(1) space in addition to O(n) space needed to store the tree, and the O(n) space used by the compiler to to maintain a stack of recursive calls.

## 4. Closed Hashing, Member, and Insert Operations ##

    // assuming the hash function is already defined
    func Member(data) {
      
      isInserted = false
      i = hash(data)
      
      while (isInserted = false) {
        if (Member(data) = false) {
          if (i = A.length) {
            i = A[0]
          } else {
            i++
          }
        } else {
          isInserted = true
        }
      }
    }
    
    func Member(data) -> boolean {
      if (A[hash(d)] != nil) {
        return false
      } else {
        return true
      }
    }
