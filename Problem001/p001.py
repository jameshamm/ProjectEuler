def sumToN(n): return (n*(n+1))/2

def gcd(a, b):
	return b if (a == 0) else gcd(b % a, a)

def lcm(a, b): return (a * b) / gcd(a, b)

N = 1000-1
a = 3
b = 5
c = lcm(a, b)
print a*sumToN(N/a) + b*sumToN(N/b) - c*sumToN(N/c)