package com.appgraph.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;
import com.appgraph.util.HibernateUtil;

public class GestaoUsuario {
	
	private Usuario usuario;
	
	public GestaoUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean existeUsuario () {
		Session session = HibernateUtil.getSession();	
		Long count = (Long) session.createCriteria(Usuario.class)
						  .add(Restrictions.eq("usuario", this.usuario.getUsuario()))
						  .add(Restrictions.eq("senha", this.usuario.getSenha()))
						  .setProjection(Projections.rowCount())
						  .uniqueResult();
		session.close();
		return count > 0;
	}
	
	public Usuario ObtemUsuario () {
		Session session = HibernateUtil.getSession();	
		Usuario usuario = (Usuario) session.createCriteria(Usuario.class)
						  .add(Restrictions.eq("usuario", this.usuario.getUsuario()))
						  .add(Restrictions.eq("senha", this.usuario.getSenha()))
						  .uniqueResult();	
		
		session.close();
		return usuario;
	}
	
}
