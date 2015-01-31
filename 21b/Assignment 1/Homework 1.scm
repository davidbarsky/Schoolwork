; for exercises

(define (1+ x) (+ 1 x))

; ----
; 1.17
; ----

(define (square x)
  (* x x))

(define (double x)
  (+ x x))

(define (halve x)
  (/ x 2))

(define (even? n)
   (= (remainder n 2) 0))

(define (fast-exponent base exponent)
   (cond ((= exponent 0) 1)
         ((even? exponent) (square (fast-exponent base (/ exponent 2))))
         (else (* base (fast-exponent base (- exponent 1))))))

(fast-exponent 2 3)

; ----
; 1.34
; ----

(define (f g) (g 2))

(f square)

(f 
 (lambda (z) 
   (* z (+ z 1))))

; (f f)

; the interpretor tries to apply the function to itself, but fails, as there
; is no valid input to the function.

; ----
; 1.43
; ----

; background
(define (square x) (* x x))
(define (compose f g)
  (lambda (x) (f (g x))))

; solution
(define (repeat f n) 
  (if (< n 1) 
    (lambda (x) x) 
    (compose f (repeat f (- n 1))))) 

; ----
; 1.44
; ----

; -----------------
; Function Doubling
; -----------------

(define (double fn)
  (lambda (x) (fn (fn x))))

((double 1+) 0)
(((double double) 1+) 0)
((((double double) double) 1+) 0)
(((((double double) double) double)1+) 0)
((((((double double) double) double) double) 1+) 0)

; This is an ackerman function — the output growth can be modeled as tetration, or
; itererated exponentiation. The function grows to incomputable levels.




