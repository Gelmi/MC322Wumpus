package pt.c40task.l05wumpus;

public class Sala {
	private Componente componentes[] = new Componente[7];
	private int nComponentes = 0;
	
	public void conecta(Componente componente) {
		componentes[nComponentes] = componente;
		nComponentes++;
	}
	
	public Componente[] getComponentes() {
		return componentes;
	}
	
	public Componente getComponentePrioridade() {
		for(int i = 0; i < this.componentes.length; i++) {
			
		}
	}
}
