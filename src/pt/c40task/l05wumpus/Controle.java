package pt.c40task.l05wumpus;
import java.util.Scanner;

public class Controle {
	private Heroi heroi;
	private Scanner keyboard;
	
	public Controle() {
		this.keyboard = new Scanner(System.in);
	}
	
	public void pegarComando() {
		String comando = this.keyboard.nextLine();
		switch (comando) {
			case "w":
				this.heroi.moverCima();
			break;
			case "s":
				this.heroi.moverBaixo();
			break;
			case "a":
				this.heroi.moverEsquerda();
			break;
			case "d":
				this.heroi.moverDireita();
			break;
			case "k":
				this.heroi.equiparFlecha();
			break;
			case "c":
				this.heroi.pegarOuro();
			break;
			case "q":
				
			break;
		}
	}
	
	public void conectarHeroi(Heroi h) {
		this.heroi = h;
	}
	
	
}
