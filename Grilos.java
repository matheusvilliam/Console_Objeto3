
public class Grilos  extends Thread{

	private String nome;
	float pulo, distanciaPercorrida;
	int grupo, qtdPulos, distanciaTotal;
	
	public Grilos (String nome, int grupo, int distanciaTotal) {
		this.nome=nome;
		this.grupo=grupo;
		this.distanciaTotal=distanciaTotal;
		start();
	}
	
	public void run() {
		
		while (distanciaPercorrida < distanciaTotal) {
			
			try {
				
					pulo = Math.round(Math.random() * 50);
					distanciaPercorrida += pulo;
					qtdPulos++;
					System.out.println(nome + " pulou " + pulo + "cm e já percorreu " + distanciaPercorrida + "cm");	
					Thread.sleep(1000);
					
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		Main.positions();
		
		System.out.println("O " + nome + " foi o " + Main.position + "º colocado com " + qtdPulos + " pulos ");
		
		if(Main.position == 1) {
			Main.timeVencedor = grupo;
		}
		
		if(grupo == 1) {
			Main.somaPulosGrupo1 += qtdPulos;
			Main.somaDistanciaGrupo1 += distanciaPercorrida;
		}
		
		if(grupo == 2) {
			Main.somaPulosGrupo2 += qtdPulos;
			Main.somaDistanciaGrupo2 += distanciaPercorrida;
		}
		
		if(Main.position == 6) {
			System.out.println("Time 1: Total de Pulos: " + Main.somaPulosGrupo1 + " - Distância Percorrida: " + Main.somaDistanciaGrupo1);
			System.out.println("Time 2: Total de Pulos: " + Main.somaPulosGrupo2 + " - Distância Percorrida: " + Main.somaDistanciaGrupo2);
			
			System.out.println("Time " + Main.timeVencedor + " foi o vencedor");
		}
	}
	
}

