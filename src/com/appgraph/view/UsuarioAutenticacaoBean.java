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
	private boolean logado;
	
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
		
		if (count == 1 && !isLogado()) {
			setLogado(true);
			System.out.println("Logado");		
		} else if (isLogado()) {
			System.out.println("Já estava logado");
		}		
		else {
			System.out.println("Nao Logado");
		}
					
		session.close();
		
	}
	
	public void sair(){
		if (isLogado())  {
			setLogado(false);
			System.out.println("Logout com sucesso!");
		}
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	}