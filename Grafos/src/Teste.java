
public class Teste {
	//uso de fila pra fazer uma busca e largura a partir de um grafo
	// ter as relacoes de todos a partir da busca em largura
	
	int V = 105; // um exemplo apenas
	
	String[] cor = new String[V];
	int[] pais = new int[V];
	int[] dist = new int[V];
	
	
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
}
