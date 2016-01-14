package com.appgraph.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appgraph.model.Usuario;
import com.appgraph.service.GestaoUsuario;

@ManagedBean
@SessionScoped
public class UsuarioAutenticacaoBean implements Serializable{
	private boolean logado;
	
	private Usuario usuario = new Usuario();
	//private List<Usuario> usuarios = new ArrayList<Usuario>();		

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
			this.usuario = gestaoUsuario.ObtemUsuario();
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