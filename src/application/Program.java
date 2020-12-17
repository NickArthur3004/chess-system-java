package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessException;
import chess.ChessPartida;
import chess.ChessPeça;
import chess.ChessPosiçao;

public class Program {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		ChessPartida chessPartida = new ChessPartida();
		
		while(true) {
			try {
		UI.clearScreen();
		UI.printPartida(chessPartida);;
		System.out.println();
		System.out.print("Origem: ");
		ChessPosiçao source = UI.lerChessPosiçao(sc);
		
		boolean[][] possibleMoves = chessPartida.possibleMoves(source);
		UI.clearScreen();
		UI.printTabuleiro(chessPartida.getPeças(), possibleMoves);
		
		System.out.println();
		System.out.print("destino: ");
		ChessPosiçao target = UI.lerChessPosiçao(sc);
		
		ChessPeça capturarPeça = chessPartida.performChessMove(source, target);
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
