package com.crud.ProjetoCrudApi.mapper;

import com.crud.ProjetoCrudApi.dto.EntidadeFormDTO;
import com.crud.ProjetoCrudApi.dto.EntidadeListaDTO;
import com.crud.ProjetoCrudApi.model.Endereco;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DTOMapper {

    public EntidadeFormDTO mapFormLinhaConsulta(ResultSet rs) throws SQLException {

        EntidadeFormDTO entidade = new EntidadeFormDTO();
        entidade.setIdUsuario(rs.getLong("idUsuario"));
        entidade.setUsuario(rs.getString("usuario"));
        entidade.setIdPerfil(rs.getLong("idPerfil"));
        entidade.setNomePerfil(rs.getString("nomePerfil"));
        entidade.setNomeCliente(rs.getString("NomeCliente"));
        entidade.setSobrenome(rs.getString("sobrenome"));
        entidade.setDataNascimento(rs.getTimestamp("dataNascimento"));
        entidade.setTelefone(rs.getString("telefone"));
        entidade.setCpf(rs.getString("cpf"));
        entidade.setRg(rs.getString("rg"));

        return entidade;
    }

    public EntidadeListaDTO mapListaLinhaConsulta(ResultSet rs) throws SQLException {

        EntidadeListaDTO entidade = new EntidadeListaDTO();
        entidade.setIdUsuario(rs.getLong("idUsuario"));
        entidade.setNomeCliente(rs.getString("nomeCompleto"));
        entidade.setDataNascimento(rs.getTimestamp("dataNascimento"));
        entidade.setTelefone(rs.getString("telefone"));
        entidade.setCpf(rs.getString("cpf"));
        entidade.setRg(rs.getString("rg"));
        entidade.setCep(rs.getString("cep"));
        entidade.setNomeEndereco(rs.getString("nomeEndereco"));

        return entidade;
    }
}
