package control;

import model.Lista;
import model.Musica;

public class PlayerController {
	
	public void adicionaMusica(Lista lista, String musica) throws Exception{
		String[] atributos={};
		if(!musica.contains(";")) {
			throw new Exception("Formato invalido");
		}else {
			if(musica.contains(";")) {
				atributos = musica.split(";");
			}
		}
		Musica m = new Musica(atributos[0], atributos[1], Integer.parseInt(atributos[2]));
		if(lista.isEmpty()) {
			lista.addFirst(m.getNome()+";"+m.getNomeArtista()+";"+Integer.toString(m.getDuracao()));
		}else {
			lista.addLast(m.getNome()+";"+m.getNomeArtista()+";"+Integer.toString(m.getDuracao()));
		}
	}
	
	public void removeMusica(Lista lista, int pos) throws Exception{
		if(lista.isEmpty()) {
			throw new Exception("Lista vazia");
		}
		lista.remove(pos);
	}
	
	public void executaPlaylist(Lista lista) throws Exception{
		if(lista.isEmpty()) {
			throw new Exception("Lista vazia");
		}
		String[] musica={};
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).contains(";")) {
				musica = lista.get(i).split(";");
			}
			System.out.println("[Musica: "+musica[0]+" - Artista: "+musica[1]+" - Duracao: "+musica[2]+"]");
		}
		
		for(int i=0;i<lista.size();i++) {
			executarMusica(musica[0], Integer.parseInt(musica[2]));
		}
	}

	private void executarMusica(String musica, int duracao) throws InterruptedException {
		
		System.out.println("Tocando agora: "+musica);
		int i = 0;
		int minutos=0;
		int segundos=0;
		
		if(duracao<60) {
			segundos = duracao;
		}else {
			int aux = duracao / 60;
			minutos = aux;
			segundos = duracao - (aux*60);
		}
		
		int segundosCont=0;
		int minutosCont=0;
		while(i<=duracao) {
			
			if(segundosCont < 10) {
				System.out.println("Tempo: "+minutosCont+":0"+segundosCont+" / "+minutos+":"+segundos);
			}else {
				System.out.println("Tempo: "+minutosCont+":"+segundosCont+" / "+minutos+":"+segundos );
			}
			if(segundosCont<60-1) {
				segundosCont++;
			}else {
				segundosCont=0;
				minutosCont++;
			}
			
			i++;
			Thread.sleep(1000);
		}
	}
}
