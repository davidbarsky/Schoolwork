#pragma mark - Declarations/Imports

#include <stdio.h>
#include <stdlib.h>

#define QUEUESIZE 50000
#define HASHSIZE 100003

#pragma mark - Boolean

typedef enum { false, true } bool;

#pragma mark - Board

typedef enum { up, down, left, right } direction;

typedef struct point {
    int x;
    int y;
} point;

typedef struct board {
    char internalArray[6][2];
    point freePosition;
} *board;

board createGoalBoard() {
    board goalBoard = (board) malloc(sizeof(struct board));
    if (goalBoard == NULL) {
        printf("Malloc failed for a new board");
        exit(1);
    }
    
    // inserting string into 2D array
    char boardString[] = "PANAMACANAL ";
    int stringPointer = 0;
    
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 2; j++) {
            goalBoard->internalArray[i][j] = boardString[stringPointer];
            stringPointer++;
        }
    }
    
    goalBoard->freePosition.x = 5;
    goalBoard->freePosition.y = 1;
    
    return goalBoard;
}

board createStartingBoard() {
    board startingBoard = (board) malloc(sizeof(struct board));
    if (startingBoard == NULL) {
        printf("Malloc failed for a new board");
        exit(1);
    }
    
    // inserting string into 2D array
    char boardString[] = "CANAMAPANAL ";
    int stringPointer = 0;
    
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 2; j++) {
            startingBoard->internalArray[i][j] = boardString[stringPointer];
            stringPointer++;
        }
    }
    
    startingBoard->freePosition.x = 5;
    startingBoard->freePosition.y = 1;
    
    return startingBoard;
}

#pragma mark - Position

typedef struct positionNode {
    struct positionNode *next; // next position in the bucket
    struct positionNode *back; // position from where this came from
    int cost;                  // number of moves needed to get to this position
    char piece;                // piece that moved to this new position
    direction direction;       // direction *moved* to enter this position
    board currentBoard;       // current board position
} PositionBody;

typedef PositionBody *TypePosition;

TypePosition newPosition() {
    TypePosition position = (TypePosition) malloc(sizeof(PositionBody));
    if (position == NULL) {
        printf("Malloc for a new position failed.");
        exit(1);
    }
    position->next = NULL;
    position->back = NULL;
    
    return position;
}

TypePosition insertBoardIntoPositionStruct(board boardToInsert) {
    TypePosition position = newPosition();
    position->currentBoard = boardToInsert;
    
    return position;
}

#pragma mark - List

typedef struct List {
    int count;
    TypePosition *first;
    TypePosition *last;
} *List;

List listCreate() {
    List list = malloc(sizeof(List));
    list->first = NULL;
    list->last = NULL;
    
    return list;
}

void appendToList(List list, TypePosition *newPositionBody) {
//    TypePosition newPositionBody = newPosition();
//    node->next = newPositionBody;
//    
//    if (list->last == NULL) {
//        list->first = &node;
//        list->last = &node;
//    } else {
//        list->last->next = node;
//        (*node).back = *list->last;
//        list->last = &node;
//    }
    
    if (list->last == NULL) {
        list->first = newPositionBody;
        list->last = newPositionBody;
    } else {
        list->last->next = &newPositionBody;
        
    }
}

//void removeFromList(List list, PositionBody *body) {
//    void *result = NULL;
//
//    if(body == list->first && body == list->last) {
//        list->first = NULL;
//        list->last = NULL;
//    } else if(body == list->first) {
//        list->first = body->next;
//        check(list->first != NULL, "Invalid list, somehow got a first that is NULL.");
//        list->first->prev = NULL;
//    } else if (body == list->last) {
//        list->last = body->prev;
//        check(list->last != NULL, "Invalid list, somehow got a next that is NULL.");
//        list->last->next = NULL;
//    } else {
//        ListNode *after = body->next;
//        ListNode *before = body->prev;
//        after->prev = before;
//        before->next = after;
//    }
//
//    list->count--;
//    result = node->value;
//    free(node);
//
//error:
//    return result;
//}


#pragma mark - Queue

typedef struct CircularQueue {
    int size;
    int start;
    int end;
    TypePosition elements[QUEUESIZE];
} *CircularQueue;

