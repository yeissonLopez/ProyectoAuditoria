package com.yeisson.api.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yeisson.api.facturacion.models.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
