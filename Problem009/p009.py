import math
def solve(target):
	targetDIV3 = int(target/3)
	count = 0
	for a in xrange(2, targetDIV3):
		b = a + 1
		while b < (target-a)/2:
			if(a*b % target == 0 and a + b - a*b/target == target/2):
				c =  math.sqrt(a*a + b*b)
				print "\t%d, %d, %d\n%d" % (a, b, c, a*b*c)
				#a = targetDIV3 	#breaks outer loop
				#break			#use if unique
			b += 2
solve(1000)