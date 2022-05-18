package pt.c40task.l05wumpus;

public class Componente {
	protected int posX, posY;
	protected Caverna caverna;
	protected char simbolo;
	protected int prioridade;
	
	Componente(int posX, int posY, char simbolo){
		this.posX = posX;
		this.posY = posY;
		this.simbolo = simbolo;
	}
	// Caso seja nada
	Componente(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.simbolo = '#';
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
	
	public char getSimbolo() {
		return this.simbolo;
	}
}
