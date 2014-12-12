1. Reverse a stack in `O(n)` time.

Pseudocode:

  	func reverseStack() -> Stack<Int> {
  		var reversedStack = Stack<Int>()
  		while(myStack.isEmpty() == false) {
  			reversedStack.push(myStack.pop())
  		}
  		return reversedStack
  	}

2. Reverse a queue as implemented using a circular array.

3. Find a maximum value in a list of N integers.

Pseudocode:

    func largestInt(array: Array<Int>) -> Int {
        var largestNumber: Int
    
        for number in array {
            if (number > largestNumber) {
                largestNumber = number
            }
        }
    
        return largestNumber
    }

Analysis: The algorithm runs in O(n) time. The number of iterations of the `for` loop increases linearly with the size of the list.

4.  Remove Every Other Element from a Given List

Pseudocode:

    func oddOneOut(firstArray: Array<Int>, secondArray: Array<Int>) -> Array<Int> {
        var tracker = 0
        for number in firstArray {
            if (number % 2 == 1) {
                secondArray.append(number)
                firstArray.removeAtIndex(tracker)
            }
            tracker++
        }
        return secondArray
    }
    
Analysis: The algorithm operates in O(N) time. The `for` loop iterates through the entire original list, only removing every other item after it has entered the loop. The `if` operation inside the loop run in constant O(1) time.