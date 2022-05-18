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
				//andar p cima
			break;
			case "s":
				//andar p baixo
			break;
			case "a":
				//andar p esquerda
			break;
			case "d":
				//andar p direita
			break;
			case "k":
				//equipar flecha
			break;
			case "c":
				//capturar ouro
			break;
			case "q":
				//sair
			break;
		}
	}
	
	public void conectarHeroi(Heroi h) {
		this.heroi = h;
	}
	
	
}
