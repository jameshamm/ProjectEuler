# Input Format
N
a
b

## Explanation
The first line is the number to stop at
The next two lines are 2 ints to find all the unique multiples of

# Notes
    3 + 6 + 9 + 12 + ... + N
  = 3(1 + 2 + 3 + 4 + ... + N/3

    1 + 2 + 3 + ... + N/3 = N/3 * (N + 1)/3)/2

 => 3*((N/3)*((N+1)/3)/2)

The lcm is counted twice (inclusion exclusion principle) so we have to subtract it from our total
