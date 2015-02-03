;; this is the code for problem set -- Lunar Lander

(define (update ship-state fuel-burn-rate)
  (make-ship-state
   (+ (height ship-state) (* (velocity ship-state) dt)) ; height
   (+ (velocity ship-state)
      (* (- (* engine-strength fuel-burn-rate) gravity)
         dt))                                           ; velocity
   (- (fuel ship-state) (* fuel-burn-rate dt))))        ; fuel

(define (lander-loop ship-state)
  (show-ship-state ship-state)
  (if (landed? ship-state)
      (end-game ship-state)
      (lander-loop (update ship-state (get-burn-rate)))))

(define (show-ship-state ship-state)
  (write-line 
    (list 'height (height ship-state)
          'velocity (velocity ship-state)
          'fuel (fuel ship-state))))

(define (landed? ship-state)
  (<= (height ship-state) 0))

(define (end-game ship-state)
  (let ((final-velocity (velocity ship-state)))
       (write-line final-velocity)
       (cond ((>= final-velocity safe-velocity)
               (write-line "good landing")
               'game-over)
             (else
               (write-line "you crashed!")
               'game-over))))

(define (get-burn-rate)
  (if (= (player-input) burn-key)
      1
      0))

(define (play) (lander-loop (initial-ship-state)))

(define (initial-ship-state)
  (make-ship-state 50       ; 50 km high
                   0        ; not moving (0 km/sec)
                   20))     ; 20 kg of fuel left

(define dt 1)               ; 1 second interval of simulation
  
(define gravity 0.5)        ; 0.5 km/sec/sec
  
(define safe-velocity -0.5) ; 0.5 km/sec or faster is a crash

(define engine-strength 1)  ; 1 kilonewton-second

(define (player-input) 
  (char->integer (prompt-for-command-char " action: "))) 

(define burn-key 32)   ;space key

; You'll learn about the stuff below here in Chapter 2.
; For now, think of make-ship-state, height, velocity, and fuel
; as primitive procedures built in to Scheme.

(define (make-ship-state height velocity fuel)
  (list 'HEIGHT   height
        'VELOCITY velocity
        'FUEL     fuel))

(define (height state) (second state))
(define (velocity state) (fourth state))
(define (fuel state) (sixth state))

(define (second l) (cadr l))
(define (fourth l) (cadr (cddr l)))
(define (sixth l) (cadr (cddr (cddr l))))

; Users of DrScheme or DrRacket: add these for compatibility with MIT Scheme...
; for input and output

(define (write-line x)
  (display x)
  (newline))

(define (get-one-key)
  (let ((x (read-char)))
    (if (eq? x #\newline)
        x
        (empty-buffer x))))

(define (empty-buffer x)
  (if (eq? (read-char) #\newline)
      x
      (empty-buffer x)))

(define (prompt-for-command-char prompt)
  (display prompt)
  (get-one-key)) 

; for random number generation

(#%require (only racket/base random))

; a ridiculous addendum  (you'll need this for the exercises)

(define (1+ x) (+ 1 x))

; ---------
; Problem 1
; ---------

(define (update ship-state fuel-burn-rate)
  (make-ship-state
   (+ (height ship-state) (* (velocity ship-state) dt)) ; height
   (+ (velocity ship-state)
      (if (= (fuel ship-state) 0)
         (* (- 0 gravity))
         (* (- (* engine-strength fuel-burn-rate) gravity) dt)))
          
                                                        ; velocity
   (- (fuel ship-state) (* fuel-burn-rate dt))))        ; fuel

; ---------
; Problem 2
; ---------

; definitions from problem 1
(define (full-burn ship-state) 1)
(define (no-burn ship-state) 0)
(define (ask-user ship-state) (get-burn-rate))

; jury rigged, doesn't respond as it should.
(define (play player-input)
  (if (= (player-input initial-ship-state) (full-burn initial-ship-state))
      (lander-loop (initial-ship-state))
      (lander-loop (initial-ship-state))))

; BUG: full-burn and ask-user causes a contract violation

(define (lander-loop ship-state)
  (show-ship-state ship-state)
  (if (landed? ship-state)
      (end-game ship-state)
        (lander-loop (update ship-state (get-burn-rate)))))
      
; ---------
; Problem 3
; ---------

(define (random-choice state-1 state-2)
  (lambda (ship-state)
    (if (= (random 2) 0)
      (full-burn ship-state)
      (no-burn ship-state))))

; ---------
; Problem 4
; ---------

(define (height-choice strategy-1 strategy-2 height)
  (if (> height 30)
      (play strategy-1)
      (play strategy-2)))

; ---------
; Problem 5
; ---------

; has error, no body.
(define (choice strategy-1 strategy-2) (stategy-1))

(define (random-choice strategy-1 strategy-2)
  (choice strategy-1
          strategy-2
          (lamdba (ship-state) (= (random 2) 0))))
 
(define (height-choice strategy-1 strategy-2 height)
  (choice strategy-1
          strategy-2
          (lamdba (ship-state) (if (> height 30)
                                   (play strategy-1)
                                   (play strategy-2)))))

; ---------
; Problem 6
; ---------

(define (pester-player ship-state)
  (if (> (height ship-state) 40)
      (play no-burn)
      (if (= (random 2) 0)
          (play full-burn)
          (play ask-user))))

; ---------
; Problem 7
; ---------

; downwards velocity has to be cancled out the propulsion. to reach zero from any
; height, a minumum bit of acelloration has to be applied to slow down. It can be
; calculated using the given formula.

; ---------
; Problem 8
; ---------

; helper
(define (square x) (* x x))

(define (constant-acc ship-state)
  (/ (square (velocity ship-state)) (* 2 (ship-state height))))