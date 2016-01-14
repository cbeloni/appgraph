package com.appgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;
import com.appgraph.util.HibernateUtil;
import com.appgraph.util.FacesUtil;
import com.appgraph.view.UsuarioAutenticacaoBean;

public class GestaoGrafico {
	
	private Grafico grafico;
	private List<Grafico> graficos = new ArrayList<Grafico>();
	
	public List<Grafico> porNome (String nome) {
		Session session = HibernateUtil.getSession();
		UsuarioAutenticacaoBean usuarioAutenticacaoBean = (UsuarioAutenticacaoBean) FacesUtil.getSessionAttribute("usuarioAutenticacaoBean");
		Usuario usuario = usuarioAutenticacaoBean.getUsuario();		
			
		@SuppressWarnings("unchecked")
		List<Grafico> graficos = (List<Grafico>) session.createCriteria(Grafico.class)
				.add(Restrictions.eq("nome_grafico", nome))
				.add(Restrictions.eq("uid_usuario", usuario.getUid()))
				.addOrder(Order.asc("id"))
				.list();
		
		session.close();
			
		return graficos;
	}
	
	public Grafico porCodigo (Integer codigo) {
		Session session = HibernateUtil.getSession();	

		Grafico g = (Grafico) session.get(Grafico.class, codigo);
		
		session.close();
			
		return g;
	}
	
}
