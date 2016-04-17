# Input Format
N

## Explanation
The first line is the number to check up to

# Notes
(Implemented in the java solution)
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...
      e        e           e           e              e                e                   e  ...

Every third fibonacci number is even

f(n+3)  = f(n+2)        + f(n+1)
        = f(n+1) + f(n) + f(n+1)
        = 2*f(n+1) + f(n)

Since we need f(n+1), we work out f(n+1+3)

f(n+4)  = f(n+3) + f(n+2)
        = f(n+1) + f(n) + f(n+1) + f(n+1) + f(n)
        = 3*f(n+1) + 2*f(n)

This gives us O(e) time, where e is the number of even numbers


(c++ implementation)
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...
      e        e           e            e              e                e                  e

    Every third fibonacci number is even

    2, 8, 34, 144, 610, 2584, 10946, 46368, 196418

    f(n+3)  = f(n+2)        + f(n+1)
            = f(n+1) + f(n) + f(n+1)
            = 2*f(n+1) + f(n)

    f(n+6)  = f(n+5) + f(n+4)
            = f(n+4) + f(n+3) + f(n+3) + f(n+2)
            = f(n+3) + f(n+2) + 2*f(n+1) + f(n) + 2*f(n+1) + f(n) + f(n+1) + f(n)
            = 2*f(n+1) + f(n) + f(n+1) + f(n) + 2*f(n+1) + f(n) + 2*f(n+1) + f(n) + f(n+1) + f(n)
            = 8*f(n+1) + 4*f(n) + f(n)
            = 4(2*f(n+1) + f(n)) + f(n)
            = 4*f(n+3) + f(n)

    So the next even term is given by the pervious two even terms