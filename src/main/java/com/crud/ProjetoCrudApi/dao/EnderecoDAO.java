package com.crud.ProjetoCrudApi.dao;

import com.crud.ProjetoCrudApi.dto.EntidadeFormDTO;
import com.crud.ProjetoCrudApi.mapper.DTOMapper;
import com.crud.ProjetoCrudApi.mapper.ModelMapper;
import com.crud.ProjetoCrudApi.model.Endereco;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    @Inject
    private ConnectionDAO connectionDAO;

    @Inject
    private ModelMapper modelMapper;

    public List<Endereco> listaEnderecos(Long id, Connection conn) throws SQLException {
        String sqlSelect = "SELECT * FROM projeto_crud.tb_enderecos";
        sqlSelect = sqlSelect.concat(" WHERE idUsuario = " + id.toString());

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ResultSet rs = ps.executeQuery();
        List<Endereco> listaEntidade = new ArrayList<>();

        while (rs.next()) {
            listaEntidade.add(modelMapper.mapEnderecoLinhaConsulta(rs));
        }

        return listaEntidade;
    }

    public void inserirEndereco(Endereco endereco, Connection conn) throws SQLException {
        String sqlSelect = "INSERT INTO projeto_crud.tb_enderecos " +
                "(cep, nomeEndereco, bairro, estado, isPrincipal, idUsuario) " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ps.setString(1, endereco.getCep());
        ps.setString(2, endereco.getNomeEndereco());
        ps.setString(3, endereco.getBairro());
        ps.setString(4, endereco.getEstado());
        ps.setBoolean(5, endereco.getIsPrincipal());
        ps.setLong(6, endereco.getIdUsuario());
        ps.execute();
    }

    public void removerEnderecoPorIdUsuario(Long id, Connection conn) throws SQLException {
        String sqlSelect = "DELETE FROM projeto_crud.tb_enderecos " +
                "WHERE idUsuario = ? ";

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        ps.execute();
    }
}
