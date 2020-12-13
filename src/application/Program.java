package application;

import java.util.Scanner;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPartida;
import chess.ChessPeça;
import chess.ChessPosiçao;

public class Program {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		ChessPartida chessPartida = new ChessPartida();
		
		while(true) {
		UI.printTabuleiro(chessPartida.getPeças());
		System.out.println();
		System.out.print("Origem: ");
		ChessPosiçao source = UI.lerChessPosiçao(sc);
		
		System.out.println();
		System.out.print("destino: ");
		ChessPosiçao target = UI.lerChessPosiçao(sc);
		
		ChessPeça capturarPeça = chessPartida.performChessMove(source, target);
		}
	}

}
