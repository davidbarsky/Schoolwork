# assuming current RB leaf is known, and information about it is being passed in initially. in addition, it's assumed that the root isn't being passed in.
# @NEW_RB_LEAF is the new pointer, set in screaming snake case.
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