CircularQueue queue;

void createQueue() {
    CircularQueue queue = (CircularQueue) malloc(sizeof(CircularQueue));
    if (queue == NULL) {
        printf("Malloc failed for Queue");
        exit(1);
    }
    
    for (int i = 0; i < QUEUESIZE; i++) {
        queue->elements[i] = NULL;
    }
    
    queue->start = 0;
    queue->end = 0;
    queue->size = QUEUESIZE + 1;
}

bool isQueueFull(CircularQueue queue) {
    if ((queue->end + 1) % queue->size == queue->start) {
        return true;
    } else {
        return false;
    }
}

void emptyqueue(CircularQueue queue) {
    free(queue->elements);
}

void push(CircularQueue queue, TypePosition *element) {
    queue->elements[queue->end] = *element;
    queue->end = (queue->end + 1) % (queue->size);
    
    if (queue->end == queue->start) {
        queue->start = (queue->start + 1) % queue->size;
    }
}

TypePosition pop(CircularQueue queue) {
    TypePosition element = queue->elements[queue->start];
    queue->elements[queue->start] = NULL;
    queue->start = queue->start + 1 % queue->size;
    
    return element;
}


#pragma mark - Hash Table

typedef struct HashTable {
    List internalArray[HASHSIZE];
} HashTable;

int hashFunction(TypePosition itemToHash) {
    int Hvalue = 0;
    
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 2; j++) {
            Hvalue = ((Hvalue * 128) + itemToHash->currentBoard->internalArray[i][j]) % HASHSIZE;
        }
    }
    return Hvalue;
}

HashTable *createHashTable() {
    HashTable *table = calloc(1, sizeof(HashTable));
    if (table == NULL) {
        printf("Malloc failed for a new hashmap");
        exit(1);
    }
    
    return table;
}

bool doesHashTableHave(HashTable *table, TypePosition *element) {
    int hashPosition = hashFunction(*element);
    if (table->internalArray[hashPosition] != NULL) {
        return true;
    } else {
        return false;
    }
}

List hashTableGet(HashTable *table, TypePosition *element) {
    int hashPosition = hashFunction(*element);
    
    List list = table->internalArray[hashPosition];
    return list;
}

void hashTableSet(HashTable *table, TypePosition *newPosition) {
    int position = hashFunction(*newPosition);
    
    if (doesHashTableHave(table, newPosition)) {
        List list = hashTableGet(table, newPosition);
        appendToList(list, newPosition);
        table->internalArray[position] = list;
    } else {
        List list = listCreate();
        appendToList(list, newPosition);
        table->internalArray[position] = list;
    }
}

TypePosition getItemFromList(List list) {
    TypePosition body = list->last;

    return body;
}

#pragma mark - Movements

bool isGoalFound(board goalBoard, board currentBoard) {
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 2; j++) {
            if (goalBoard->internalArray[i][j] == currentBoard->internalArray[i][j]) {
                printf("everything's fine, keep going\n");
            } else {
                return false;
            }
        }
    }
    
    return true;
}

// up
bool isMoveUpPossible(board currentBoard) {
//    board currentBoard = currentPosition->currentBoard;
    if (currentBoard->freePosition.y == 0) {
        return true;
    } else {
        return false;
    }
}

// down
bool isMoveDownPossible(board currentBoard) {
    if (currentBoard->freePosition.y == 1) {
        return true;
    } else {
        return false;
    }
}

// right
bool isMoveRightPossible(board currentBoard) {
    if (currentBoard->freePosition.x >= 0) {
        return true;
    } else {
        return false;
    }
}

// left
bool isMoveLeftPossible(board currentBoard) {
    if (currentBoard->freePosition.x <= 5) {
        return false;
    } else {
        return true;
    }
}

#pragma mark - Movements

