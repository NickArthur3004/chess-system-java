package application;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPartida;

public class Program {

	public static void main(String[] args) {
		 
		ChessPartida chessPartida = new ChessPartida();
		UI.printTabuleiro(chessPartida.getPeças());

	}

}
