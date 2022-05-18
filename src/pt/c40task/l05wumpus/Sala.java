package pt.c40task.l05wumpus;

public class Sala {
	private Componente componentes[] = new Componente[7];
	private int nComponentes = 0;
	
	public void conecta(Componente componente) {
		if(componente instanceof Ouro) {
			Boolean temWumpusOuBuraco = false;
			for(int i = 0; i < nComponentes; i++) {
				if(componentes[i] instanceof Wumpus || componentes[i] instanceof Buraco ) {
					temWumpusOuBuraco = true;
				}
			}
			if(!temWumpusOuBuraco){
				componentes[nComponentes] = componente;
				nComponentes++;
			}
		} else if(componente instanceof Wumpus) {
			Boolean temOuroOuBuraco = false;
			for(int i = 0; i < nComponentes; i++) {
				if(componentes[i] instanceof Ouro || componentes[i] instanceof Buraco) {
					temOuroOuBuraco = true;
				}
			}
			if(!temOuroOuBuraco){
				componentes[nComponentes] = componente;
				nComponentes++;
			}
		} else if(componente instanceof Buraco) {
			Boolean temOuroOuWumpus = false;
			for(int i = 0; i < nComponentes; i++) {
				if(componentes[i] instanceof Ouro || componentes[i] instanceof Wumpus) {
					temOuroOuWumpus = true;
				}
			}
			if(!temOuroOuWumpus){
				componentes[nComponentes] = componente;
				nComponentes++;
			}
		} else {
			componentes[nComponentes] = componente;
			nComponentes++;
		}
	}
	
	public void desconecta(Componente componente) {
		for(int i = 0; i < this.nComponentes; i++) {
			if(this.componentes[i] == componente) {
				this.componentes[i] = null;
				this.nComponentes--;
				break;
			}
		}
	}
	
	public Componente retornaComponente() {
		Componente Heroi = null, Fedor = null, Brisa = null;
		for(int i = 0; i < 7; i++) {
			if(componentes[i] instanceof Wumpus || componentes[i] instanceof Ouro || componentes[i] instanceof Buraco) {
				return componentes[i];
			}
			if(componentes[i] instanceof Heroi) { Heroi = componentes[i]; }
			if(componentes[i] instanceof Fedor) { Fedor = componentes[i]; }
			if(componentes[i] instanceof Brisa) { Brisa = componentes[i]; }
		}
		if(Heroi != null) { return Heroi; }
		if(Fedor != null) { return Fedor; }
		if(Brisa != null) { return Brisa; }
		return null;
	}
}
