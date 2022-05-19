package pt.c40task.l05wumpus;

public class Montador {

	private int[] nCadaComponente = new int[4];
	
	Montador() {
		for(int i = 0; i < 4; i++ ) {
			nCadaComponente[i] = 0;
		}
	}
	
	public void montarCaverna(String cave[][], Caverna caverna, Controle controle) {
		//Percorre a matriz cave instanciando o componente adequado na posicao certa
		for(int i = 0; i < cave.length; i++) {
			switch (cave[i][2]) {
			case "P":
				caverna.conecta(new Heroi(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1, controle));
				nCadaComponente[0]+=1;
			break;
			case "W":
				caverna.conecta(new Wumpus(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1));
				nCadaComponente[1]+=1;
			break;
			case "B":
				caverna.conecta(new Buraco(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1));
				nCadaComponente[2]+=1;
			break;
			case "O":
				caverna.conecta(new Ouro(Integer.parseInt(cave[i][0])-1, Integer.parseInt(cave[i][1])-1));
				nCadaComponente[3]+=1;
			break;
			}
		}
	}
}
