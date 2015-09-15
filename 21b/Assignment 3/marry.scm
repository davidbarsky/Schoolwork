;; This is the code for -- Stable Marriage

(define (match-make proposers proposees)
  (send proposers 'reset)
  (send proposees 'reset)
  (courtship proposers proposers proposees)
  (zip-together (send proposers 'name)
                (send (send proposers 'intended) 'name))
  (write-line '(everybody is married!)))

(define (courtship unengaged-proposers proposers proposees) ... )

(define (currently-unengaged list-of-people) ... )

(define (send list-of-people message) ... )

(define (couple? person1 person2) ...)

(define (zip-together list1 list2)
  (if (null? list1)
      '()
      (cons (list (car list1) (car list2))
            (zip-together (cdr list1) (cdr list2)))))

(define (filter pred lst)
  (cond ((null? lst) '())
        ((pred (car lst)) (cons (car lst) (filter pred (cdr lst))))
        (else (filter pred (cdr lst)))))

(define (make-person my-name)
  (let ((preference-list '())
        (possible-mates '())
        (current-intended '()))
    (define (me message)
      (cond ((eq? message 'name) my-name)
            ((eq? message 'intended) current-intended)
            ((eq? message 'loves) preference-list)
            ((eq? message 'possible) possible-mates)
            ((eq? message 'reset)
               (set! current-intended '())
               (set! possible-mates preference-list)
               'reset-done)
            ((eq? message 'load-preferences)
               (lambda (plist)
                  (set! preference-list plist)
                  (set! possible-mates plist)
                  (set! current-intended '())
                  'preferences-loaded))
            ((eq? message 'propose)
               (let ((beloved (car possible-mates)))
                 (set! possible-mates (cdr possible-mates))
                 (if (eq? ((beloved 'i-love-you) me)
                          'i-love-you-too)
                     (begin (set! current-intended beloved)
                            'we-are-engaged)
                     'no-one-loves-me)))
            ((eq? message 'i-love-you) ... )
            ((eq? message 'i-changed-my-mind)
               (lambda (lost-love)
                  (cond ((eq? current-intended lost-love)
                            (set! current-intended '())
                            'dumped!)
                        (else 
                            'there-must-be-some-misunderstanding))))
            (else 
              (error "Bad message to a person " (list me my-name message)))))
      me))

;---------------
; Helper Methods
;---------------

; for tacking unto item
(define (tack x L)
  (if (null? L)
      (list x)
      (cons (car L) (tack x (cdr L)))))

; to print out message to console.
(define (write-line x)
  (display x)
  (newline))

;----------
; Problem 0
;----------

; Please see Report.md

;----------
; Problem 1
;----------

; less typing than "match-make"
(define (mm p1 p2)
  (match-make p1 p2))

; checks if person1's intended is the same as person2. If that's the case,
; they are a couple. otherwise, false.
(define (couple? person1 person2)
  (if (equal? (person1 'intended) person2)
      #t
      #f))

; a helper method for finding out if a person is single. more semantic than `couple?`
(define (single? person)
  (if (null? (person 'intended))
      #t
      #f))

; filters 
(define (currently-unengaged list-of-people)
  (if (null? list-of-people)
      '()
      (filter single? list-of-people)))

; sends people a message. if it's null, it a nil list
; otherwise, it sends the person the message, and recurses on the cdr of the list.
(define (send people message)
  (if (null? people)
      '()
      (begin ((car people) message)
             (send (cdr people) message))))

; helper for (i-like-more?). zero indexed.
(define (distance-from-start items target)
  (if (or (null? items) (eq? (car items) target))
      0
      (+ 1 (distance-from-start (cdr items) target))))

; to check if element exists in list. useful for (i-like-more?)
(define (present? target items)
  (if (null? items)
      #f
      (if (equal? (car items) target)
          #t
          (present? target (cdr items)))))
  

; recreated here in order to implement (i-like-more?)
(define (make-person my-name)
  (let ((preference-list '())
        (possible-mates '())
        (current-intended '()))
    (define (me message)
      (cond ((eq? message 'name) my-name)
            ((eq? message 'intended) current-intended)
            ((eq? message 'loves) preference-list)
            ((eq? message 'possible) possible-mates)
            ((eq? message 'reset)
               (set! current-intended '())
               (set! possible-mates preference-list)
               'reset-done)
            ((eq? message 'load-preferences)
               (lambda (plist)
                  (set! preference-list plist)
                  (set! possible-mates plist)
                  (set! current-intended '())
                  'preferences-loaded))
            ((eq? message 'i-like-more?)
               (lambda (person1 person2)
                    (if (and (present? person1 preference-list) (present? person2 preference-list)) ; if they're both (cont.)
                        (if (< (distance-from-start preference-list person1)                      ; present, operate normally.
                               (distance-from-start preference-list person2))
                            #t
                            #f)
                        (begin ; otherwise, check if each one is present. if it's present, that one is preferred.
                          (if (and (not (present? person1 preference-list)) (present? person2 preference-list))
                              #f
                              (if (and (present? person1 preference-list) (not (present? person2 preference-list)))
                                  #t
                                  #f))))))
            ((eq? message 'propose)
               (let ((beloved (car possible-mates)))
                 (set! possible-mates (cdr possible-mates))
                 (if (eq? ((beloved 'i-love-you) me)
                          'i-love-you-too)
                     (begin (set! current-intended beloved)
                            'we-are-engaged)
                     'no-one-loves-me)))
            ((eq? message 'i-love-you) ... )
            ((eq? message 'i-changed-my-mind)
               (lambda (lost-love)
                  (cond ((eq? current-intended lost-love)
                            (set! current-intended '())
                            'dumped!)
                        (else 
                            'there-must-be-some-misunderstanding))))
            (else 
              (error "Bad message to a person " (list me my-name message)))))
      me))

; debugger
(define (pry names)
  (if (null? names)
      (write-line '(done!))
      (begin
        (write-line ((car names) 'name))
        (pry (cdr names)))))

; the courtship process. it's why we're all here!
(define (courtship unengaged-proposers proposers proposees)
  (if (not (null? unengaged-proposers))
      (begin
        (send unengaged-proposers 'propose)
        (courtship (currently-unengaged proposers) proposers proposees))))

;----------
; Problem 2
;----------

(define (make-person my-name)
  (let ((preference-list '())
        (possible-mates '())
        (current-intended '()))
    (define (me message)
      (cond ((eq? message 'name) my-name)
            ((eq? message 'intended) current-intended)
            ((eq? message 'loves) preference-list)
            ((eq? message 'possible) possible-mates)
            ((eq? message 'reset)
               (set! current-intended '())
               (set! possible-mates preference-list)
               'reset-done)
            ((eq? message 'load-preferences)
               (lambda (plist)
                  (set! preference-list plist)
                  (set! possible-mates plist)
                  (set! current-intended '())
                  'preferences-loaded))
            ((eq? message 'i-like-more?)
               (lambda (person1 person2)
                    (if (and (present? person1 (me 'loves)) (present? person2 (me 'loves))) ; if they're both (cont.)
                        (if (< (distance-from-start preference-list person1)                      ; present, operate normally.
                               (distance-from-start preference-list person2))
                            #t
                            #f)
                        (begin ; otherwise, check if each one is present. if it's present, that one is preferred.
                          (if (and (not (present? person1 preference-list)) (present? person2 preference-list))
                              #f
                              (if (and (present? person1 preference-list) (not (present? person2 preference-list)))
                                  #t
                                  #f))))))
            ((eq? message 'propose)
               (let ((beloved (car possible-mates)))
                 (set! possible-mates (cdr possible-mates))
                 (write-line (me 'name))
                 (if (eq? ((beloved 'i-love-you) me)
                          'i-love-you-too)
                     (begin (set! current-intended beloved)
                            'we-are-engaged)
                     'no-one-loves-me)))
            ((eq? message 'i-love-you)
               (lambda (proposer)
                 ; if i'm single, and I like you, we're getting hitched.
                 (if (and (single? me) (present? proposer preference-list))
                       ; get married
                       (begin
                         (write-line '(i love you too))
                         (set! current-intended proposer)
                         ((proposer 'i-love-you) me))
                       ; nothing happened
                       (write-line '(buzz off creep)))
                 ; if i'm not single, but i like the proposer more, proposer and me are getting hitched.
                 (if (not (single? me))
                     (if ((me 'i-like-more?) proposer (me 'intended))
                        (begin
                          ((current-intended 'i-changed-my-mind) me) ; breaks up
                          (set! current-intended proposer)
                          ((proposer 'i-love-you) me))
                        
                         ; gets called unnecessarily when people are proposing to one another.
                         (write-line '(buzz off creep condition 2))))))
            ((eq? message 'i-changed-my-mind)
               (lambda (lost-love)
                  (cond ((eq? current-intended lost-love)
                            (set! current-intended '())
                            'dumped!)
                        (else 
                            'there-must-be-some-misunderstanding))))
            (else 
              (error "Bad message to a person " (list me my-name message)))))
      me))

;----------
; Problem 3
;----------


; method for prinitng out notes and names
(define (dialogue note name)
  (display note)
  (display #\ ) ; adds a space.
  (display name)
  (newline))

; recreated again for the dialogue
(define (make-person my-name)
  (let ((preference-list '())
        (possible-mates '())
        (current-intended '()))
    (define (me message)
      (cond ((eq? message 'name) my-name)
            ((eq? message 'intended) current-intended)
            ((eq? message 'loves) preference-list)
            ((eq? message 'possible) possible-mates)
            ((eq? message 'reset)
               (set! current-intended '())
               (set! possible-mates preference-list)
               'reset-done)
            ((eq? message 'load-preferences)
               (lambda (plist)
                  (set! preference-list plist)
                  (set! possible-mates plist)
                  (set! current-intended '())
                  'preferences-loaded))
            ((eq? message 'i-like-more?)
               (lambda (person1 person2)
                    (if (and (present? person1 (me 'loves)) (present? person2 (me 'loves))) ; if they're both (cont.)
                        (if (< (distance-from-start preference-list person1)                      ; present, operate normally.
                               (distance-from-start preference-list person2))
                            #t
                            #f)
                        (begin ; otherwise, check if each one is present. if it's present, that one is preferred.
                          (if (and (not (present? person1 preference-list)) (present? person2 preference-list))
                              #f
                              (if (and (present? person1 preference-list) (not (present? person2 preference-list)))
                                  #t
                                  #f))))))
            ((eq? message 'propose)
               (let ((beloved (car possible-mates)))
                 (set! possible-mates (cdr possible-mates))
                 (dialogue '(current proposer is) (me 'name))
                 (if (eq? ((beloved 'i-love-you) me)
                          'i-love-you-too)
                     (begin (set! current-intended beloved)
                            'we-are-engaged)
                     'no-one-loves-me)))
            ((eq? message 'i-love-you)
               (lambda (proposer)
                 ; if i'm single, and I like you, we're getting hitched.
                 (if (and (single? me) (present? proposer preference-list))
                       ; get married
                       (begin
                         (dialogue '(we're married) (me 'name))
                         (set! current-intended proposer)
                         ((proposer 'i-love-you) me))
                       ; nothing happened. lets prints out who got rejected
                       (dialogue '(buzz off creep. sent from) (me 'name)))
                 ; if i'm not single, but i like the proposer more, proposer and me are getting hitched.
                 (if (not (single? me))
                     ; funny bit is that the other bits never get called.
                     (if ((me 'i-like-more?) proposer (me 'intended))
                        (begin
                          ; break up dialogue
                          (write-line '(breakup:))
                          (dialogue (me 'name) (current-intended 'name))
                          
                           ((current-intended 'i-changed-my-mind) me) ; breaks up
                          (set! current-intended proposer)
                          ((proposer 'i-love-you) me))))))
            ((eq? message 'i-changed-my-mind)
               (lambda (lost-love)
                  (cond ((eq? current-intended lost-love)
                            (set! current-intended '())
                            'dumped!)
                        (else 
                            'there-must-be-some-misunderstanding))))
            (else 
              (error "Bad message to a person " (list me my-name message)))))
      me))
      
;; This is a test file for -- Stable Marriage

(define alan (make-person 'Alan))
(define bob (make-person 'Bob))
(define charles (make-person 'Chuck))
(define david (make-person 'Dave))
(define ernest (make-person 'Ernie))
(define franklin (make-person 'Frank))
(define agnes (make-person 'Agnes))
(define bertha (make-person 'Bertha))
(define carol (make-person 'Carol))
(define deborah (make-person 'Debbie))
(define ellen (make-person 'Ellen))
(define francine (make-person 'Fran))

((alan 'load-preferences)
   (list agnes carol francine bertha deborah ellen))
((bob 'load-preferences)
   (list carol francine bertha deborah agnes ellen))
((charles 'load-preferences)
   (list agnes francine carol deborah bertha ellen))
((david 'load-preferences)
   (list francine ellen deborah agnes carol bertha))
((ernest 'load-preferences)
   (list ellen carol francine agnes deborah bertha))
((franklin 'load-preferences)
   (list ellen carol francine bertha agnes deborah))
((agnes 'load-preferences)
   (list charles alan bob david ernest franklin))
((bertha 'load-preferences)
   (list charles alan bob david ernest franklin))
((carol 'load-preferences)
   (list franklin charles bob alan ernest david))
((deborah 'load-preferences)
   (list bob alan charles franklin david ernest))
((ellen 'load-preferences)
   (list franklin charles bob alan ernest david))
((francine 'load-preferences)
   (list alan bob charles david franklin ernest))

(define men (list alan bob charles david ernest franklin))
(define women (list agnes bertha carol deborah ellen francine))

(define bob (make-person 'Bob))
(define carol (make-person 'Carol))
(define ted (make-person 'Ted))
(define alice (make-person 'Alice))
((bob 'load-preferences) (list carol alice))
((ted 'load-preferences) (list alice carol))
((carol 'load-preferences) (list ted bob))
((alice 'load-preferences) (list bob ted))
(define men (list bob ted))
(define women (list carol alice))