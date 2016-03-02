package br.com.deivisondfs2.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import br.com.deivisondfs2.model.Atividade;

@Service
public class AtividadeService {

	private static List<Atividade> listaAtividades = new ArrayList<Atividade>();

	public AtividadeService() {
		montarListaAtividades();
	}
	
	private void montarListaAtividades(){
		listaAtividades.add(new Atividade(1, "deivisondfs2", "alguma Descrição", new DateTime(), false));
		listaAtividades.add(new Atividade(2, "deivisondfs2", "Olá descrição 2 tudo bem?", new DateTime(), false));
		listaAtividades.add(new Atividade(3, "deivisondfs2", "vixe mais uma...", new DateTime(), false));
	}
	
	
	public void addListaAtividade(Atividade atividade){
		listaAtividades.add(atividade);
	}
	
	public void removerAtividade(int id){
		
		Iterator<Atividade> iterator = listaAtividades.iterator();
        while (iterator.hasNext()) {
            Atividade atividade = iterator.next();
            if (atividade.getId() == id) {
                iterator.remove();
            }
        }
		
	}
	
	public Atividade buscarAtividade(int id){
		Atividade retorno = new Atividade();
		for (Atividade atividade : listaAtividades) {
			if (atividade.getId() == id) 
				retorno = atividade;
		}
		return retorno;
	}
	
	
	public void atualizarAtividade(Atividade atividade){
		listaAtividades.remove(atividade);
		addListaAtividade(atividade);
	}
	
	
	public static List<Atividade> getListaAtividades() {
		return listaAtividades;
	}
	
}
