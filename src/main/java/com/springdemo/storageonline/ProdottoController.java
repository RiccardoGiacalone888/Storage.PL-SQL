package com.springdemo.storageonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdottoController {
    @Autowired
    private ProdService prodService;

    @PostMapping(("/api/prodotti"))
    public void inserisciProdotto (@RequestBody ProdottoDto prodottoDto){
        prodService.inserisciProdotto(prodottoDto.getNome(), prodottoDto.getDescrizione(),
                prodottoDto.getPrezzo(), prodottoDto.getQuantita());
    }

    @PutMapping("/api/prodotti/{id}")
    public void aggiornaProdotto (@PathVariable Long id, @RequestBody ProdottoDto prodottoDto){
        prodService.aggiornaProdotto(id, prodottoDto.getNome(), prodottoDto.getDescrizione(),
                prodottoDto.getPrezzo(), prodottoDto.getQuantita());
    }

    @DeleteMapping("/api/prodotti/{id}")
    public void eliminaProdotto(@PathVariable Long id){
        prodService.eliminaProdotto(id);
    }

    @GetMapping("/api/prodotti/categoria")
    public ResponseEntity<List<Prodotto>> recuperaProdottiPerCategoria(@RequestParam String categoria) {
        List<Prodotto> prodotti = prodService.recuperaProdotti(categoria);
        return ResponseEntity.ok(prodotti);
    }

}
