package pt.c40task.l05wumpus;

public class Montador {

	private int[] nCadaComponente = new int[4];
	
	Montador() {
		for(int i = 0; i < 4; i++ ) {
			nCadaComponente[i] = 0;
		}
	}
	
	public Boolean montarCaverna(String cave[][], Caverna caverna, Controle controle) {
		//Percorre a matriz cave instanciando o componente adequado na posicao certa
		for(int i = 0; i < cave.length; i++) {
			switch (cave[i][2]) {
			case "P":
				caverna.conecta(new Heroi(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1, controle));
				this.nCadaComponente[0]+=1;
			break;
			case "W":
				caverna.conecta(new Wumpus(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1));
				this.nCadaComponente[1]+=1;
			break;
			case "B":
				caverna.conecta(new Buraco(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1));
				this.nCadaComponente[2]+=1;
			break;
			case "O":
				caverna.conecta(new Ouro(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1));
				this.nCadaComponente[3]+=1;
			break;
			}
		}
		if(this.nCadaComponente[0] == 1 && this.nCadaComponente[1] == 1 && this.nCadaComponente[2] >=2 && this.nCadaComponente[2] <=3 && this.nCadaComponente[3] == 1) {
			return true;
		} else {
			return false;
		}
	}
}
