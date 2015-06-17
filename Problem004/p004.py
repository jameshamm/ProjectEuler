def isPal(n):
	return str(n) == str(n)[::-1]

def solve():
	best = 1
	for a in xrange(999, 99, -1):
		for b in xrange(999, a-1, -1):
			p = a * b
			if(p < best): break 
			if(p > best) and isPal(p): best = p
	print best

solve()