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
N.B. Per cancellazione si intende voler cancellare il nodo di cui viene dato il <b>puntatore</b> (non il valore)
1. Il nodo è una foglia:
    - Rimuovo il collegamento con il padre (rimuovo il puntatore)
    - Mettere a null l'elemento per liberare memoria
2. Il nodo ha un solo figlio: ha un sottoalbero sinistro (valori più piccoli di lui) o destro (valori più grandi di lui)
    - I nodi che stanno al di sotto del nodo da rimuovere non devono essere cambiati, devo solo sostituire quel nodo collegando il padre del nodo da rimuovere con il figlio del nodo da rimuovere
3. Il nodo ha due figli: non posso collegare i figli direttamente al padre, perché il padre avrebbe tre figli (non va bene, l'albero deve essere binario di ricerca!)
    - Al posto del nodo da rimuovere metto un nuovo nodo (che mantiene le stesse proprietà) => successore o predecessore
    - Il successore è il più piccolo dei nodi del sottoalbero destro del nodo da rimuovere, il predecessore è invece il massimo dei nodi del sottoalbero sinistro
    - Il procedimento è: 
        a. Cerco il nodo che non ha figli sinistri (nel sottoalbero sinistro o destro, in base a se voglio avere il sucessore o il predecessore)
        b. Scambio il valore trovato con quello da eliminare
        c. Cancello il nodo che è diventato figlio (contrazione)

``` python
def SBT_Delete(x: pointer):                 # Non mi serve il puntatore all'albero
    if x.left == None and x.right == None:
        # Il nodo da rimuovere è una foglia
        p = x.parent
        if (x.key < p.key):
            p.left = None
        else:
            p.right = None
        free(x)                             # Libero la memoria occupata dal nodo
        x = None
    else if x.left == None or x.righe == None:
        # Il nodo ha un solo figlio
        if x.parent.left == x:
            # Il nodo da eliminare è nel sottoalbero sinistro
            if x.left != None:
                # E' figlio sinistro e ha un figlio sinistro
                x.parent.left = x.left
                x.parent.left.parent = x.parent
            else:
                x.parent.left = x.right
                x.parent.left.parent = x.parent
        else:
            # Il nodo da eliminare è nel sottoalbero destro
            if x.left != None:
                # E' figlio sinistro e ha un figlio sinistro
                x.parent.right = x.left
                x.parent.right.parent = x.parent
            else:
                x.parent.right = x.right
                x.parent.right.parent = x.parent
        free(x)
        x = None
    else:
        # Il nodo ha due figli
        p = SBT_Succ(x)
        x.key = p.key
        SBT_Delete(p)
```
- T(n) = O(h) => se bilanciato T(n) = O(logn)
- N.B. inserendo o cancellando un nodo in un albero si sta sbilanciando: ci sono algoritmi che bilanciano gli alberi (es. rotazione) che fanno rimanere il tempo logn

### Inserimento
``` python
def SBT_Insert(T, x):
    if x == None:
        return
    p1 = Root[t]
    p2 = None
    while p1 != None:
        p2 = p1
        if key(x) <= key(p1):
            p1 = left(p1)
    if x <= x.parent.left:
        p2.left = x
    else:
        p2.right = x
    x.parent = p2
```

T(n) = 4c + 4Twi
- Caso migliore: i nodi sono tutti a sinistra, ma io voglio inserirlo a destra: Tm(n) = Omega(1)
- Caso peggiore: scendo fino all'ultimo livello: Tp(n) = 4c + 4ch = O(h) (se è bilanciato, h=logn) => tempo logaritmico

### Costruire albero
- Dati i numeri 10, 75, 30, 42, 47, 81, 31, 76, 53 mostrare cosa succede nel costruire un albero binario di ricerca


                10   ->       10      ->   10     ->   10  ->  [...] ->      10       -> [...]
                             /  \            \        /  \                    \
                                75           75          75                   75                                               \              \         /                  /    \
                                               30       30                  30    81
                                                                              \
                                                                              42
                                                                               \
                                                                               47

### Esercizio ricerca divide et impera
- Si consideri un albero binario che contiene valori interi; si considerino due valori n1 e n2
- Scrivere una procedura di tipo divide et impera che conta quanti elementi dell'albero binario sono compresi tra n1 e n2
- Controllo se la radice è compresa; il risutato è radice compresa + n_sinistra + n_destra

``` python
def Conta(x: pointer, n1: int, n2: int) -> int:
    if x == None:
        return 0
    else:
        r = 0
        if x.key >= n1 and x.key <= n2:
            r += 1
        r1 = Conta(x.left, n1, n2)
        r2 = Conta(x.right, n1, n2)
        return r + r1 + r2
```

T(n) se l'albero è sbilanciato tutto a sinistra/destra
    - 2c se n=0
    - 5c + T(n-1) T(0) 

T(n) se l'albero è bilanciato
    - 2x se n=0
    - 5c + T(n/2)

- Nel caso di albero binario di ricerca, posso ignorare i valori a sinistra o destra se la radice è più piccola di n1 o più grande di n2 (migliora solo il caso migliore e medio)

### Eliminare occorrenze di un valore da ABR
- Struttura dell'albero: il minore uguale è a sinistra, la delete prende il predecessore
    - Individuo il nodo da cancellare, cancello, controllo se il nodo nuovo ha la stessa chiave (e lo cancello)

``` python
def ABR_del(Root[t], k: int):
    p = SBT_search(Root[t], k)
    while p != None and p.key == k:
        if p.left == None and p.right == None:
            # Il nodo da cancellare è una foglia
            SBT_delete(p)
            p = None
        else:
            SBT_delete(p)
            p = SBT_search(p, k)
        SBT_delete(p)
```

### Stampare chiavi in modo ordinato
- Array ordinato

``` python
def Union(T: pointer, V: list):
    Pt = SBT_min(T)
    Iv = 1;
    while Pt != None and Iv <= length(V):
        if Pt.key <= V[Iv]:
            print(Pt.key)
            Pt = SBT_successor(Pt)
        else:
            print(V[Iv])
            Iv += 1
    while Pt != None:
        print(Pt.key)
        Pt = SBT_successor(Pt)
    while Iv <= length(V):
        print(V[Iv])
        Iv += 1
```
T(n) = Teta(nlogn)