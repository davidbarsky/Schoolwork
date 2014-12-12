---
Notes: Big omega exceeds every input. (everything's slower). There's an unlimited bound above the function.
Big O: Everything's faster. There's a limited bound below the function.

---

1. Prove each by applying directly the definitions given in class of O, Ω, and Θ:
  a. 83n is Θ(n) 
    1. For all integers n is greater than or equal to 1, plugging any n — say, 5 — would cause the function f(n) increase equally or less than in proportion to plugging 5 into 83n, thereby satisfying the conditions for O.
    2. In addition, for all integers n greater than or equal to 1, plugging in any n — in this case, 30 — would cause the function Θ(n) to increase at a proportion that is greater than or equal to 83n, satisfying conditions for Ω. 
    3. Since it satisfies conditions for both O and Ω, it is Θ(n).

  b. n^2 is Ω(22n)
    1. For all integers *n* is greater than or equal to 22, assigning any value to *n* would cause the function n^2 to increase much faster than 22n would, indicating that there's an unlimited upper bound for n^2. Therefore, it fits the definition of Ω. Anytime n is bigger than 22, n^2 is going to be bigger than g(n).

  c. n^2/1000 is Ω(1000n)
    1. C is 1,000,000 (multiply n^2/1000 by 1000). For all integers greater than or equal to 1,000,000, n^2/1000 (henceforth referred to as f(n)) would increase at a rate faster than Ω(1000n), indicating that there is no upper limit to f(n), meeting the requirement for Ω.

  d. 10n^2 + 5n is O(n^3)
    1. For integers greater than or equal to 11, 10n^2 + 5n (f(n)) performs better than n^3 (g(n)). For instance: plugging in 13 as n into both f(n) and g(n) results in 1755 and 2197, respectively. This indicates that there is an upper bound to f(n), meeting the requirements for O.

  e. 2n^4 − 3n^2 +32n√n − 5n + 60 is Θ(n^4)
    1. For all integers n is greater than or equal to 0, plugging any n — say, 5 — would cause the function g(n) increase equally or less than in proportion to plugging 5 into f(n), thereby satisfying the conditions for O.
    2. In addition, for all integers n greater than or equal to 0, plugging in any n — in this case, 30 — would cause the function f(n) to increase at a proportion that is greater than or equal to g(n), satisfying conditions for Ω. 
    3. Since it satisfies conditions for both O and Ω, it is Θ(n).

  f. 2n^2√n is not Ω(n^3)
    1. f(n) can be represented as 2n^(5/2), and g(n) as n^(6/2). For any integer greater than or equal to 5, g(n) increases at a faster rate than g(n). Therefore, f(n) is not Ω(n^3), as there is no upper bound for f(n). For instance, when n is 7 produces f(n) produces 733.3648478077, while g(n) produced 343.

  g. 2n^3 + 2n is O(2^n)
    1. For all integers greater than or equal to 15, g(n) increases at a faster rate than f(n). Therefore, for all integers greater than or equal to 15, f(n) is O(2^n). For instance, when n is 21, f(n) produces 74,130, while g(n) produces 2,097,152.

  h. nlog2(n) is O(n^3/2)
    1. For all integers greater than or equal to 0, g(n) increases at faster rate than f(n). For instance, when n is 3, f(n) produces 1.43, while g(n) produces 5.20. Therefore, f(n) is O(log(n)).

  i. 2n^3 + 10log2(n)^6 is O(n^3)
    1. For all integers n is greater than or equal to 1, plugging any n — say, 5 — would cause the function f(n) increase equally or less than in proportion to plugging 5 into n^3, thereby satisfying the conditions for O.

  j. 5n√nlog2(n) is O(n^2)
    1. For all integers greater than or equal to 100, g(n) increases at a faster rate than f(n). An example: when n is 150, g(n) produces 22,500, while f(n) produces 19,988.6745690638. Therefore, it satisfies the conditions for O.

***

2. Using the definitions given in class of O and Ω, prove that:
  a. f(n) is O(cg(n)) implies f(n) is O(g(n)). Constants do not matter when finding the behavior of large N's. Therefore, f(n) is O(cg(n)).
  b. f(n) - g(n) is O(h(n)) implies f(n) is O(g(n)+h(n)). The two are equivalent — either a value is being subtracted on one end, or added on another.
  c. f(n) is O(g(n)) and g(n) is O(h(n)) implies f(n) is O(h(n)). Transitive property applies here — if A equals B, and B equals C, therefore A equals C.
  d. f(n) is Ω(g(n)) and g(n) is Ω(h(n)) does not imply f(n) is Ω(h(n)). Transitive properties don't apply to Ω properties — upper bounds require more information to define.

3. 
  a. Each place in a decimal number — tens, hundreds, thousands — increases in order of magnitude for bit storage in decimal. For binary, that increase in magnitude is significantly less —  it can be expressed in 14 bits.
  b.
     func logCalculator(n:Int, iteration:Int) -> n:Int {
        if iteration = 0 {
          return log(n)/log(2)
        } else {
          logCalculator(n, iterations--)
        }
      }

4. 
    func ternarySearch(list:[Int], goal:Int, leftMax:Int, rightMax:Int) -> Int {
      if (absoluteValueOf(leftMax - rightMax) < goal) {
        return (rightMax + leftLeft)/2
      }
  
      rightThird = (leftMax + (rightMax * 2))/3
      leftThird = ((2 * leftMax) + rightMax)/3
  
      if (leftThird < rightThird) {
        return ternarySearch(list, goal, leftThird, right)
      } else {
        return ternarySearch(list, goal, left, rightThird)
      }
    }
