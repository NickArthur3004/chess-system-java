package application;

import chess.ChessPeça;

public class UI {

	public static void printTabuleiro(ChessPeça[][] peças) {
		for(int i = 0;i<peças.length;i++) {
			System.out.print((8 - i)+" ");
			for(int j = 0;j<peças.length;j++) {
				printPeça(peças[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printPeça(ChessPeça peça) {
		if(peça == null) {
			System.out.print("-");
		}else {
			System.out.print(peça);
		}
		System.out.print(" ");
	}
}
