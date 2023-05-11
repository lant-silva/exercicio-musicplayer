package model;

public class Musica {
	String nome;
	String nomeArtista;
	int duracao;
	
	public Musica(String nome, String nomeArtista, int duracao) {
		this.nome = nome;
		this.nomeArtista = nomeArtista;
		this.duracao = duracao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeArtista() {
		return nomeArtista;
	}
	
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
