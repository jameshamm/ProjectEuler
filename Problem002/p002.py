def get_even_fib_sum(MAX):
    if MAX < 2:
        return 0
    total = 2  # start from 2, since we start after it
    a = 2
    b = 8
    c = 0

    while(b < MAX):
        total += b
        c = b
        b = 4*b + a
        a = c
    return total

print get_even_fib_sum(int(raw_input()))