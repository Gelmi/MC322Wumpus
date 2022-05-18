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
	
	public Componente getComponentePrioritario() {
		//Suponha que o primeiro seja o prioritario
		int maiorPrioridade = this.componentes[0].getPrioridade();
		Componente componentePrioritario = this.componentes[0];
		
		for(int i = 1; i < this.nComponentes; i++) {
			if(this.componentes[i].getPrioridade() > maiorPrioridade) {
				componentePrioritario = this.componentes[i];
				maiorPrioridade = this.componentes[i].getPrioridade();
			}
		}
		return componentePrioritario;
	}
}
