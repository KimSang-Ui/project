package travelog;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DB db = new DB();
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("  ████████╗██████╗  █████╗ ██╗   ██╗███████╗██╗      ██████╗  ██████╗ \r\n"
				+ "  ╚══██╔══╝██╔══██╗██╔══██╗██║   ██║██╔════╝██║     ██╔═══██╗██╔════╝ \r\n"
				+ "     ██║   ██████╔╝███████║██║   ██║█████╗  ██║     ██║   ██║██║  ███╗\r\n"
				+ "     ██║   ██╔══██╗██╔══██║╚██╗ ██╔╝██╔══╝  ██║     ██║   ██║██║   ██║\r\n"
				+ "     ██║   ██║  ██║██║  ██║ ╚████╔╝ ███████╗███████╗╚██████╔╝╚██████╔╝\r\n"
				+ "     ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚══════╝ ╚═════╝  ╚═════╝ \r\n"
				+ "                                                                      ");

		ConsoleBoard.main(args);

	}
}
