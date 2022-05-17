package pt.c40task.l05wumpus;

public class Componente {
	private int posX, posY;
	private Caverna caverna;
	
	Componente(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public Caverna getCaverna() {
		return this.caverna;
	}
}
