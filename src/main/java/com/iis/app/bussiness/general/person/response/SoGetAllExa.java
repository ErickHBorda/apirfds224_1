package com.iis.app.bussiness.general.person.response;

public class SoGetAllExa {
    public String codigoOficina;
    public String descripcion;
	public String pais;
	public String fechaCreacion;
	public boolean estado;

    public SoGetAllExa(
        String codigoOficina,
        String descripcion,
        String pais,
        String fechaCreacion,
        boolean estado
        ){
        this.codigoOficina=codigoOficina;
        this.descripcion=descripcion;
        this.estado=estado;
        this.fechaCreacion=fechaCreacion;
        this.pais=pais;
    }
}
