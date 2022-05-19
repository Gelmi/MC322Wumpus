package pt.c40task.l05wumpus;

public class Heroi extends Componente {

	private String causa = "";
	private Boolean ouro = false, flecha = false;
	private int pontuacao = 0;
	
	Heroi(int posX, int posY, Controle controle){
		super(posX, posY);
		this.representacao = "P";
		controle.conecta(this);
	}

	public Boolean moverCima() {
		if(this.caverna.movimentoValido(this.getPosX()-1, this.getPosY())) {
			this.caverna.removerComponente(this);
			this.setPos(this.getPosX()-1, this.getPosY());
			this.caverna.conectaSala(this);
			this.pontuacao-=15;
			return true;
		}
		return false;
	}
	
	public Boolean moverBaixo() {
		if(this.caverna.movimentoValido(this.getPosX()+1, this.getPosY())) {
			this.caverna.removerComponente(this);
			this.setPos(this.getPosX()+1, this.getPosY());
			this.caverna.conectaSala(this);
			this.pontuacao-=15;
			return true;
		}
		return false;
	}
	
	public Boolean moverDireita() {
		if(this.caverna.movimentoValido(this.getPosX(), this.getPosY()+1)) {
			this.caverna.removerComponente(this);
			this.setPos(this.getPosX(), this.getPosY()+1);
			this.caverna.conectaSala(this);
			this.pontuacao-=15;
			return true;
		}
		return false;
	}
	
	public Boolean moverEsquerda() {
		if(this.caverna.movimentoValido(this.getPosX(), this.getPosY()-1)) {
			this.caverna.removerComponente(this);
			this.setPos(this.getPosX(), this.getPosY()-1);
			this.caverna.conectaSala(this);
			this.pontuacao-=15;
			return true;
		}
		return false;
	}
	
	public void mataHeroi() {
		this.causa = "Voce perdeu =( ...";
		this.pontuacao-=1000;
	}
	
	public void desisteHeroi() {
		this.causa = "Volte sempre !";
	}
	
	public void saiCaverna() {
		this.causa = "Voce ganhou =D !!!";
		this.pontuacao+=1000;
	}
	
	public void mataWumpus() {
		this.pontuacao+=500;
	}
		
	public String getCausa() {
		return this.causa;
	}
	
	public Boolean capturaOuro() {
		if(this.caverna.temOuro(this)) { 
			this.ouro = true;
			return true;
		}
		return false;
	}
	
	public Boolean temOuro() {
		return ouro;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void equipaFlecha() {
		this.flecha = true;
		this.pontuacao-=100;
	}
	
	public void desequipaFlecha() {
		this.flecha = false;
	}
	
	public Boolean getFlecha() {
		return flecha;
	}
}
