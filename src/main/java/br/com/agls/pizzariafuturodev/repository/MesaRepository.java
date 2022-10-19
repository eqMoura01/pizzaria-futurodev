package br.com.agls.pizzariafuturodev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
