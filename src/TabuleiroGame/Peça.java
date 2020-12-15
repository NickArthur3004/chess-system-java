package TabuleiroGame;

public abstract class Peça {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	
	public Peça(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}


	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Posicao posicao) {
		return possibleMoves()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean IsThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length;i++) {
			for(int j = 0; j<mat.length; i++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	
	
	
	
	
}
