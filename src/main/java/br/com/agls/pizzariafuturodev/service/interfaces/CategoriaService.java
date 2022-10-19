package br.com.agls.pizzariafuturodev.service.interfaces;

import java.util.List;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;

public interface CategoriaService {

    Categoria salvar(Categoria categoria);

    Categoria atualizar(Categoria categoria);

    Categoria buscar(Integer id);

    List<Categoria> listAll();

    void excluir(Integer id);

}
