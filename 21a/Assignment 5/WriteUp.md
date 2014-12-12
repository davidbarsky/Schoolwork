## 1. Pre-Order Traversal of an Unordered Tree using a Stack

```ruby
def preOrderTraversal(tree)
  stack = new Stack
  while (stack.hasItems? or node != nil) 
    if (node != nil)
      visit node
      if (node.nextRightChild != nil)
        stack.push(node.nextRightChild)
      end  
      node = node.leftChild
    else
      node = stack.pop
    end
  end
end
```

## 2. In-Order Traversal of a Binary Search Tree using a Stack

```ruby
def inOrderTraversal(node)
  stack = new Stack
  while (stack.hasItems? or node != nil)
    if (node != nil)
      stack.push(node)
      node = node.left # for the next iteration of the while loop
    else
      node = stack.pop()
      visit(node)
      node = node.rightChild # for the next iteration of the while loop
    end
  end
end
```

## 3. Proof of Tree Height 

Base Case: For a tree of height 0, the algorithm would return a maximum of 0. The algorithm corrects that, arriving at a tree height of 1.

Inductive case: Let's assume for any tree of height *n* - 1, the algorithm works. For a tree of height *n*, it is composed of two trees of height *n* - 1. The maximum that will be returned from the `else` block will always be n. For a tree of *n* height, the function return n -1, add 1, and find the height equal to n.

Conclusion: Because the algorithm works for the base case, the algorithm works for all tree heights.

## 4. Recursively Counting Tree Children

```ruby
def counter(node, count)
  if node = nil
    return
  end
  counter(node.leftmostchild, count++)
  counter(node.nextrightchild, count++)
end
```

Time: the algorithm runs O(n) time, as the algorithm has to visit every node of every node of the tree. It is therefore dependent on the size of tree.

Space: the algorithm runs in 2^n space, as each method call spawns two more. Space for each call 