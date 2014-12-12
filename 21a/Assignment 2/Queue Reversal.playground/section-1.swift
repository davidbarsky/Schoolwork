// Playground - noun: a place where people can play

import UIKit

struct Queue<T> {
    var InternalArray = [Int]()
    
    mutating func enQueue(item: Int) {
        InternalArray.append(item)
    }
    
    mutating func deQueue(position: Int) {
        InternalArray.removeAtIndex(position)
    }
    
    func isEmpty() -> Bool {
        return InternalArray.isEmpty
    }
}
