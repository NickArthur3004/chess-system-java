package TabuleiroGame;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Peça[][] peças;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro criando o tabuleiro: É preciso ter uma linha e uma coluna");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		peças = new Peça [linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
	
	public Peça peça(int linha, int coluna) {
		if(!PosicaoExistente(linha, coluna)) {
			throw new TabuleiroException("Essa Posição ñ existe no tabuleiro");
		}
		return peças[linha][coluna];
	}
	
	public Peça peça(Posicao posicao) {
		if(!PosicaoExistente(posicao)) {
			throw new TabuleiroException("Essa Posição ñ existe no tabuleiro");
		}
		return peças[posicao.getLinha()][posicao.getColuna()];
	}
	 public void placePeça(Peça peça,Posicao posicao) {
		 if(thereIsAPeça(posicao)) {
			 throw new TabuleiroException("Ja existe uma peça nessa posição");
		 }
		 peças[posicao.getLinha()][posicao.getColuna()] = peça;
		 peça.posicao = posicao;
	 }
	 
     private boolean PosicaoExistente(int linha,int coluna) {
		 return linha >=0 && linha < linhas && coluna >=0 && coluna < colunas;
	 }
	 
	 public boolean PosicaoExistente(Posicao posicao) {
		 return PosicaoExistente(posicao.getLinha(), posicao.getColuna());
	 }
	

	 public boolean thereIsAPeça(Posicao posicao) {
		 if(!PosicaoExistente(posicao)) {
				throw new TabuleiroException("Essa Posição ñ existe no tabuleiro");
			}
		return peça(posicao) != null;
	 }
}
