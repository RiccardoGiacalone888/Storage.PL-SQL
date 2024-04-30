package com.springdemo.storageonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void inserisciProdotto (String nome, String descrizione, double prezzo, int quantita) {
        jdbcTemplate.update("CALL INSERISCI_PRODOTTO(?, ?, ?, ?)", nome, descrizione, prezzo, quantita);
    }

    public void aggiornaProdotto (Long id, String nome, String descrizione, double prezzo, int quantita) {
        jdbcTemplate.update("CALL AGGIORNA_PRODOTTO(?, ?, ?, ?, ?)", id, nome, descrizione, prezzo, quantita);
    }

    public void eliminaProdotto (Long id){
        jdbcTemplate.update("CALL ELIMINA_PRODOTTO(?)", id);
    }

    public List<Prodotto> recuperaProdotti(String categoria) {
        return jdbcTemplate.query("CALL RECUPERA_PRODOTTI()", new ProdottoRowMapper());
    }
}
