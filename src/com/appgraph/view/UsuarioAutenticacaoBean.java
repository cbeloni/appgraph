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
import com.appgraph.service.GestaoUsuario;

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

		GestaoUsuario gestaoUsuario = new GestaoUsuario(this.usuario);
		
		if (gestaoUsuario.existeUsuario() && !isLogado()) {
			setLogado(true);
			System.out.println("Logado");		
		} else if (isLogado()) {
			System.out.println("Já estava logado");
		}		
		else {
			System.out.println("Nao Logado");
		}							
		
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