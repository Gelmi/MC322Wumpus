package pt.c40task.l05wumpus;

public class Componente {
	protected int posX, posY;
	protected Caverna caverna;
	protected String representacao;
	
	Componente(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.representacao = "-";
	}

	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setCaverna(Caverna caverna) {
		this.caverna = caverna;
		this.caverna.conectaSala(this);
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
	
	public String getRepresentacao() {
		return this.representacao;
	}
}
