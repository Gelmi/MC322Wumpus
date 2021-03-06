package pt.c40task.l05wumpus;

import java.util.Random;

public class Sala {
	private Boolean descoberta = false;
	private Componente componentes[] = new Componente[7];
	private int nComponentes = 0;
	private Random random = new Random();
	
	
	public Boolean conecta(Componente componente) {
		Boolean temBuraco = false, temWumpus = false;
		int wumpus = 0;
		for(int i = 0; i < nComponentes; i++) {
			if(componentes[i] instanceof Wumpus) {
				temWumpus = true;
				wumpus = i;
			}
			if(componentes[i] instanceof Buraco) {
				temBuraco = true;
			}
		}
		if(componente instanceof Heroi) { 
			this.descoberta = true; 
			if(temBuraco) {
				((Heroi) componente).mataHeroi();
			}
			if(temWumpus) {
				if(((Heroi) componente).getFlecha()) {		
					if(random.nextInt(2) == 1) {
						((Heroi) componente).mataWumpus();
					}
					componentes[wumpus] = null;
					
				} else {
					((Heroi) componente).mataHeroi();
				}
			}
			((Heroi) componente).desequipaFlecha();
		}
		if(componente instanceof Ouro) {
			if(!(temWumpus || temBuraco)){
				componentes[nComponentes] = componente;
				nComponentes++;
			} else { return false; }
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
			} else { return false; }
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
			} else { return false; }
		} else {
			componentes[nComponentes] = componente;
			nComponentes++;
		}
		return true;
	}
	
	public Componente retornaComponente() {
		if(!this.descoberta) { return null; }
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
	
	public void desconecta(Componente componente) {
		for(int i = 0; i < this.nComponentes; i++) {
			if(this.componentes[i] == componente) {
				this.componentes[i] = null;
				this.nComponentes-=1;
			}
		}
	}
	
	public Boolean descoberta() {
		return this.descoberta;
	}
}
