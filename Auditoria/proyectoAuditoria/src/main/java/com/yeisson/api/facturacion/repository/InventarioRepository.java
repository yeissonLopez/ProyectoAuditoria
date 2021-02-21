package com.yeisson.api.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yeisson.api.facturacion.models.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

}
