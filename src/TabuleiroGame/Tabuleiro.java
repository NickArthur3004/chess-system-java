package TabuleiroGame;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Pe�a[][] pe�as;
	
	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pe�as = new Pe�a [linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	public Pe�a pe�a(int linhas, int colunas) {
		return pe�as[linhas][colunas];
	}
	
	public Pe�a pe�a(Posicao posicao) {
		return pe�as[posicao.getLinha()][posicao.getColuna()];
	}
	 public void placePe�a(Pe�a pe�a,Posicao posicao) {
		 pe�as[posicao.getLinha()][posicao.getColuna()] = pe�a;
		 pe�a.posicao = posicao;
	 }
	

}
