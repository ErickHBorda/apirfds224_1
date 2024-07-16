package com.iis.app.dto;

import java.util.Date;

public class DtoPersonExa {
    private String codigoOficina;
    private String descripcion;
	private String pais;
	private String fechaCreacion;
	private boolean estado;
    private Date created_at;
    private Date updated_at;
    
	
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

    public Date getCreated_at(){
        return created_at;
    }

    public void setCreated_at(Date created_at){
        this.created_at=created_at;
    }

    public Date getUpdated_at(){
        return updated_at;
    }

    public void setUpdated_at(Date updated_at){
        this.updated_at=updated_at;
    }
}
