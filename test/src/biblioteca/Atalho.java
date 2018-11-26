package biblioteca;

import java.util.List;

public class Atalho {

	private String nome;
	private String sobrenome;
	
	
	//nome = name
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//sobrenome = surname
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public String toString() {
		return "[  \n nome=" + nome + "\n" + " sobrenome=" + sobrenome + "\n";
	}
}
