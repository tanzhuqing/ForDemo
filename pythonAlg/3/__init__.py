def is_prime(n):
    for i in range(2,n):
        if n%2 == 0:return False
    return True

def S(seq,i=0):
    if i == len(seq):return 0
    return S(seq, i+1)+seq[i]

def T(seq,i=0):
    if i == len(seq):return 1
    return T(seq,i+1)+1

seq=range(1,101)
print S(seq)
print T(seq)