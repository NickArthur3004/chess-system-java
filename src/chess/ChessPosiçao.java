package chess;

import TabuleiroGame.Posicao;

public class ChessPosi�ao{
	
	private char coluna;
	private int linha;
	
	public ChessPosi�ao(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new ChessException("Erro instanciando ChessPosicao.Valores validos s�o de a1 at� h8");
		}
		
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	protected Posicao toPosi�ao() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static ChessPosi�ao fromPosi�ao(Posicao posicao) {
		return new ChessPosi�ao((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	
}
