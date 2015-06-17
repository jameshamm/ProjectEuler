
MAX = 4000000;
total = 2; #start from 2, since we missed it
a = 2;
b = 8;
c = 0;
	
while(b < MAX):
	total += b;
	c = b;
	b = 4*b + a;
	a = c;

print total