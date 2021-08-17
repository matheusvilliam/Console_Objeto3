import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static int grilosPorGrupo;
	static int position, timeVencedor;
	static int somaPulosGrupo1, somaPulosGrupo2;
	static int somaDistanciaGrupo1, somaDistanciaGrupo2;
	static int linhaDeChegada;
	
	public static Semaphore semaphore = new Semaphore(1);
	
	public static void main(String[] args) {
		
		System.out.println("Quantidade de Grilos por Time: ");
		grilosPorGrupo = scan.nextInt();
		
		System.out.println("Distância da Linha de Chegada: ");
		linhaDeChegada = scan.nextInt();

		for (int i=0; i<grilosPorGrupo; i++) {

			Grilos grupo1 = new Grilos("Grilo_"+ i, 1, linhaDeChegada);
			Grilos grupo2 = new Grilos("Grilo_"+ (grilosPorGrupo + i), 2, linhaDeChegada);
		}
	}
	
	public static void positions() {
		
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		position++;
		
		semaphore.release();
	}

}
