//
//  main.c
//  Assignment 0
//
//  Created by David Barsky on 10/16/14.
//  Copyright (c) 2014 David Barsky. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#define maxStringLength 128

#pragma -mark Struct Delcaration

struct node {
    int value;
    struct node *next;
};


int main(int argc, const char * argv[]) {
    
    printf("Hi! You'll be entering numbers.\n");

    do {
        char answer[maxStringLength];
        char check[maxStringLength] = "y\n";
        printf("Do again? (y/n)\n");
        fgets(answer, sizeof(answer), stdin);
        
        if (strcmp(answer,check) != 0) {
            break;
        }
        
        printf("Please enter a list of integers, seperated by line.\n");
        do {
            struct node root;
            struct node nextNode;
            root.next = &nextNode;
            
            char input[maxStringLength];
            
            fgets(input, sizeof(input), stdin);
            
            if (isdigit(input[0])) {
                InsertionSort(nextNode);
            } else {
                break;
            }
            
            root.value = input;
            
            printf("%s\n", input);
        } while (1);
    } while (1);

    printf("goodbye.");
    return 0;
}

#pragma -mark Insertion Sort

struct node InsertionSort(struct node *list) {
    
    // checks to see if the list is 1 or 0. If so, return.
    if (!list || !list->next) {
        return *list;
    }
    
    struct node *sorted = NULL;
    
    // using list.value as
    while (list != NULL) {
        // remember the head
        struct node *nodeHead = list;
        // trailing pointer for efficient splice
        struct node *nodeTail = sorted;
        
        // pop head off list
        list = list->next;
        
        // put in head into the sorted list at proper place
        while (!(nodeTail == NULL || nodeHead->value < nodeTail->value)) { // does head belong here?
            // nope, so we'll continue down the list
            nodeTail = nodeTail->next;
        }
        
        nodeHead->next = nodeTail;
        nodeTail = nodeHead;
    }
    
    return *list;
}