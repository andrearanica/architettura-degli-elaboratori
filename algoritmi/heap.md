# Heap
- L'heap (coda con priorità) è un <b>array</b> visto come albero binario quasi completo
    - Riempito per tutti i livelli tranne eventualmente l'ultimo, che può essere riempito da sinistra a destra
    - es. [A, B, C, D, E, F, G, H]
    ```
           1
         /   \
        2     3
       / \   / \
      4   5 6   7
     /
    8
    ```
- Attributi
    - `length(v)`
    - `heapsize(v)` <= `length(v)`
    - Elementi nello heap <i>v</i>: da 1 a `heapsize(v)`
    - parent(i) = i DIV 2 (approssimata per difetto)
    - left(i) = i * 2 (usa lo shift che è molto veloce!)
    - right(i) = i * 2 + 1
    - I valori vengono distribuiti in modo che V[Parent(i)] >= V[i]
        - In ogni nodo c'è sempre un valore più grande dei due figli
        - Il massimo dello heap è la <b>radice</b>
    - Il minimo si trova nella seconda metà dell'array (velocità di ricerca non cambia molto)
        - E' molto più veloce cercare il massimo, per questo si sfrutta questa struttura
    - Un heap è alto `logn` dove <i>n</i> è il numero di elementi

- Quando mi serve in fretta trovare il massimo? Stampanti, processi...

## Heapify: funzione per riordinare uno heap
- La heapify funziona <=> la posizione in cui viene chiamata prevede che a sinistra e sinitra ci siano già due heap
    - Posso lanciarla su 4 non su 16
    - Scambia l'elemento passato con l'elemento più grande nei suoi sottoalberi; se c'è stato uno scambio, rilancia sé stessa dove ha fatto lo scambio
- Caso peggiore: il primo elemento è il più piccolo dello heap (come zero)
```
           16
        /      \
       4         10
     /   \      /  \
   14     7    9    3
  / \    /
 2   8  1

heapify(V, 2)           # Scambia 4 con 14
    heapify(V, 4)       # Rilancia dalla posizione 4 (dove c'era il 14) e scambia 8 con 4
        heapify(V, 9)   # Rilancia dalla posizione 9
```
``` python
def heapify(V: list, i: int):
    l = i*2
    r = i*2+1
    m = i
    if l <= heapsize(v) and v[l] > v[m]:
        m = l
    if r <= heapsize(v) and v[r] > v[m]:
        m = r
    # In m ho il valore massimo tra la radice e il nodo sinistro e destro
    if m != i:
        App = v[i]
        v[i] = v[m]
        v[m] = App
```
- Caso peggiore: T(n) = 11c + T(2/3 n)
    - f(n) = Teta(1)
    - n^(logb(a)) = n^(log(3/2)(1)) = Teta(1) => T(n) = O(logn)

## Build heap: costruire uno heap da un array disordinato
``` python
def BuildHeap(v):
    v.heapsize = v.length
    # N foglie = n / 2 per eccesso
    # N non foglie = n DIV 2
    for i=(v.heapsize DIV 2) downto 1:
        heapify(v, i)
```