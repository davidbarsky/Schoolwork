 class Heap
  def initialize
    @heap = []
  end
  
  def add(x)
    @heap << x
    sift_up(@heap.length - 1)
    self
  end
  
  def peak
    @heap[0]
  end
  
  def remove_minmum()
    raise RuntimeError, "Empty Queue" if @heap.length == 0
    if @heap.length == 1
      @heap = []
    else
      @heap[0] = @heap.pop
      sift_down(0)
    end
    self
  end
  
  def empty?
    if @heap.length == 0
      true
    else
      false
    end
  end
  
  def to_s
    @heap.to_s
  end
  
  def length
    @heap.length
  end
  
  private
  
  def sift_up(i)
    parent = (i - 1) / 2
    if parent >= 0 and @heap[parent] > @heap[i]
      @heap[parent], @heap[i] = @heap[i], @heap[parent]
      sift_up(parent)
    end
  end

  def sift_down(i)
    child = (i * 2) + 1
    return if child >= @heap.length
    child += 1 if child + 1 < @heap.length and @heap[child] > @heap[child+1]
    if @heap[i] > @heap[child]
      @heap[child], @heap[i] = @heap[i], @heap[child]
      sift_down(child)
    end
  end
end

items = [17, 3, 4, 7, 2, 9, 11, 5, 19, 14, 20, 18] 

heap_instance = Heap.new

items.each do |number
  puts "Adding number: #{number}"
  heap_instance.add(number)
  puts heap_instance
end

while not heap_instance.empty?
  heap_instance.remove_minmum
  puts heap_instance
end

