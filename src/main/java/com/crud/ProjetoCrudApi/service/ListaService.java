package com.crud.ProjetoCrudApi.service;

import com.crud.ProjetoCrudApi.dao.FormDAO;
import com.crud.ProjetoCrudApi.dao.ListaDAO;
import com.crud.ProjetoCrudApi.dto.EntidadeFormDTO;
import com.crud.ProjetoCrudApi.dto.EntidadeListaDTO;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class ListaService {


    @Inject
    private ListaDAO listaDAO;

    public List<EntidadeListaDTO> ListarUsuarios() throws SQLException {
        return listaDAO.listaDtos();
    }
}
