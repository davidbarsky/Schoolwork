;; ---------------
;; 4.6: Adding Let
;; ---------------

(define (let-initials exp)
  (map cadr (cadr exp))) ; `cadr` is shorthand for `(car (cdr x))`

; sets the parameters car, car, cdr down.
(define (let-parameters exp)
  (map car (cadr exp))) ; see above

; sets the body of the expression two cdr's down
(define (let-body exp)
  (cddr exp)) ; `cddr` is shorthand (cdr (cdr x))

(define (let->combination exp)
  (cons (make-lambda (let-parameters exp)
                     (let-body exp))
        (let-initials exp)))

; adds `let` to eval
(define (eval-let exp env)
  (eval# (let->combination exp) env))

;;-----------------
;; 4.7: Adding Let*
;;-----------------

(define (let? exp) (tagged-list? exp 'let))
(define (let-assignment exp) (cadr exp))
(define (let-body exp) (cddr exp))

(define (let-exp assignment)
  (if (null? assignment)
      '()
      (cons (cadr (car assignment))
            (let-exp (cdr assignment)))))

(define (let-var assignment)
  (if (null? assignment)
      '()
      (cons (car (car assignment))
            (let-var (cdr assignment)))))

(define (let->combination exp)
  (transform-let (let-assignment exp) (let-body exp)))

(define (transform-let assignment body)
  (cons (make-lambda (let-var assignment) body)
        (let-exp assignment)))

(define (eval-let-* exp env)
  (eval# (let->combination exp) env))

;;-------------------
;; 4.13: Make-Unbound
;;-------------------

(define (make-unbound! variable environment)
  (define (scan bindings)
    (cond ((null? bindings)
           (error "Unbound Variable" variable)) ; base case
          ((eq? variable (caar bindings))
           (set! bindings (cdr bindings))) ; unbinds variable
          (else (scan (cdr bindings)))))   ; follows list down
  (scan (first-frame env))

;;-------------------------
;; 4.15: Halting Procedures
;;-------------------------

;; See ReadMe.md for Explaination
