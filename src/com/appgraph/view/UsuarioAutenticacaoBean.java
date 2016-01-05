package com.appgraph.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.appgraph.model.Usuario;
import com.appgraph.util.HibernateUtil;

@ManagedBean
@SessionScoped
public class UsuarioAutenticacaoBean implements Serializable{
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioAutenticacaoBean() {
		this.usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public void autenticar(){	
		Session session = HibernateUtil.getSession();	
		Long count = (Long) session.createCriteria(Usuario.class)
						  .add(Restrictions.eq("usuario", usuario.getUsuario()))
						  .add(Restrictions.eq("senha", usuario.getSenha()))
						  .setProjection(Projections.rowCount())
						  .uniqueResult();
		
		if (count == 1) {
			System.out.println("Logado");
		} else {
			System.out.println("Nao Logado");
		}
			
		session.close();
		
	}
}
