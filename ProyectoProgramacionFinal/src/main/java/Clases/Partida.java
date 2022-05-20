package Clases;

public class Partida {
	private Mundial mundial;

	

	public Partida(Mundial mundial) {
		super();
		this.mundial = mundial;
	}



	public Mundial getMundial() {
		return mundial;
	}
	
	

	public void setMundial(Mundial mundial) {
		this.mundial = mundial;
	}
	
	
	
	@Override
	public String toString() {
		return "Partida [mundial=" + mundial + "]";
	}


}
