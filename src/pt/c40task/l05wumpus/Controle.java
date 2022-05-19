package pt.c40task.l05wumpus;
import java.util.Scanner;

public class Controle {
	private Heroi heroi;
	private Scanner keyboard;
	private String jogador;
	
	public Controle() {
		this.keyboard = new Scanner(System.in);
		this.jogador = this.keyboard.nextLine();
	}
	
	public Boolean pegarComandos() {
		String comando = this.keyboard.nextLine();
		switch (comando) {
			case "w":
				//andar p cima
				if(!heroi.moverCima()) { System.out.println("Comando errado"); } else {
					System.out.println("Andou para cima");
				}
			break;
			case "s":
				//andar p baixo
				if(!heroi.moverBaixo()) { System.out.println("Comando errado"); } else {
					System.out.println("Andou para baixo");
				}
			break;
			case "a":
				//andar p esquerda
				if(!heroi.moverEsquerda()) { System.out.println("Comando errado"); } else {
					System.out.println("Andou para esquerda");
				}
			break;
			case "d":
				//andar p direita
				if(!heroi.moverDireita()) { System.out.println("Comando errado"); } else {
					System.out.println("Andou para direita");
				}
			break;
			case "k":
				//equipar flecha
				heroi.equipaFlecha();
				System.out.println("Equipou a flecha");
			break;
			case "c":
				//capturar ouro
				if(!heroi.capturaOuro()) { System.out.println("Não há ouro nessa sala"); } else {
					System.out.println("Capturou o ouro");
				}
			break;
			case "q":
				//sair
				heroi.desisteHeroi();
			break;
			default:
				System.out.println("Comando invalido");
		}
		if(heroi.getCausa().length() != 0) {
			return false;
		}
		return true;
	}
	
	public void conecta(Heroi heroi) {
		this.heroi = heroi;
	}
	
	public Heroi getHeroi() {
		return this.heroi;
	}
	
	public String getJogador() {
		return this.jogador;
	}
}
