package pt.c40task.l05wumpus;

public class Buraco extends Componente {
	
	Buraco(int posX, int posY){
		super(posX, posY, 'B');
		this.prioridade = 3;
	}
	
}
