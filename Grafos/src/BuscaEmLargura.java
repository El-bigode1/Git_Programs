
public class BuscaEmLargura {
	
	int V = 105; // apenas um exemplo
	int[] Q = new int[V];
	String[] cor = new String[V];
	int[] pais = new int[V];
	int[] dist = new int[V];

	//numero de passos pra sair de um vertice e chegar em outro
	// normalmente, pede o menor numero de saltos (enquanto nao usar custo)
	
	//a diferenca, eh que a largura vai em passos
	//vc percorre todos os vizinhos de primeiro grau
	//depois todos de segundo grau...
	//como se fosse uma onda
	
	//acho que aqui, voce pararia assim que chegasse no objetivo
	//o bom eh que vc intuitivamente, ja achou o menor caminho
	//ex1: se a ideia for descobrir quantos componentes existem
	
	//busca em largura generico
	//inicializacao
	public void inicializing(int V) {
		for(int v=1; v < V; v++) {
			// branco, cinza, preto
			// nao buscamos, em andamento, terminado
			cor[v] = "branco";
			//pais = de onde veio, comeca vazio
			pais[v]= 0;
			//distancia = infinita, antes de vc checar
			dist[v] = (int) Integer.MAX_VALUE;
		}
	}
	
	//Busca em profundidade
	// s == start
	public void BFS(int s) {
		cor[s] = "cinza";
		dist[s] = 0;
		//FIni == inicio da fila, muda as vezes
		int FIni = 0;
		int FFim = 0;
		//Q eh um vetor com todas as celulas
		// na real que Q ja parece ser a fila, acho
		// ctz, eh uma fila 
		Q[FIni] = s;
		//FFim == fim da fila, ou, onde voce esta no momento
		FFim++;
		while(FIni<FFim) {
			int u = Q[FIni];
			FIni++;
			// POS u eh o vetor que guarda quantas relacoes de primeiro grau
			// existem entre aquele elemento e outros
			for (int i = 0; i < POS[u]; i++) {
				// ADJ == Lista de Adjacencia, 
				// poderia ser uma matriz tbm, mas mudaria bastante coisa;
				// por causa disso, a fila nao fica exatamente como o caminho
				// se 4 esta relacionado, com 3
				// 3 esta relacionaco com 5, com 6, com 7;
				// nesse momento a fila estaria: 4-3-5-6-7; mesmo que 5 6 7 nao tem relacao entre si
				int v= ADJ[u,i];
				// se a cor for preto ou cinza, nao faz nada
				if(cor[v] == "branco") {
					cor[v] = "cinza";
					dist[v] = d[u] + 1;
					pai[v] = u;
					Q[FFim] = v;
					FFim+;
				}
			}
			cor[u] = "preto";
		}
	}
	
}
