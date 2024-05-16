# Alberi
- Le liste doppie hanno due puntatori: quello che punta alla casella successiva e quello che punta alla casella precedente
- Negli alberi, anziché usare i due puntatori in questo modo, questi puntano al figlio destro e sinistro (e così ognuno a seguire)
- Questa strategia è scalabile, ogni elemento infatti può puntare fino a <i>n</i> figli
    - Dovrei definire a priori quanti saranno i massimi figli per ogni nodo, i puntatori possono essere nulli se non ci sono figli
    - In realtà posso costruire un albero con figli illimitati, aggiungendo un puntatore ad ogni nodo ad un fratello
- <b>Grafo</b>: coppia G=(V,E) dove V sono i vertici e E sono i collegamenti tra i vertici
    - Lato incidente: lato che arriva in un certo vertice
    - Cammino: sequenza di archi che partono da un vertice <i>i</i> e arrivano a <i>f</i>
    - Vertici connessi: esiste un cammino che li collega
        - Grafo connesso: ogni vertice è raggiungibile da ogni altro vertice (sia orientato che no)
    - Ciclo: cammino che parte da un nodo e arriva allo stesso nodo (e non passa per lo stesso lato)
- <b>Albero</b>: grafo senza cicli, connesso, non orientato
    - Posso <i>strattonare</i> un nodo per "girare" l'albero
- <b>Foresta</b>: insieme di alberi (aciclico, non orientato, <i>non conneso</i>)
- <b>Alberi binari</b>: albero in cui ogni cella ha esattamente tre campi (left, key, right), quindi <b>al massimo</b> due figli
    - In un albero binario solitamente i valori vengono distribuiti secondo una logica
    - Può essere utile avere un puntatore al genitore
    - Definito ricorsivamente: albero vuoto è binario, ogni nodo ha un albero binario a sinistra e un albero binario a destra
    - <b>Completo</b>: tutti i livelli contengono tutte le possibili foglie (ultimo livello vuoto)
    - Numero massimo di nodi di un albero di altezza h: 2^(h+1)-1

## Stampare numeri in un albero binario
``` python
def StampaNumeriRicorsivo(T: pointer):      # T è il puntatore al sottoalbero
    if T != None:
        print(T.key)
        StampaNumeriRicorsivo(T.left)
        StampaNumeriRicorsivo(T.right)
```

``` python
def StampaNumeriIterativo(T: Tree):
    if Root(t) == None:
        return
    Push(S, Root(t))
    while not StackEmpty(S):
        p = Pop(S)
        print(Key(p))
        if Right(p) != None:        # Devo stampare prima sottoalbero sinistra
            Push(S, Right(p))       # Quindi pusho prima il sottoalbero destra
        if Left(p) != None:
            Push(S, Left(p))

```
Usando lo stack, "simulo" la ricorsione: in questo tipo di algoritmi usare l'iterazione è più scomodo della ricorsione. Nello stack salvo il sottoalbero che devo stampare e, ad ogni iterazione, prendo quell'albero, lo stampo e aggiungo allo stack il sottoalbero sinistro e destro.

## Albero binario di ricerca
- In un albero binario, posso mettere a sinistra di un nodo i valori <= e a destra i valori >=
- Albero di ricerca: per ogni nodo, tutti gli elementi del sottoalbero sinistro sono più piccoli di lui, e tutti gli elementi del sottoalbero di destra sono più grandi di lui. Questo albero consente di cercare gli elementi al suo interno <i>rapidamente</i>: parto dalla radice; se il nodo è uguale al valore che cerco, l'ho trovato; altrimenti, cerca a sinistra o destra
- L'obiettivo dell'albero binario di ricerca è <b>ottimizzare</b> tutte le operazioni base delle strutture dati
    - Es: per aggiungere/cancellare un elemento (non cercare) in un array ordinato, il tempo richiesto è `n`; in una lista ordinata, il tempo richiesto è `Teta(1)`
- Ci sono tre tipologie di visite (sempre da sinistra verso destra), in cui cambia il punto in cui viene visitata la radice:
    - Anticipata: prima la radice, poi sottoalbero di sinistra, poi sottoalbero di destra
        - 100, 50, 70, 200, 150, 160, 170, 700
    - Simmetrica: prima sottoalbero sinistra, poi la radice, poi sottoalbero di destra
        - 1, 50, 70, 100, 150, 160, 170, 200, 700
    - Posticipata: prima sottoalbero sinistra, poi sottoalbero destra, poi radice
        - 1, 70, 50, 170, 160, 150, 700, 200, 100
    - Il tempo richiesto da una visita è `2n` => `Teta(n)`
