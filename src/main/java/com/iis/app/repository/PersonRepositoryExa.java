package com.iis.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iis.app.entity.TOficina;

public interface PersonRepositoryExa extends JpaRepository<TOficina, String> { 
    @Query("SELECT t FROM TOficina t WHERE t.descripcion LIKE %:descripcion%")
    List<TOficina> findByDescripcion(@Param("descripcion") String descripcion);
}
