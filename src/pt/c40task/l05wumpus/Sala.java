package pt.c40task.l05wumpus;

public class Sala {
	private Componente componentes[] = new Componente[7];
	private int nComponentes = 0;
	
	public void conecta(Componente componente) {
		componentes[nComponentes] = componente;
		nComponentes++;
	}
}
