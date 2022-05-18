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
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				salas[i][j] = new Sala();
			}
		}
		componente.setCaverna(this);
	}
	
	public void conectaSala(Componente componente) {
		if(componente != null) {
			if(componente.getPosX() >= 0 && componente.getPosX() <= 4 && componente.getPosY() >= 0 && componente.getPosY() <= 4) {
				this.salas[componente.getPosX()][componente.getPosY()].conecta(componente);
			}
		}
	}
	
	public String[][] toStringMatrix(){
		String stringMatrix[][] = new String[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(salas[i][j].retornaComponente() instanceof Heroi) {
					stringMatrix[i][j] = "P";
				} else if(salas[i][j].retornaComponente() instanceof Buraco) {
					stringMatrix[i][j] = "B";
				} else if(salas[i][j].retornaComponente() instanceof Wumpus) {
					stringMatrix[i][j] = "W";
				} else if(salas[i][j].retornaComponente() instanceof Ouro) {
					stringMatrix[i][j] = "O";
				} else if(salas[i][j].retornaComponente() instanceof Fedor) {
					stringMatrix[i][j] = "f";
				} else if(salas[i][j].retornaComponente() instanceof Brisa) {
					stringMatrix[i][j] = "b";
				} else if(salas[i][j].retornaComponente() == null) {
					stringMatrix[i][j] = "-";
				}
			}
		}
		return stringMatrix;
	}
}
