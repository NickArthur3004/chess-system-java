package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessException;
import chess.ChessPartida;
import chess.ChessPe�a;
import chess.ChessPosi�ao;

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
		ChessPosi�ao source = UI.lerChessPosi�ao(sc);
		
		boolean[][] possibleMoves = chessPartida.possibleMoves(source);
		UI.clearScreen();
		UI.printTabuleiro(chessPartida.getPe�as(), possibleMoves);
		
		System.out.println();
		System.out.print("destino: ");
		ChessPosi�ao target = UI.lerChessPosi�ao(sc);
		
		ChessPe�a capturarPe�a = chessPartida.performChessMove(source, target);
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
