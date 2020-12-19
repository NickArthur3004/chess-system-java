package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessPartida;
import chess.ChessPe�a;
import chess.ChessPosi�ao;
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
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\0018[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u0018[46m";
	public static final String ANSI_HITE_BACKGROUND = "\u0018[47m";
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
	 System.out.print("\033[H\033[2J");
	 System.out.flush();
	}
	
	public static ChessPosi�ao lerChessPosi�ao(Scanner sc) {
		try {
		String s = sc.nextLine();
		char coluna = s.charAt(0);
		int linha = Integer.parseInt(s.substring(1));
		return new ChessPosi�ao(coluna, linha);
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro lendo posi��o de xadres: valores validos s�o de a1 at� h8.");
		}
	}
	
	public static void printPartida(ChessPartida chessPartida, List<ChessPe�a> captura) {
		printTabuleiro(chessPartida.getPe�as());
		printPe�aCapturada(captura);
		System.out.println();
		System.out.println("Turno: "+chessPartida.getTurno());
		System.out.println("Esperando Jogador: "+ chessPartida.getCurrentPlayer());
		if(chessPartida.getCheck()) {
			System.out.println("CHECK!");
		}
	}

	public static void printTabuleiro(ChessPe�a[][] pe�as) {
		for (int i = 0; i < pe�as.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pe�as.length; j++) {
				printPe�a(pe�as[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printTabuleiro(ChessPe�a[][] pe�as, boolean[][] possibleMoves) {
		for (int i = 0; i < pe�as.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pe�as.length; j++) {
				printPe�a(pe�as[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	public static void printPe�a(ChessPe�a pe�a, boolean background) {
		if(background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (pe�a == null) {
			System.out.print("-"+ ANSI_RESET);
		} else {
			if (pe�a.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + pe�a + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + pe�a + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
	
	private static void printPe�aCapturada(List<ChessPe�a> captura) {
		List<ChessPe�a> white = captura.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPe�a> black = captura.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println();
		System.out.println("Pecas capturadas: ");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
		
	}
}
