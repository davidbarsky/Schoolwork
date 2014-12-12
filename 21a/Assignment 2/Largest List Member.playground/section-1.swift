// Playground - noun: a place where people can play

import UIKit

var myArray: [Int] = [1, 2, 3, 4, 5, 6]

func largestInt(array: Array<Int>) -> Int {
    var largestNumber: Int = 1
    
    for number in array {
        if (number > largestNumber) {
            largestNumber = number
        }
    }
    
    return largestNumber
}

var largestNumber = largestInt(myArray)