```
     100         # Questo albero soddisfa la definizione!
   /    \
  50    200      # Quando arrivo alle foglie e non trovo il numero che sto cercando, 
 /  \   /  \     # i sottoalberi sono vuoti e quindi la ricerca è finita
1   70 150  700
         \
         160
           \
           170
```
- Nella visita simmetrica di un albero binario di ricerca gli elementi vengono stampati <b>in ordine</b>

### Visite in preordine, ordine, postordine
``` python
def VisitInPreorder(T: pointer):
    if T != None:
        print(Key(T))
        VisitInPreorder(Left(T))
        VisitInPreorder(Right(T))
```

``` python
def VisitInOrder(T: pointer):
    if T != None:
        VisitInPreorder(Left(T))
        print(Key(T))
        VisitInPreorder(Right(T))
```

``` python
def VisitInPostOrder(T: pointer):
    if T != None:
        VisitInPreorder(Left(T))
        VisitInPreorder(Right(T))
        print(Key(T))
```

### Costruire albero binario con 2, 3, 5, 5, 6, 7, 8
```
     5                  2
   /   \                 \
  3     7                 3
 / \   / \                 \
2   5 6   8                 5
                           / \
                          5   6
                               \
                                7
                                 \
                                  8
```

### Considerazione su altezza
- Posso fare tantissimi alberi per ogni altezza <i>n</i>
- Se ho <i>n</i> numeri, la massima altezza di un albero è <i>n-1</i>
    - Con altezza <i>n</i>, posso distribuire `2^(n-1)` nodi
    - Se ho <i>n</i> nodi, l'altezza massima è `log2(n)`
- Il tempo peggiore di ricerca per altezza <i>h</i> è `T(h) = h`, nel caso migliore `T(n) = log(n)`
- Per trovare il valore massimo, basta andare continuamente a destra: `log(n)`
- Successore di un nodo: minimo tra i più grandi, quindi vado nell'albero destra e poi tutto a sinistra

### Cerca chiave
``` python
pointer SBT_Search(x: pointer, k):
    if x == None:
        return None
    else:
        if k == Key(x):
            return x
        else:
            if k < Key(x):
                r = SBT_Search(Left(x), k)
            else:
                r = SBT_Search(Right(x), k)
            return r
```
- T(n) dove <i>n</i> è l'altezza dell'albero
    - 2c, n = 0
    - c + Tif1 + Tif2 + Fif1 * (2c + T(?)), ? = (n-1) oppure (n/2)

    - Caso migliore: Tif1 = 1, Fif1 = 0 => k è nella radice dell'albero
        - Tm(n) = 3c = Omega(1)
    - Caso peggiore: k non è nell'albero e per accorgermi devo percorrere il ramo più lungo (ad esempio più grande del più grande o più piccolo del più piccolo)
        - Tp(n) = 3c + T(n/2) = log(n)
    - Caso più peggiore: l'albero è una <b>lista</b> (albero con nodi in fila)
        - Tpp(n) = c + 0 + 2c + T(n-1) = 3cn = O(n)

### Cerca minimo
``` python
def SBT_min(T: pointer):
    Pa = Root(T)
    if Pa == None:
        return None
    else:
        while Left(Pa) != null:
            Pa = Left(Pa)
        return Pa
```
T(n) = Omega(1) e O(h)

### Cerca successore
N.B. se un nodo non ha albero destro, sopra di lui ci sono nodi più grandi
``` python
pointer SBT_Succ(x: pointer):
    if Right(x) != None:
        r = SBT_min(Right(x))
    else:
        Pa = Parent(x)
        while Key(Pa) < Key(x) and Pa != None:
            Pa = Parent(Pa)
        r = Pa
    return Pa
```
T(n) = O(h)

- 925, 202, 911, 240, 912: no, il 912 è più grande di 911

### Inserimento
``` python
def SBT_insert(T, x):
    Pa = Root(T)
    Pp = None
    if Pa == None:
        Root(T) = x
    while Pa != None:
        Pp = Pa
        if Key(Pa) < Key(x):
            Pa = Right(Pa)
        else:
            Pa = Left(Pa)
    if Key(Pp) < Key(x):
        Right(Pp) = x
    else:
        Left(Pp) = x
    Parent(x) = Pp
```

T(h) = O(h)

### Cancellazione
1. Il nodo è una foglia: basta rimuovere il collegamento con il parent
2. Il nodo ha un solo figlio: sotto ci può essere tanta roba, quindi devo collegare i noti sotto con il parent del nodo eliminato => devo fare contrazione, cioè collegare il parent del nodo rimosso con il figlio (tempo costante)
3. Il nodo ha due figli: è un casino, sostituisco il nodo con il suo predecessore/successore