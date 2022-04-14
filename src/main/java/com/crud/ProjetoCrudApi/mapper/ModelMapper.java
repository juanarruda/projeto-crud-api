package com.crud.ProjetoCrudApi.mapper;

import com.crud.ProjetoCrudApi.model.Endereco;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelMapper {
    public Endereco mapEnderecoLinhaConsulta(ResultSet rs) throws SQLException {

        Endereco entidade = new Endereco();
        entidade.setIdEndereco(rs.getLong("idUsuario"));
        entidade.setCep(rs.getString("cep"));
        entidade.setNomeEndereco(rs.getString("nomeEndereco"));
        entidade.setBairro(rs.getString("bairro"));
        entidade.setEstado(rs.getString("estado"));
        entidade.setIsPrincipal(rs.getBoolean("isPrincipal"));
        entidade.setIdUsuario(rs.getLong("idUsuario"));

        return entidade;
    }
}
