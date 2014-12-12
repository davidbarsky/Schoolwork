## 1. Greatest Number in a List (recursively)
    
    func RMV(greatestSoFar, List) -> greatestNumber {
      greatestSoFar = 0
      RMVTail(greatestSoFar, list, list.first)
    }
    
    func RMVTail(greatestSoFar, list, nextItem) -> greatestNumber {
      if (nextItem > greatestSoFar) {
        greatestSoFar = nextItem
      }

      nextItem = list.next
      if (nextItem = nil) {
        return greatestSoFar
      } else {
        RMVTail(greatestSoFar, list, nextItem)
      }
    }

The algorithm runs in O(N) time, as the operating time complexity depends on the initial list size.
    
## 2. Recursive Ternary Search

    func ternarySearch(array:[Int], goal:Int, leftMax:Int, rightMax:Int) -> Int {
      if (absoluteValueOf(leftMax - rightMax) < goal) {
        return (rightMax + leftLeft)/2
      }
  
      rightThird = (leftMax + (rightMax * 2))/3
      leftThird = ((2 * leftMax) + rightMax)/3
  
      if (leftThird < rightThird) {
        return ternarySearch(list, goal, leftThird, right)
      } else {
        return ternarySearch(list, goal, left, rightThird)
      }
    }
    
The algorithm runs in O(log3(N)) time, as the algorithm consistently cuts the data size by two-thirds. 

## 3. Polynomial Multiplication
  
  mult(n, A, B) -> array {
     C.add = (A[A.size - 1]x^N-1 * B[B.size - 1]x^N-1) + (A[A.size - 2]x^N-2 * B[B.size - 2]x^N-2)
     
     A[N - 1], B[N - 1], A[N - 2], B[N - 2] = nil
     
     if A = nil 
       return C
     else 
       multwithArray(n, A, B, C)
  }
  
  multwithArray(n, A, B, C) {
     C.add = (A[A.size - 1]x^N-1 * B[B.size - 1]x^N-1) + (A[A.size - 2]x^N-2 * B[B.size - 2]x^N-2)

     A[N - 1], B[N - 1], A[N - 2], B[N - 2] = nil
     
     if A = nil 
       return C
     else 
       multwithArray(n, A, B, C)
  }
      
  
After polynomial multiplication (and adding to array C), the algorithm removes the items in the original array. If one array is empty, it returns the C array. If not, it calls a separate method at accepts a modified array C.
  
## 4. Mystery Function

    func A(i: Int, n: Int) -> Int {
        if (i == 0) {
            return n + 1
        } else if (n == 0) {
            return A(i - 1, 1)
        } else {
            return A(i - 1, A(i, n - 1))
        }
    }

    println(A(0, 0))
    println(A(1, 1))
    println(A(2, 2))
    println(A(3, 3))
    println(A(4, 4))

The calls, in order, produced `1`, `3`, `7`, `61`, and the spinning beach ball of death. The call `A(4, 4)` did not produce an answer, as it crashed GCC at 140k recursive calls. This occurs because the sheer amount of recursive calls exceeds the system's physical memory.