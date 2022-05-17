	package pt.c40task.l05wumpus;

public class Caverna {
	private Sala salas[][] = new Sala[4][4];	
	
	public void conecta(Componente componente) {
		componente.setCaverna(this);
		salas[componente.getPosX()][componente.getPosY()].conecta(componente);
	}
}
