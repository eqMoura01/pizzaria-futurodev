package br.com.agls.pizzariafuturodev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agls.pizzariafuturodev.model.entity.Categoria;
import br.com.agls.pizzariafuturodev.service.interfaces.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // CRUD...
    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaService.salvar(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listAll() {
        return ResponseEntity.ok(this.categoriaService.listAll());
    }

    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {

        return ResponseEntity.ok(this.categoriaService.atualizar(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {
        this.categoriaService.excluir(id);

        return ResponseEntity.ok("Deletado com sucesso!");
    }

    // Metodos...

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
        Categoria categoria = this.categoriaService.buscar(id);

        if (categoria == null) {
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }

}
