package com.crud.ProjetoCrudApi.dao;

import com.crud.ProjetoCrudApi.dto.EntidadeListaDTO;
import com.crud.ProjetoCrudApi.mapper.DTOMapper;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    @Inject
    private ConnectionDAO connectionDAO;

    @Inject
    private DTOMapper DTOMapper;

    public List<EntidadeListaDTO> listaDtos() throws SQLException {
        String sqlSelect = "SELECT * FROM projeto_crud.view_lista";

        Connection conn = connectionDAO.criarConexao();
        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ResultSet rs = ps.executeQuery();
        List<EntidadeListaDTO> listaEntidade = new ArrayList<>();

        while (rs.next()) {
            listaEntidade.add(DTOMapper.mapListaLinhaConsulta(rs));
        }

        conn.close();
        return listaEntidade;
    }
}
