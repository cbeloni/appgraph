package com.appgraph.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appgraph.model.Usuario;
import com.appgraph.service.GestaoUsuario;
import com.appgraph.util.FacesUtil;
import com.appgraph.view.NavigationBean;

@ManagedBean
@SessionScoped
public class UsuarioAutenticacaoBean implements Serializable{
	private boolean logado;
	
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	private Usuario usuario = new Usuario();
	//private List<Usuario> usuarios = new ArrayList<Usuario>();		

	public UsuarioAutenticacaoBean() {
		this.usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public String autenticar(){	

		GestaoUsuario gestaoUsuario = new GestaoUsuario(this.usuario);
		
		if (gestaoUsuario.existeUsuario() && !isLogado()) {
			setLogado(true);
			this.usuario = gestaoUsuario.ObtemUsuario();
			
			System.out.println("Logado");	
			return navigationBean.IrParaConsultaGrafico();
		} else if (isLogado()) {
			System.out.println("Já estava logado");
			return navigationBean.IrParaConsultaGrafico();
		}		
		else {
			System.out.println("Nao Logado");
			return navigationBean.IrParaIndex();
		}							
		
	}
	
	public String sair(){
		if (isLogado())  {
			setLogado(false);
			FacesUtil.InvalidateSession();
			System.out.println("Logout com sucesso!");
		}
		return navigationBean.IrParaIndex();
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	}