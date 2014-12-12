def exchange(x, y, array, i, j)
  puts "Exchanging: #{i}, #{j}"
  array[x], array[y] = array[y], array[x]
end

def parition(i, j, array)
  puts "Complex Parition: #{i}, #{j}"
  x, y = [i + 1, j]
  while x <= y
    while x <= y && (array[x] < array[i])
      x = x + 1
    end

    while  x <= y && array[y] >= array[i]
      y = y - 1
    end

    if x < y
      exchange(x, y, array, i, j)
      x = x + 1
      y = y - 1
    end
  end

  if i < y
    exchange(i, y, array, i, j)
  end
  return y - 1, y + 1
end

def simple_partition(i, j, array)
  puts "Simple partition using #{i}, #{j}"
  x, y = [i + 1, j]
  while x <= y
    if array[x] <= array[i]
      x = x + 1
    elsif array[y] > array[i]
      y = y - 1
    else
      exchange(x, y, array, i, j)
    end
  end
  if i < y 
    exchange(i, y, array, i, j)
  end
  return y - 1, y + 1
end

def quick_sort(i, j, array, p)
  if (i < j)
    puts "Sorting: #{i}, #{j}, #{array}"
    if p == 'y'
      indices = simple_partition(i, j, array)
    else
      indices = parition(i, j, array)
    end

    quick_sort(i, indices[0], array, p)
    quick_sort(indices[1], j, array, p)
  end
end

def 
  @operations = @operations + 1
  puts @operations
end

@operations = 0

puts "Do you want to use a simplified partition? (y/n)"
p = gets.chomp

puts "Enter numbers separated by spaces."
input = gets.chomp
array = input.split()

quick_sort(0, array.length - 1, array, p)
puts "Done! #{array}"