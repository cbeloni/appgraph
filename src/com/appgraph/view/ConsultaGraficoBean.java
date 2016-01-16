package com.appgraph.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.appgraph.model.Grafico;

@ManagedBean
public class ConsultaGraficoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Grafico> graficos = new ArrayList<Grafico>();
	private List<String> nomesGraficos = new ArrayList<String>();

	
	@PostConstruct
	public void inicializar() {
		//Lancamentos lancamentos = this.repositorios.getLancamentos();
		//this.graficos = lancamentos.todos();
	}


}
