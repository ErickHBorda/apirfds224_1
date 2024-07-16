package com.iis.app.bussiness.general.person.request;

public class SoUpdateExa {
    private String codigoOficina;
    private String descripcion;
	private String pais;
	private String fechaCreacion;
	private boolean estado;
	
    public String getCodigoOficina(){
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina){
        this.codigoOficina=codigoOficina;
    }

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
