package TabuleiroGame;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Pe�a[][] pe�as;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro criando o tabuleiro: � preciso ter uma linha e uma coluna");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		pe�as = new Pe�a [linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
	
	public Pe�a pe�a(int linha, int coluna) {
		if(!PosicaoExistente(linha, coluna)) {
			throw new TabuleiroException("Essa Posi��o � existe no tabuleiro");
		}
		return pe�as[linha][coluna];
	}
	
	public Pe�a pe�a(Posicao posicao) {
		if(!PosicaoExistente(posicao)) {
			throw new TabuleiroException("Essa Posi��o � existe no tabuleiro");
		}
		return pe�as[posicao.getLinha()][posicao.getColuna()];
	}
	 public void placePe�a(Pe�a pe�a,Posicao posicao) {
		 if(thereIsAPe�a(posicao)) {
			 throw new TabuleiroException("Ja existe uma pe�a nessa posi��o");
		 }
		 pe�as[posicao.getLinha()][posicao.getColuna()] = pe�a;
		 pe�a.posicao = posicao;
	 }
	 
     private boolean PosicaoExistente(int linha,int coluna) {
		 return linha >=0 && linha < linhas && coluna >=0 && coluna < colunas;
	 }
	 
	 public boolean PosicaoExistente(Posicao posicao) {
		 return PosicaoExistente(posicao.getLinha(), posicao.getColuna());
	 }
	

	 public boolean thereIsAPe�a(Posicao posicao) {
		 if(!PosicaoExistente(posicao)) {
				throw new TabuleiroException("Essa Posi��o � existe no tabuleiro");
			}
		return pe�a(posicao) != null;
	 }
}
