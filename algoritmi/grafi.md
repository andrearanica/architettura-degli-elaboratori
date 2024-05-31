# BFS: visita di un grafo in ampiezza
- Abbiamo bisogno di un grafo (vertici e nodi) e un nodo sorgente
- Un grafo è rappresentato dalla matrice di adiacenza (o dalla lista di adiacenza)

- Nodi bianchi: nodi non passati
``` python
def BFS(G, S):
    for i=1 to |V|:
        c[Vi] = w           # Setto il colore del nodo a bianco
        d[Vi] = -1          # Setto la distanza dal vertice S (infinito, esempio -1)
        p[Vi] = None        # Setto il predecessore del cammino dal nodo a S
        c[s] = g            # Sorgente diventa grigio
        d[s] = 0            # La distanza della sorgente da sé stessa è 0
        p[s] = 0            # La sorgente non ha predecessore
    
    Enqueue(Q, s)
    while not(QueueEmpty(Q)):
        U = Dequeue(Q)
        c[U] = B                        # Il colore del nodo è nero
        foreach V in Adj[u]:            # Per ogni nodo della lista di adiacenza di U
            if c[V] == B:               # Aggiungo il nodo <=> è bianco altrimenti vengono duplicati
                c[V] = G                # Lo coloro di grigio
                d[V] = d[U]+1           # La distanza è aumentata di 1
                p[V] = U                # Il parent è U
                Enqueue(Q, V)
```
## Calcolo dei tempi
- Primo ciclo: `T(n) = |V|`
- Secondo ciclo
    - Caso migliore: il nodo sorgente è scollegato dal resto => `T(n) = n`
    - Caso peggiore: il grafo è connesso, quindi tutti i nodi vanno a finire nella coda (non ci sono nodi isolati, dalla sorgente posso raggiungere in almeno un modo tutti i nodi) => `T(n) = O(|V|+|E|)` tempo generico per ogni input
    - Caso più peggiore: grafo completo => `T(n) = O(n^2)`

# DFS: visita di un grafo in profondità
- E' necessario uno stack
- Per ogni elemento abbiamo il tempo di scoperta d[v] e un tempo di fine visita f[v]
- Ci sono diversi tipi di archi durante la visita
    - Tree: arco che crea un albero di visita (fa scoprire nodo non ancora visitato)
    - Back: arco che va ad un nodo che è già stato visitato (grigio)
    - Cross: arco che va ad un nodo che è già stato visitato e concluso (nero)
- N.B. in un grafo non ordinato non posso avere archi cross
- Con questo tipo di visita ottengo un ordinamento che rispetta i vincoli del grafo! Stra comodo tipo se ho l'ordine di come vestirmi
    - C'è libertà di scelta sui nodi da cui partire

``` python
def DFS(G):
    time = 0                # Per tempo di scoperta
    foreach v in V:
        p[v] = None         # Predecessore di ogni nodo None
        c[v] = W            # Colore di ogni nodo inizialmente bianco
    foreach v in V:
        if c[v] == W:
            DSF_visit(G, V)

def DFS_visit(G, U):
    time += 1           # Time è globale
    d[u] = time
    c[u] = G            # Colore del vertice grigio
    foreach z in Adj[u]:
        if c[z] == B:
            p[z] = u
            DFS_visit(G, z)
    c[u] = B
    time += 1
    f[u] = time
```

## Analisi dei tempi
- `T(n) = O(|V|+|E|)`

## Proprietà
- Teorema delle parentesi: se faccio una visita DFS non accade mai che due vertici siano accavallati
    - Due vertici V e W che hanno tempi di inizio e di fine "staccati" (es 1-5 e 40-80) appartengono a due componenti connesse <b>staccate</b>
    - Come conto componenti connesse? Metto un contatore quando chiamo da DFS la DFS_visit