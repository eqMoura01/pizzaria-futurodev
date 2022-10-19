package br.com.agls.pizzariafuturodev.service.interfaces;

import java.util.List;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;

public interface MesaService {

    Mesa salvar(Mesa mesa);

    Mesa atualizar(Mesa mesa);

    Mesa buscar(Long id);

    List<Mesa> listar();

    List<Mesa> listarAtivas();

    void excluir(Long id);
}
