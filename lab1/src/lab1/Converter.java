package lab1;
import java.util.Scanner;

public class Converter {

	private final static String Info = "Transforma números em sua forma escrita";
	private final static String Info2 = "Digite o número: ";

	public static void main(String[] args) {
		System.out.println(Info);
		run();
		System.out.println("Encerrada");
	}

	private static void run() {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		NumberSystem system = new NumberSystem();
		do {
			System.out.print(Info2);
			try {
				String userInput = sc.next();
				if (userInput.equals("parar")) {
					break;
				}
				System.out.println(system.getResposta(Integer.valueOf(userInput)));
			} catch (Invalid e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Valor inválido.");
			}
		} while (run);
		sc.close();
	}
}