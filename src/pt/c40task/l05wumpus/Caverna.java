	package pt.c40task.l05wumpus;

public class Caverna {
	private Sala salas[][] = new Sala[4][4];	
	
	public Caverna() {
		//Inicializando salas
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				this.salas[i][j] = new Sala();
			}
		}
	}
	
	public void conecta(Componente componente) {
		componente.setCaverna(this);
		salas[componente.getPosX()][componente.getPosY()].conecta(componente);
	}
}
