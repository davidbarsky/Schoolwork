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
                   2))     ; 20 kg of fuel left

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

(define (full-burn ship-state) 1)
(define (no-burn ship-state) 0)

(define (play ask-user) (lander-loop (initial-ship-state)))

(define (lander-loop ship-state)
  (show-ship-state ship-state)
  (if (landed? ship-state)
      (end-game ship-state)
      (lander-loop (update ship-state (get-burn-rate)))))

(define (ask-user ship-state) (get-burn-rate))