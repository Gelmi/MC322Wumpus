package pt.c40task.l05wumpus;

public class Buraco extends Componente {
	
	Buraco(int posX, int posY){
		super(posX, posY);
		this.representacao = "B";
	}
	
	public void setCaverna(Caverna caverna) {
		super.setCaverna(caverna);
		this.caverna.conectaSala(new Brisa(this.posX, this.posY+1));
		this.caverna.conectaSala(new Brisa(this.posX+1, this.posY));
		this.caverna.conectaSala(new Brisa(this.posX, this.posY-1));
		this.caverna.conectaSala(new Brisa(this.posX-1, this.posY));
	}
}
