package com.appgraph.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appgraph.service.GestaoGrafico;

@ManagedBean
@SessionScoped
public class ConsultaGraficoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> nomesGraficos = new ArrayList<String>();
	
	private String nomeGraficoSelecionado;
	
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	public String abrirGrafico (){
		System.out.println(nomeGraficoSelecionado);
		return navigationBean.IrParaGrafico();
	}
	public String getNomeGraficoSelecionado() {
		return nomeGraficoSelecionado;
	}

	public void setNomeGraficoSelecionado(String nomeGraficoSelecionado) {
		this.nomeGraficoSelecionado = nomeGraficoSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		GestaoGrafico gg = new GestaoGrafico();
		this.setNomesGraficos(gg.obtemNomeGraficos());
	}

	public List<String> getNomesGraficos() {
		return nomesGraficos;
	}

	public void setNomesGraficos(List<String> nomesGraficos) {
		this.nomesGraficos = nomesGraficos;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}  
    

}
