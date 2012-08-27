package com.opt.sam;

import android.graphics.drawable.Drawable;

public class CustomItem {
	private Drawable icono;
	private String titulo;
	private String subtitulo;
	
	public CustomItem(Drawable icono, String titlo, String subtitulo){
		super();
		this.icono = icono;
		this.titulo = titlo;
		this.subtitulo = subtitulo;
	}
	public Drawable getIcono() {
		return icono;
	}
	public void setIcono(Drawable icono) {
		this.icono = icono;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitlo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
		
		
	

	
}
