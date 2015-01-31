; 1.17

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

; 1.34

(define (f g) (g 2))

(f square)

(f (lambda (z) (* z (+ z 1))))

(f f)