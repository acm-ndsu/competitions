"""  Solution to Problem F.  Solve the recursive function:
	G(n) = n for all value of n <= 0
	G(n) = G(n-6) + G(n-4) + G(n-2)  for all values of n > 0.
"""
PROMPTS = False
#PROMPT = "Enter n: "

import sys

def main():
    while True:
        if PROMPTS:
            sys.stdout.write("Enter i:")
        n = int(sys.stdin.readline())
        if n == 0:
            break
        sys.stdout.write("G("+str(n)+") = "+str(G(n))+"\n")

## NOTE:  Recursive function is too slow (O(3**n)), but useful for testing
def G_rec(n):
    if n <= 0:
        return n
    else:
        return G_rec(n-6) + G_rec(n-4) + G_rec(n-2)

def G(n):
    if n <= 0:
        return n
    # Store answers in an array and build it up in dynamic programming fashion
    g = [0,-9,-6,-13,-8,-23]   # base cases
    for value in range(6,n+1):
        g.append(g[value-6] + g[value-4] + g[value-2])
    return g[n]

main()
