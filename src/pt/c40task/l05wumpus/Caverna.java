	package pt.c40task.l05wumpus;

public class Caverna {
	private Sala salas[][] = new Sala[4][4];	
	
	Caverna() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				salas[i][j] = new Sala();
			}
		}
	}
	
	public void conecta(Componente componente) {
		componente.setCaverna(this);
	}
	
	public void conectaSala(Componente componente) {
		if(componente != null) {
			if(componente.getPosX() >= 0 && componente.getPosX() <= 3 && componente.getPosY() >= 0 && componente.getPosY() <= 3) {
				if(componente.getPosX() == 0 && componente.getPosY() == 0) {
					if(componente instanceof Heroi) {
						if(((Heroi) componente).temOuro()) {
							((Heroi) componente).saiCaverna();
						}
					}
				}
				this.salas[componente.getPosX()][componente.getPosY()].conecta(componente);
			}
		}
	}
	
	public String[][] toStringMatrix(){
		String stringMatrix[][] = new String[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(salas[i][j].retornaComponente() != null) {
					stringMatrix[i][j] = salas[i][j].retornaComponente().getRepresentacao();
				} else {
					if(salas[i][j].descoberta()) {
						stringMatrix[i][j] = "#";
					} else {
						stringMatrix[i][j] = "-";
					}
				}
			}
		}
		return stringMatrix;
	}
	
	public char[][] toCharMatrix(){
		char charMatrix[][] = new char[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(salas[i][j].retornaComponente() != null) {
					charMatrix[i][j] = salas[i][j].retornaComponente().getRepresentacao().charAt(0);
				} else {
					if(salas[i][j].descoberta()) {
						charMatrix[i][j] = '#';
					} else {
						charMatrix[i][j] = '-';
					}
				}
			}
		}
		return charMatrix;
	}
	
	public void removerComponente(Componente componente) {
		this.salas[componente.getPosX()][componente.getPosY()].desconecta(componente);
	}
	
	public Boolean movimentoValido(int posX, int posY) {
		if(posX >= 0 && posX <= 3 && posY >= 0 && posY <= 3) {
			return true;
		}
		return false;
	}
	
	public Boolean temOuro(Heroi heroi) {
		if(this.salas[heroi.getPosX()][heroi.getPosY()].retornaComponente() instanceof Ouro) { 
			this.salas[heroi.getPosX()][heroi.getPosY()].desconecta(this.salas[heroi.getPosX()][heroi.getPosY()].retornaComponente());
			return true;
		}
		return false;
	}
	
	
}
