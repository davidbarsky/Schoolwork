def merge_sort(array_A)
  if (array_A.size <= 1)
    array_A
  else
    midpoint = (array_A.size / 2).floor
    left = merge_sort(array_A[0..midpoint - 1])
    right = merge_sort(array_A[midpoint..array_A.size])
    merge(left, right)
  end
end

def merge(left, right)
  if left.empty?
    right
  elsif right.empty?
    left
  elsif left.first < right.first
    [@left.first] + merge(@left[1..@left.length], @right)
  else
    [@right.first] + merge(@left, @right[1..@right.length])
  end
end


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
