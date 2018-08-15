
public class BuscaEmProfundidade {
	//tambem eh busca, mas usa recursividade, pra saber a ordem do que ta acontecendo
	// se eh recursivo, rola fazer uma pilha, maspode nao ser necessario
	
	// t == tempo (nao necessariamente distancia)
	int t = 0;
	// V == tamanho do grafo
	int V = 105;
	
	//S guarda os tempos de inicio
	int S[] = new int[V];
	//F guarda os tempos de fechamento
	int F[] = new int[V];
	int nivel[] = new int[V];
	
	String[] cor = new String[V];
	int[] pais = new int[V];
	int[] dist = new int[V];
	
	public void Initializing () {
		for (int v = 1; v < V; v++) {
			cor[v] = "branco";
			// a ideia eh ninguem, e null nao fica legal (acho)
			pais[v] = 0;
			S[v] = Integer.MAX_VALUE;
			F[v] = Integer.MAX_VALUE;
			nivel[v] = Integer.MAX_VALUE;
					
		}
		
		for (int u = 0; u < V; u++) {
			if (cor[u] == "branco") {
				DFS_Visit(u, 0);
			}
			
		}
	}
	
	public void DFS_Visit(int u, int nivel) {
		cor[u] = "cinza";
		nivel[u] = nivel;
		t++;
		S[u] = t;
		// POS u eh o vetor que guarda quantas relacoes de primeiro grau
		// existem entre aquele elemento e outros
		for (int i = 0; i < POS[u]; i++) {
			//ADJ == lista de adjacencia
			int v = ADJ[u, i];
			if(cor[v] == "branco") {
				pais[v] = u;
				DFS_Visit(v, nivel+1);
			}
		}
		cor[u] = "preto";
		t++;
		F[u] = t;
	}
	
	
}
