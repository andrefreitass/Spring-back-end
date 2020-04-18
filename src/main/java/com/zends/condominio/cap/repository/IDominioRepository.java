package com.zends.condominio.cap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.cap.domains.Dominio;

@Repository
public interface IDominioRepository extends JpaRepository< Dominio, Long > {

}
