package com.zends.condominio.advertencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.advertencia.domains.Advertencia;

@Repository
public interface IAdvertenciaRepository extends JpaRepository< Advertencia, Long > {

}
