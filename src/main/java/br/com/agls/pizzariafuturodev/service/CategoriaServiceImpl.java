package br.com.agls.pizzariafuturodev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;
import br.com.agls.pizzariafuturodev.repository.CategoriaRepository;
import br.com.agls.pizzariafuturodev.service.interfaces.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    // CRUD...
    @Override
    public Categoria salvar(Categoria categoria) {
        Categoria categoriaSalvar = this.categoriaRepository.save(categoria);
        return categoriaSalvar;
    }

    @Override
    public List<Categoria> listAll() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findById(categoria.getId());

        if (categoriaPesquisada.isPresent()) {
            categoriaPesquisada.get().setNomeCategoria(categoria.getNomeCategoria());

            return this.categoriaRepository.save(categoriaPesquisada.get());
        }

        return null;
    }

    @Override
    public void excluir(Integer id) {
        this.categoriaRepository.deleteById(id);

    }

    // Metodos...

    @Override
    public Categoria buscar(Integer id) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findById(id);

        if (categoriaPesquisada.isPresent()) {
            return categoriaPesquisada.get();
        }

        return null;
    }

}
