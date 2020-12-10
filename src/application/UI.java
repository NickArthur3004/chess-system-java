package application;

import chess.ChessPe�a;
import chess.Color;

public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-printin

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u0018[30m";
	public static final String ANSI_RED = "\u0018[31m";
	public static final String ANSI_GREEN = "\u0018[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u0018[34m";
	public static final String ANSI_PURPLE = "\u0018[35m";
	public static final String ANSI_CYAN = "\u8818[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK_BACKGROUND = "\u0018[40m";
	public static final String AlSI_RED_BACKGROUND = "\u0018[41m";
	public static final String ANSI_GREEN_BACKKGROUND = "\u0018[42m";
	public static final String ANSI_VELLON_BACKGROUND = "\u0018[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u0018[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\0018[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u0018[46m";
	public static final String ANSI_HITE_BACKGROUND = "\u0018[47m";

	public static void printTabuleiro(ChessPe�a[][] pe�as) {
		for (int i = 0; i < pe�as.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pe�as.length; j++) {
				printPe�a(pe�as[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	public static void printPe�a(ChessPe�a pe�a) {
		if (pe�a == null) {
			System.out.print("-");
		} else {
			if (pe�a.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + pe�a + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + pe�a + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
}
