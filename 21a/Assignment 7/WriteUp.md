## Question 1: Binary Heap ##

### Adding integers ###

    Adding number: 17
    [17]
    Adding number: 3
    [3, 17]
    Adding number: 4
    [3, 17, 4]
    Adding number: 7
    [3, 7, 4, 17]
    Adding number: 2
    [2, 3, 4, 17, 7]
    Adding number: 9
    [2, 3, 4, 17, 7, 9]
    Adding number: 11
    [2, 3, 4, 17, 7, 9, 11]
    Adding number: 5
    [2, 3, 4, 5, 7, 9, 11, 17]
    Adding number: 19
    [2, 3, 4, 5, 7, 9, 11, 17, 19]
    Adding number: 14
    [2, 3, 4, 5, 7, 9, 11, 17, 19, 14]
    Adding number: 20
    [2, 3, 4, 5, 7, 9, 11, 17, 19, 14, 20]
    Adding number: 18

    
### Removing Smallest Integer ###

    [2, 3, 4, 5, 7, 9, 11, 17, 19, 14, 20, 18]
    [3, 5, 4, 17, 7, 9, 11, 18, 19, 14, 20]
    [4, 5, 9, 17, 7, 20, 11, 18, 19, 14]
    [5, 7, 9, 17, 14, 20, 11, 18, 19]
    [7, 14, 9, 17, 19, 20, 11, 18]
    [9, 14, 11, 17, 19, 20, 18]
    [11, 14, 18, 17, 19, 20]
    [14, 17, 18, 20, 19]
    [17, 19, 18, 20]
    [18, 19, 20]
    [19, 20]
    [20]
    []


## Question 2: Finding Leaves in Heap Structure ##

The algorithm assumes that the previous RB leaf is known, and is passed in.

```ruby
def new_RB_leaf(node)
  new_node = node.parent
  if new_node.hasChild?(node)
    if new_node.right_child != nil
      new_RB_leaf(new_node.right_child)
    else
      new_RB_leaf(new_node.left_child)
    end
  else
    @NEW_RB_LEAF = new_node
  end
end

# helpers, for syntactic sugar

def hasParent?(node)
  if node.parent != nil
    true
  else
    false
  end
end

def isLeaf?(node)
  if node.left_child != nil || node.right_child != nil
    true
  else
    false
  end
end
```

The algorithm checks if there's a child present, and if so, travels down the tree until there is no child, and sets that last leaf to the new RB leaf. Otherwise, it goes up a level, and tries going down again, ensuring that is stays as far right as possible.

## Question 3: MergeSort ##

```ruby
# provides for a more intuitive accessing of array_B
@left = array_B[0..midpoint - 1]
@right = array_B[midpoint..array_A.size]

def merge_sort(array_A)
  if (array_A.size <= 1)
    array_A
  else
    midpoint = (array_A.size / 2).floor
    @left = merge_sort(array_A[0..midpoint - 1])
    @right = merge_sort(array_A[midpoint..array_A.size])
    merge(@left, @right)
  end
end

def merge(left, right)
  if left.empty?
    right
  elsif right.empty?
    left
  elsif @left.first < @right.first
    [@left.first] + merge(@left[1..@left.length], @right)
  else
    [@right.first] + merge(@left, @right[1..@right.length])
  end
end
```

Addition space usage (beyond `array_A` and `array_B`) is only *O*(log(*n*)) because each iteration cuts the data set in half. 

## Question 4: Simple vs. Complex QuickSort Partition ##

1. The same logic overall applies in the simple partition the complex partition, differing only on the actual application of the logic. Specifically, conditional statements rather than loops.
2. The final operating time of partitioning doesn’t differ between the simple and the complex partition because both have nested two loops. However, when looking at the loops in detail, the simple partition has less operations overall.