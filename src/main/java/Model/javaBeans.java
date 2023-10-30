package Model;

public class javaBeans {
	private int idcon;
	public int getIdcon() {
		return idcon;
	}
	public void setIdcon(int idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String  nome;
	private String fone;
	private String email;
	public javaBeans() {
		super();
	
	}
	public javaBeans(int idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}
	
	
	
}
