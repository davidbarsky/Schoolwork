def counter(node, count)
  if node = nil
    return
  end
  counter(node.leftmostchild, count++)
  counter(node.nextrightchild, count++)
end
