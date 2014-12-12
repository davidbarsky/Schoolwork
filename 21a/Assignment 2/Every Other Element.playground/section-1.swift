// Playground - noun: a place where people can play

import UIKit

var firstArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
var secondArray = [Int]()
secondArray = []

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

oddOneOut(firstArray, secondArray)
