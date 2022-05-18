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
				if(this.heroi.getPosX()-1 > 0) {
					this.heroi.moverCima();
					if(this.heroi.getFlecha()) { this.heroi.disparar(); }	
				}
			break;
			case "s":
				if(this.heroi.getPosX()+1 < 4) {
					this.heroi.moverBaixo();
					if(this.heroi.getFlecha()) { this.heroi.disparar(); }
				}
			break;
			case "a":
				if(this.heroi.getPosY()-1 > 0) {
					this.heroi.moverEsquerda();
					if(this.heroi.getFlecha()) { this.heroi.disparar(); }
				}
			break;
			case "d":
				if(this.heroi.getPosY()+1 < 4) {
					this.heroi.moverDireita();
					if(this.heroi.getFlecha()) { this.heroi.disparar(); }	
				}
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
