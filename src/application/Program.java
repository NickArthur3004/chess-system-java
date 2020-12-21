package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<ChessPe�a> captura = new ArrayList<>();
		
		while(!chessPartida.getCheckMate()) {
			try {
		UI.clearScreen();
		UI.printPartida(chessPartida, captura);
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
		
		if(capturarPe�a != null) {
			captura.add(capturarPe�a);
		}
		
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printPartida(chessPartida, captura);
	}

}
