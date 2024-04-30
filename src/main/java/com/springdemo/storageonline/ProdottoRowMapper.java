package com.springdemo.storageonline;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdottoRowMapper implements RowMapper<Prodotto> {

    @Override
    public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Prodotto prodotto = new Prodotto();
        prodotto.setId(rs.getLong("id"));
        prodotto.setNome(rs.getString("nome"));
        prodotto.setDescrizione(rs.getString("descrizione"));
        prodotto.setPrezzo(rs.getDouble("prezzo"));
        prodotto.setQuantitaDisponibile(rs.getInt("quantita_disponibile"));
        return prodotto;
    }
}
