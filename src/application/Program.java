package application;

import java.util.Scanner;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPartida;
import chess.ChessPe�a;
import chess.ChessPosi�ao;

public class Program {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		ChessPartida chessPartida = new ChessPartida();
		
		while(true) {
		UI.printTabuleiro(chessPartida.getPe�as());
		System.out.println();
		System.out.print("Origem: ");
		ChessPosi�ao source = UI.lerChessPosi�ao(sc);
		
		System.out.println();
		System.out.print("destino: ");
		ChessPosi�ao target = UI.lerChessPosi�ao(sc);
		
		ChessPe�a capturarPe�a = chessPartida.performChessMove(source, target);
		}
	}

}
