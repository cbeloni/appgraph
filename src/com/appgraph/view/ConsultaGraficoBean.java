package com.appgraph.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.appgraph.service.GestaoGrafico;

@ManagedBean
public class ConsultaGraficoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//private List<Grafico> graficos = new ArrayList<Grafico>();
	private List<String> nomesGraficos = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar() {
		GestaoGrafico gg = new GestaoGrafico();
		this.setNomesGraficos(gg.obtemNomeGraficos());
	}

	public List<String> getNomesGraficos() {
		for (String g : nomesGraficos) {
			System.out.println(g);
		}
		return nomesGraficos;
	}

	public void setNomesGraficos(List<String> nomesGraficos) {
		this.nomesGraficos = nomesGraficos;
	}

    
    

}
