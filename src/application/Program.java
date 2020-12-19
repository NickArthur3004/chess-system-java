package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessException;
import chess.ChessPartida;
import chess.ChessPeša;
import chess.ChessPosišao;

public class Program {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		ChessPartida chessPartida = new ChessPartida();
		List<ChessPeša> captura = new ArrayList<>();
		
		while(true) {
			try {
		UI.clearScreen();
		UI.printPartida(chessPartida, captura);
		System.out.println();
		System.out.print("Origem: ");
		ChessPosišao source = UI.lerChessPosišao(sc);
		
		boolean[][] possibleMoves = chessPartida.possibleMoves(source);
		UI.clearScreen();
		UI.printTabuleiro(chessPartida.getPešas(), possibleMoves);
		
		System.out.println();
		System.out.print("destino: ");
		ChessPosišao target = UI.lerChessPosišao(sc);
		
		ChessPeša capturarPeša = chessPartida.performChessMove(source, target);
		
		if(capturarPeša != null) {
			captura.add(capturarPeša);
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
	}

}
