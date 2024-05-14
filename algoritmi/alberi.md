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
