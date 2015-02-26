;; This is the code for ``Computer Psychiatrist'' (Doctor)

; for Racket users...
(#%require (only racket/base random))
; *******************

(define (visit-doctor name)
  (write-line (list 'hello name))
  (write-line '(what seems to be the trouble?))
  (doctor-driver-loop name))

(define (doctor-driver-loop name)
  (newline)
  (write '**)
  (let ((user-response (read)))
    (cond ((equal? user-response '(goodbye))
             (write-line (list 'goodbye name))
             (write-line '(see you next week)))
          (else (write-line (reply user-response))
                (doctor-driver-loop name)))))

(define (reply user-response)
  (cond ((fifty-fifty)
           (append (qualifier)
                   (change-person user-response)))
        (else (hedge))))

(define (fifty-fifty)
  (= (random 2) 0))

(define (qualifier)
  (pick-random '((you seem to think)
                 (you feel that)
                 (why do you believe)
                 (why do you say))))

(define (hedge)
  (pick-random '((please go on)
                 (many people have the same sorts of feelings)
                 (many of my patients have told me the same thing)
                 (please continue))))

(define (replace pattern replacement lst)
  (cond ((null? lst) '())
        ((equal? (car lst) pattern)
           (cons replacement
                 (replace pattern replacement (cdr lst))))
        (else (cons (car lst)
              (replace pattern replacement (cdr lst))))))

(define (many-replace replacement-pairs lst)
  (cond ((null? replacement-pairs) lst)
         (else (let ((pat-rep (car replacement-pairs)))
            (replace (car pat-rep)
                     (cadr pat-rep)
                     (many-replace (cdr replacement-pairs)
                     lst))))))

(define (change-person phrase)
  (many-replace '((i you) (me you) (am are) (my your))
                phrase))

(define (pick-random lst)
  (nth (+ 1 (random (length lst))) lst))

;;******

(define (prob n1 n2)
  (< (random n2) n1))

(define (ask-patient-name)
  (write-line '(next!))
  (write-line '(who are you?))
  (car (read)))

(define (nth n lst)
  (if (= n 1) 
      (car lst)
      (nth (- n 1) (cdr lst))))
;;******

(define (atom? a) (not (pair? a)))

(define nil '())

(define (write-line x) (begin (write x) (newline)))

;;******


;-----------------------------
; Homework Problems Start Here
;-----------------------------


;----------
; Problem 1
;----------

; picks qualifier. just a larger list.
(define (qualifier)
  (pick-random '((you seem to think)
                 (you feel that)
                 (why do you feel that way)
                 (you believe that)
                 (why do you believe)
                 (why do you say))))

; picks hedge. just a larger list.
(define (hedge)
  (pick-random '((please go on)
                 (you are not alone in thinking this)
                 (continue)
                 (many people have the same sorts of feelings)
                 (many of my patients have told me the same thing)
                 (please continue))))

;----------
; Problem 2
;----------

; the modified change-person procedure
(define (change-person phrase)
  (many-replace '((you i) (are am) (your my) (i you) (me you) (am are) (my your))
                phrase))

; helper for new many-replace
(define (map fn items)
  (if (null? items)
      '()
      (cons (fn (car items))
            (map fn (cdr items)))))

(define (replace pattern replacement lst)
  (cond ((null? lst) '())
        ((equal? (car lst) pattern)
           (cons replacement
                 (replace pattern replacement (cdr lst))))
        (else (cons (car lst)
              (replace pattern replacement (cdr lst))))))

(define (many-replace replacement-pairs lst)
  (cond ((null? replacement-pairs) lst)
         (else (let ((pat-rep (car replacement-pairs)))
            (replace (car pat-rep)
                     (cadr pat-rep)
                     (many-replace (cdr replacement-pairs)
                     lst))))))



; See Report.md for questions in problem set

;----------
; Problem 3
;----------

; for adding to items
(define (tack x L)
  (if (null? L)
      (list x)
      (cons (car L) (tack x (cdr L)))))

; initializes past responses list
(define (visit-doctor name)
  (write-line (list 'hello name))
  (write-line '(what seems to be the trouble?))
  (define past-responses (list))
  (doctor-driver-loop name past-responses))

; adds user-responses to past-responses
(define (doctor-driver-loop name past-responses)
  (newline)
  (write '**)
  (let ((user-response (read)))
    (cond ((equal? user-response '(goodbye))
             (write-line (list 'goodbye name))
             (write-line '(see you next week)))
          (else (write-line (reply user-response past-responses))
                (write-line past-responses)
                (doctor-driver-loop name (tack user-response past-responses))))))
                ; regarding last line: there's no need to mutate past-responses, as the new version is
                ; is recursivly passed. pretty clever, I think.

; used to make the program less likely to use the (earlier you said that thing) 
(define (pretty-unlikely)
  (= (random 10) 0))

; reply hanlding
(define (reply user-response past-responses)
  (cond ((fifty-fifty)
        (cond (not (pretty-unlikely)) ; weird logic to make the past-responses not be called so frequently.
              (append (qualifier)     ; it's a last minute band-aid.
                      (change-person user-response)))
              (if (null? past-responses)
                  (append (qualifier) 
                          (change-person user-response)) ; normal flow, dicated by user
                  (append '(earlier you said that)
                          (change-person (pick-random past-responses))))) ; gets random past-response
                 
        (else (hedge))))

;----------
; Problem 4
;----------

; adds user-responses to past-responses
(define (doctor-driver-loop name past-responses)
  (newline)
  (write '**)
  (let ((user-response (read)))
    (cond ((equal? user-response '(goodbye)) ; if goodbye, asks the next patient's name, and passes it to visit-doctor.
             (write-line (list 'goodbye name))
             (write-line '(see you next week))
             (write-line '(who are you))
             (write '**) ; for consistency in formatting user replies
             (visit-doctor (read))) ; has side benefit of clearing '(past-responses)
                       
          (else (write-line (reply user-response past-responses)) ; otherwise, it continues the therapy sessions
                (doctor-driver-loop name (tack user-response past-responses))))))
                 
; if the patient says "goodbye", this starting method gets called.
(define (visit-doctor name)
  (define past-responses (list))
  (cond ((equal? name '(suppertime))
      (write-line '(quitting time))) ; it also just happens to *end* the psychiatrist's day.
  
  (else (write-line (list 'hello name)) ; but if the day isn't over, the next patient 
        (write-line '(what seems to be the trouble?))
        (doctor-driver-loop name past-responses))))
