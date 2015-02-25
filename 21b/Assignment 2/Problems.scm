; Exercise 2.4: Representing pairs as procedures.

;(define (cons x y)
;  (lambda (m) (m x y)))

;(define (car z)
;  (z (lambda (p q) p)))

;(define (cdr z)
;  (z (lambda (p q) q)))

;; the substitution model in play
;(car (cons x y))
;(car (lambda (m) (m x y)))
;((lambda (m) (m x y)) (lambda (p q) p))
;((lambda (p q) p) x y)
;x

; Exersize 2.21: Square List (done for understanding, not grade.)

; map procedure, used for (square-list)
(define (map fn items)
  (if (null? items)
      '()
      (cons (fn (car items))
            (map fn (cdr items)))))

(define (square-list items)
  (map (lambda (x) (* x x))
       items))

; Exercise 2.22: Bad implementations of square-list.

; defines a squaring function
(define (square x)
  (* x x))

; the iterative solution
(define (iter-square-list items)
   (define (iter things answer)
     (if (null? things)
         answer ; base case
         (iter (cdr things)
               (append answer 
                       (list (square (car things))))))) ; cdr down the list
   (iter items '()))


; Exercise 2.25: car and cdr finger-exercises.
; definition, solution follow

(define list1 (list 1 3 (list 5 7) 9))
(car (cdr (car (cdr (cdr list1)))))

(define list2 (list (list 7)))
(car (car list2))

; you have *got* to be kidding me
(define list3 (list 1 (list 2 (list 3 (list 4 (list 5 (list 6 7)))))))
(car (cdr (car (cdr (car (cdr (car (cdr (car (cdr (car (cdr list3)))))))))))) ; parking lot


; Exercise 2.26: comparing cons, list, and append.

(define x (list 1 2 3))
(define y (list 4 5 6))

; (append x y)
; (1 2 3 4 5 6)

; (cons x y)
; #<procedure:...t 2/Problems.scm:4:2>
; Presumeably ((1 2 3) (4 5 6))

; (list x y)
; ((1 2 3) (4 5 6))


; Exercise 2.27: deep-reverse.

; declarations
(define listx (list (list 1 2) (list 3 4)))
(define listy (list 1 2 3 4))

; append procedure for (deep-reverse)
(define (append list1 list2)
  (if (null? list1)
      list2
      (cons (car list1) (append (cdr list1) list2))))

; the deep-reverse procedure. a list member is pair, the procedure 
; calls itself until it reaches the base case, which is when the
; list member doesn't contain any *other* list members
(define (deep-reverse items)
  (cond ((null? items) 
         '())
         ((pair? (car items))
                 (append (deep-reverse (cdr items))
                         (list (deep-reverse (car items)))))
         (else
                 (append (deep-reverse (cdr items))
                         (list (car items))))))

; Exercise 2.28: fringe.

(define x (list (list 1 2) (list 3 4)))

(define (fringe tree)
  (cond ((null? tree)
        '())
        ((not (pair? tree))
         (list tree))
        (else (append (fringe (car tree))
                      (fringe (cdr tree))))))