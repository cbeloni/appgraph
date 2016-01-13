package com.appgraph.service;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;
import com.appgraph.util.HibernateUtil;

public class GestaoGrafico {
	
	private Grafico grafico;
	
	public GestaoGrafico(Grafico grafico) {
		this.grafico = grafico;
	}

}
