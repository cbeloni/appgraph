package com.appgraph.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.appgraph.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioAutenticacaoBean implements Serializable{
	private Usuario usuario = new Usuario();

	public UsuarioAutenticacaoBean() {
		this.usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void autenticar(){
		System.out.println("Teste");
		System.out.println(usuario.getUsuario());
		System.out.println(usuario.getSenha());	
	}
}
