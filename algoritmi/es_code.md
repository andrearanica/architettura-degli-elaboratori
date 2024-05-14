# Esercizi su code

## Estrarre un elemento in base al suo indice
``` python
Extract(Q, K) {
    Enqueue(Q, -1)
    c = 1
    do:
        R = Dequeue(Q)
        if R != -1 and c != k:
            Enqueue(Q, R)
        c++
    while (c <= k AND R != -1)
    if R == -1:
        error("Underflow")
    else:
        do:
            R2 = Dequeue(R)
            if R2 != -1:
                Enqueue(R, Q2)
        while R2 != -1
    return R
}
```

Tempi: Tw1 + Tw2 = n => Teta(n)

## Eliminare un elemento da una coda
``` python
Del(Q, A):
    c = 0
    while not QueueEmpty(Q):
        R = Dequeue(Q)
        if R != A:
            Enqueue(Qa, R)          # Qa è la coda di appoggio, che contiene tutti gli elementi tranne A
    while not QueueEmpty(Qa):
        R = Dequeue(Qa)
        Enqueue(A, R)
```

Tempi:
    - Caso peggiore: A non appartiene a Q => Tw1 = Tw2 = n => T(n) = 7n = O(n)
    - Caso migliore: Q contiene solo elementi = A => Tw1 = n, Tw2 = 0 => T(n) = 4n = Omega(N)
    - T(n) = Teta(n)

## Inverti stringa (usando una coda)
Aggiungo un elemento e metto in coda gli altri: richiede molto temo, meglio usare uno stack!

## Ricevuti una coda e uno stack (con elementi univoci) eliminare dalla coda gli elementi che compaiono anche nello stack
Q = [1, 2, 3, 2, 1, 2, 5, 6]
S = [1, 2, 6]

``` python
Elimina(Q, S):
    while not StackEmpty(S):
        R = Pop(S)
        Del(Q, R)
        Push(Sa, R)
    while not StackEmpty(Sa):       # Ripristino lo stack
        R = Pop(Sa)
        Push(S, R)

m = len(S), n = len(Q)
```
- Caso peggiore: m * Teta(n)
- Caso migliore: la coda ha tutti elementi uguali, e lo stack ha quell'elemento nella prima posizione
