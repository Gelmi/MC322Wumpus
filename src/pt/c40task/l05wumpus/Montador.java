package pt.c40task.l05wumpus;

public class Montador {

	public void montarCaverna(String cave[][], Caverna caverna) {
		//Percorre a matriz cave instanciando o componente adequado na posicao certa
		System.out.println(cave.length);
		for(int i = 0; i < cave.length; i++) {
			switch (cave[i][2]) {
			case "P":
				caverna.conecta(new Heroi(Integer.parseInt(cave[i][0]) - 1, Integer.parseInt(cave[i][1]) - 1));
			break;
			case "W":
				caverna.conecta(new Wumpus(Integer.parseInt(cave[i][0]) - 1, Integer.parseInt(cave[i][1]) - 1));
			break;
			case "B":
				caverna.conecta(new Buraco(Integer.parseInt(cave[i][0]) - 1, Integer.parseInt(cave[i][1]) - 1));
			break;
			case "O":
				caverna.conecta(new Ouro(Integer.parseInt(cave[i][0]) - 1, Integer.parseInt(cave[i][1]) - 1));
			break;
			case "_":
				caverna.conecta(new Componente(Integer.parseInt(cave[i][0]) - 1, Integer.parseInt(cave[i][1]) - 1));
			break;
			}
		}
	}
}
