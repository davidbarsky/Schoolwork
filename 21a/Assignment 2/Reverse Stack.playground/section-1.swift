// Playground - noun: a place where people can play

import UIKit

struct Stack<Int> {
    var InternalArray = [Int]()
    
    mutating func push(item: Int) {
        InternalArray.append(item)
    }
    
    mutating func pop() -> Int {
        return InternalArray.removeLast()
    }
    
    func isEmpty() -> Bool {
        return InternalArray.isEmpty
    }
    
    func peek() -> Int {
        return InternalArray.last!;
    }
}

var myStack = Stack<Int>()

// populates stack
myStack.push(1)
myStack.push(2)
myStack.push(3)
myStack.push(4)
myStack.push(5)

// reserves stack
func reverseStack() -> Stack<Int> {
    var reversedStack = Stack<Int>()
    while(myStack.isEmpty() == false) {
        reversedStack.push(myStack.pop())
    }
    return reversedStack
}

// displays results
var reversedStack = reverseStack()
