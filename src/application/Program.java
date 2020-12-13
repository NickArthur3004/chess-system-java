package application;

import java.util.Scanner;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPartida;
import chess.ChessPeša;
import chess.ChessPosišao;

public class Program {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		ChessPartida chessPartida = new ChessPartida();
		
		while(true) {
		UI.printTabuleiro(chessPartida.getPešas());
		System.out.println();
		System.out.print("Origem: ");
		ChessPosišao source = UI.lerChessPosišao(sc);
		
		System.out.println();
		System.out.print("destino: ");
		ChessPosišao target = UI.lerChessPosišao(sc);
		
		ChessPeša capturarPeša = chessPartida.performChessMove(source, target);
		}
	}

}
