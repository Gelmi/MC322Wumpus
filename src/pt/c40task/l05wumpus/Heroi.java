package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente {
	private int nFlechas;
	private boolean flechaEquipada;
	private boolean temOuro;
	private int pontuacao;

	Heroi(int posX, int posY){
		super(posX, posY);
		this.nFlechas = 1;
		this.flechaEquipada = false;
		this.temOuro = false;
	}
	
	public void moverCima() {
		this.desconectarSala();
		this.setPos(this.getPosX()-1, this.getPosY());
		this.caverna.conectaSala(this);
	}
	
	public void moverBaixo() {
		this.desconectarSala();
		this.setPos(this.getPosX()+1, this.getPosY());
		this.caverna.conectaSala(this);		
	}
	
	public void moverEsquerda() {
		this.desconectarSala();
		this.setPos(this.getPosX(), this.getPosY()+1);
		this.caverna.conectaSala(this);
		
	}
	
	public void moverDireita() {
		this.desconectarSala();
		this.setPos(this.getPosX(), this.getPosY()-1);
		this.caverna.conectaSala(this);		
	}
	
	public void equiparFlecha() {
		if(this.nFlechas > 0) {			
			this.flechaEquipada = true;
			this.nFlechas--;
		}
	}
	
	public void pegarOuro() {
		if(this.caverna.componenteEm(this.getPosX(), this.getPosY()) instanceof Ouro) {
			this.temOuro = true;
			this.caverna.componenteEm(this.getPosX(), this.getPosY()).desconectarSala();
		}
	}
	
	public boolean getFlecha() {
		return this.flechaEquipada;
	}
	
	public void disparar() {
		this.flechaEquipada = false;
		if(this.caverna.componenteEm(this.getPosX(), this.getPosY()) instanceof Wumpus) {
			if(new Random().nextBoolean()) {				
				this.caverna.componenteEm(this.getPosX(), this.getPosY()).desconectarSala();;
			}
		}
	}
}
