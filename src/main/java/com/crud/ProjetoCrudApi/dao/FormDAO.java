package com.crud.ProjetoCrudApi.dao;

import com.crud.ProjetoCrudApi.dto.EntidadeFormDTO;
import com.crud.ProjetoCrudApi.mapper.DTOMapper;
import com.crud.ProjetoCrudApi.model.Endereco;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormDAO {


    @Inject
    private DTOMapper DTOMapper;

    public List<EntidadeFormDTO> listaDtos(Long id, Connection conn) throws SQLException {
        String sqlSelect = "SELECT * FROM projeto_crud.view_form";
        sqlSelect = sqlSelect.concat(" WHERE idUsuario = " + id.toString());

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ResultSet rs = ps.executeQuery();
        List<EntidadeFormDTO> listaEntidade = new ArrayList<>();

        while (rs.next()) {
            listaEntidade.add(DTOMapper.mapFormLinhaConsulta(rs));
        }
        return listaEntidade;
    }

    public Long verificarUltimoId(Connection conn) throws SQLException {
        String sqlSelect = "SELECT MAX(idUsuario) as id FROM projeto_crud.tb_clientes";

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ResultSet rs = ps.executeQuery();
        List<Long> listaInt= new ArrayList<>();

        while (rs.next()) {
            listaInt.add(rs.getLong("id"));
        }
        return listaInt.get(0);
    }

    public void inserirCredencial(EntidadeFormDTO entidadeFormDTO, Connection conn) throws SQLException {
        String sqlSelect = "INSERT INTO projeto_crud.tb_credenciais (usuario, senha, idPerfil) " +
                "VALUES(?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ps.setString(1, entidadeFormDTO.getUsuario());
        ps.setString(2, entidadeFormDTO.getSenha());
        ps.setLong(3, entidadeFormDTO.getIdPerfil());
        ps.execute();
    }

    public void inserirCliente(EntidadeFormDTO entidadeFormDTO, Connection conn) throws SQLException {
        String sqlSelect = "INSERT INTO projeto_crud.tb_clientes " +
                "(idUsuario, nomeCliente, sobrenome, dataNascimento, telefone, cpf, rg) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ps.setLong(1, entidadeFormDTO.getIdUsuario());
        ps.setString(2, entidadeFormDTO.getNomeCliente());
        ps.setString(3, entidadeFormDTO.getSobrenome());
        ps.setTimestamp(4, entidadeFormDTO.getDataNascimento());
        ps.setString(5, entidadeFormDTO.getTelefone());
        ps.setString(6, entidadeFormDTO.getCpf());
        ps.setString(7, entidadeFormDTO.getRg());
        ps.execute();
    }

    public void removerCredencial(Long id, Connection conn) throws SQLException {
        String sqlSelect = "DELETE FROM projeto_crud.tb_credenciais " +
                "WHERE idUsuario = ? ";

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        ps.execute();
    }

    public void removerCliente(Long id, Connection conn) throws SQLException {
        String sqlSelect = "DELETE FROM projeto_crud.tb_clientes " +
                "WHERE idUsuario = ?";

        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        ps.execute();
    }
}
