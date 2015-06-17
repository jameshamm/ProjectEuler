

def largestPrimeFactor(N):
	i = 2
	temp = N
	while(i * i <= temp):
		while(temp % i == 0):
			temp /= i
	
		i += 1

	return temp

def solve():
	N = 600851475143
	largest = largestPrimeFactor(N)
	print largest

solve()