package pt.c40task.l05wumpus;

public class Wumpus extends Componente {

	Wumpus(int posX, int posY){
		super(posX, posY);
	}
	
	public void setCaverna(Caverna caverna) {
		super.setCaverna(caverna);
		this.caverna.conectaSala(new Fedor(this.posX, this.posY+1));
		this.caverna.conectaSala(new Fedor(this.posX+1, this.posY));
		this.caverna.conectaSala(new Fedor(this.posX, this.posY-1));
		this.caverna.conectaSala(new Fedor(this.posX-1, this.posY));
	}
}
