package com.iis.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "toficina")
public class TOficina {
    @Id
	@Column(name = "codigoOficina")
	private String codigoOficina;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "pais")
	private String pais;

	@Column(name = "fechaCreacion")
	private String fechaCreacion;

	@Column(name = "estado")
	private Boolean estado;

	@Column(name = "created_at")
	private Date created_at;

	@Column(name = "updated_at")
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
