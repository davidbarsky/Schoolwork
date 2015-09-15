# Problem Set 5: The Metacircular Evaluator

## Homework Problems

### 4.6: Adding `let`

The comments provide the most thorough documentation of 4.6.

### 4.7: Adding `let*`

`let*` can be implemented by `cdr`ing down a list and applying `let-var` on each successive call.

### 4.13: `make-unbound`

`make-unbound` takes two procedures — the variable to be unbound, and current environment. The `make-unbound` procedure isn't recursive, so it only checks the *current* environment before giving up and throwing an error.

### 4.15: Halting Procedures

Let’s assume that we do have a procedure called `halts?` which determines if a procedure halts on a given input.

For this proof, we’ll define:

`(define (run-forever) (run-forever))`

```lisp
(define (try p)
  (if (halts? p p)
     (run-forever)
     'halted))
```

So if `(p p)` halts, then `(try p)` will run forever. If `(p p)` runs forever, `(try p)` will halt.

Let’s try `(try try)`. If `(try try)` halts, then `(try try)` will run forever. That’s a contradiction, so `halts?` cannot exist.

## Lab Portion

### Problem 1

I implemented the hybrid evaluator by “building down” from the `mceval-normal` evaluator.
