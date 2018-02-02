
public abstract class Offerta {

	private int idOfferta;
	private int valore;
	
	public void Offerta(int valore){
		setIdOfferta(idOfferta);
		setValore(valore);
	}


	private int getIdOfferta() {
		return idOfferta;
	}

	private void setIdOfferta(int idOfferta) {
		this.idOfferta = idOfferta;
	}

	private int getValore() {
		return valore;
	}

	private void setValore(int valore) {
		this.valore = valore;
	}
	
}
