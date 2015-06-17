def gcd(a, b):
	return a if (b == 0) else gcd(b, a % b)

def lcm(a, b):
	return (a * b) / gcd(a, b)

def solve():
	n = 20
	total = 2
	for a in xrange(2, n+1, 1):
		total = lcm(a, total)
	print total

solve()

