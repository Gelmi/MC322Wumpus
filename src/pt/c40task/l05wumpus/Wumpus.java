package pt.c40task.l05wumpus;

public class Wumpus extends Componente {

	Wumpus(int posX, int posY){
		super(posX, posY, 'W');
		this.prioridade = 3;
	}
}
