package com.appgraph.service;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
	
}