TypePosition moveTile(TypePosition *positionBeforeMove, direction movementDirection) {
    TypePosition *positionAfterMove = positionBeforeMove;
    board boardBeforeMove = (*positionAfterMove)->currentBoard;
    board boardAfterMove = (*positionAfterMove)->currentBoard;
    
    point freePosition = (*positionAfterMove)->currentBoard->freePosition;
    point newFreePosition = freePosition;
    
    if (movementDirection == up) {
        char tileToMove = boardBeforeMove->internalArray[freePosition.x][freePosition.y + 1];
        
        // the swap
        boardAfterMove->internalArray[freePosition.x][freePosition.y] = tileToMove;
        boardAfterMove->internalArray[freePosition.x][freePosition.y + 1] = '\0';
        
        // free position update
        newFreePosition.x = freePosition.x;
        newFreePosition.y = freePosition.y + 1;
    } else if (movementDirection == down) {
        char tileToMove = boardBeforeMove->internalArray[freePosition.x][freePosition.y - 1];
        
        // the swap
        boardAfterMove->internalArray[freePosition.x][freePosition.y] = tileToMove;
        boardAfterMove->internalArray[freePosition.x][freePosition.y - 1] = '\0';
        
        // free position update
        newFreePosition.x = freePosition.x;
        newFreePosition.y = freePosition.y - 1;
    } else if (movementDirection == right) {
        char tileToMove = boardBeforeMove->internalArray[freePosition.x - 1][freePosition.y];
        
        // the swap
        boardAfterMove->internalArray[freePosition.x][freePosition.y] = tileToMove;
        boardAfterMove->internalArray[freePosition.x - 1][freePosition.y] = '\0';
        
        // free position update
        newFreePosition.x = freePosition.x - 1;
        newFreePosition.y = freePosition.y;
    } else if (movementDirection == left) {
        char tileToMove = boardBeforeMove->internalArray[freePosition.x + 1][freePosition.y];
        
        // the swap
        boardAfterMove->internalArray[freePosition.x][freePosition.y] = tileToMove;
        boardAfterMove->internalArray[freePosition.x + 1][freePosition.y] = '\0';
        
        // free position update
        newFreePosition.x = freePosition.x + 1;
        newFreePosition.y = freePosition.y;
    } else {
        printf("No moves possible.\n");
    }
    
    *positionAfterMove = insertBoardIntoPositionStruct(boardAfterMove);
    (*positionAfterMove)->currentBoard->freePosition.x = newFreePosition.x;
    return *positionAfterMove;
}

#pragma mark - Main Method

int main(int argc, const char * argv[]) {
    // declarations
    HashTable *table = createHashTable();
    CircularQueue queue = createQueue();
    
    // starting tiles
    board startingBoard = createStartingBoard();
    board goalBoard = createGoalBoard();
    TypePosition currentPosition = insertBoardIntoPositionStruct(startingBoard);
    TypePosition goalPosition = insertBoardIntoPositionStruct(goalBoard);
    
    // start of algorithm
    hashTableSet(table, &currentPosition);
    push(queue, &currentPosition);
    
    hashTableGet(<#HashTable *table#>, <#TypePosition *element#>)
    
//    while (!isGoalFound(startingBoard, goalBoard)) {
//        currentPosition = pop(queue);
//        
//        board boardToExplore = currentPosition->currentBoard;
//        
//        bool result = isMoveUpPossible(startingBoard);
//        printf("Is move possible? %d", result);
//
//        if (isMoveUpPossible(boardToExplore) && !doesHashTableHave(table, &currentPosition)) {
//            currentPosition = moveTile(&currentPosition, up);
//            
//            push(queue, &currentPosition);
//            hashTableSet(table, &currentPosition);
//        }
//        if (isMoveDownPossible(boardToExplore) && !doesHashTableHave(table, &currentPosition)) {
//            currentPosition = moveTile(&currentPosition, down);
//            
//            push(queue, &currentPosition);
//            hashTableSet(table, &currentPosition);
//        }
//        if (isMoveRightPossible(boardToExplore) && !doesHashTableHave(table, &currentPosition)) {
//            currentPosition = moveTile(&currentPosition, right);
//            
//            push(queue, &currentPosition);
//            hashTableSet(table, &currentPosition);
//        }
//        if (isMoveLeftPossible(boardToExplore) && !doesHashTableHave(table, &currentPosition)) {
//            currentPosition = moveTile(&currentPosition, left);
//            
//            push(queue, &currentPosition);
//            hashTableSet(table, &currentPosition);
//        }
//    }
    
    printf("Done!");
    
    return 0;
}