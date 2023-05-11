package view;

import javax.swing.JOptionPane;

import control.PlayerController;
import model.Lista;

public class Main {
	
	public static void main(String[] args) throws Exception {
		int i = 1;
		Lista l = new Lista();
		PlayerController play = new PlayerController();
		String nomeMusica;
		String nomeArtista;
		String duracao;
		String musica;
		boolean controle = false;
		while(controle==false) {
			nomeMusica = JOptionPane.showInputDialog("Digite o nome da "+i+"° musica");
			nomeArtista = JOptionPane.showInputDialog("Digite o nome do "+i+"° artista");
			duracao = JOptionPane.showInputDialog("Digite a duracao");
			int cont = Integer.parseInt(JOptionPane.showInputDialog("Continuar?\n1 - Sim\n2 - Não"));
			if(cont==2) {
				controle = true;
			}
			musica = (nomeMusica+";"+nomeArtista+";"+duracao);
			play.adicionaMusica(l, musica);
		}
		play.executaPlaylist(l);
	}
}
