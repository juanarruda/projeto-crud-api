package com.crud.ProjetoCrudApi.service;

import com.crud.ProjetoCrudApi.dao.ConnectionDAO;
import com.crud.ProjetoCrudApi.dao.EnderecoDAO;
import com.crud.ProjetoCrudApi.dao.FormDAO;
import com.crud.ProjetoCrudApi.dto.EntidadeFormDTO;
import com.crud.ProjetoCrudApi.model.Endereco;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FormService {

    Logger logger = Logger.getLogger("Log");

    @Inject
    private FormDAO formDAO;

    @Inject
    private EnderecoDAO enderecoDAO;

    @Inject
    private ConnectionDAO connectionDAO;

    public List<EntidadeFormDTO> ListarUsuarios(Long id){
            List<EntidadeFormDTO> lista = new ArrayList<>();
            Connection conn = connectionDAO.criarConexao();
        try {
            conn.setAutoCommit(false);
            lista = formDAO.listaDtos(id,conn);
            lista.get(0).setEndereco(enderecoDAO.listaEnderecos(id,conn));
            conn.commit();
            conn.close();
            return lista;
        } catch (SQLException e) {
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException e2) {
                logger.severe(e2.getLocalizedMessage());
                return lista;
            }
            logger.severe(e.getLocalizedMessage());
            return lista;
        }
    }

    public boolean inserirFormulario(EntidadeFormDTO entidadeFormDTO){
        Connection conn = connectionDAO.criarConexao();
        boolean resposta = false;
        try {
            conn.setAutoCommit(false);
            formDAO.inserirCredencial(entidadeFormDTO, conn);
            Long id = formDAO.verificarUltimoId(conn);
            entidadeFormDTO.setIdUsuario(id);
            formDAO.inserirCliente(entidadeFormDTO, conn);
            List<Endereco> enderecoLista = entidadeFormDTO.getEndereco();
            if(verificaEnderecoPrincipalUnico(enderecoLista)){
                for (Endereco endereco : enderecoLista) {
                    endereco.setIdUsuario(id);
                    enderecoDAO.inserirEndereco(endereco, conn);
                }
                conn.commit();
                conn.close();
                resposta = true;
            } else {
                conn.rollback();
                conn.close();
            }
            return resposta;
        } catch (SQLException e) {
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException e2) {
                logger.severe(e2.getLocalizedMessage());
                return resposta;
            }
            logger.severe(e.getLocalizedMessage());
            return resposta;
        }
    }

    public boolean removerFormulario(Long id){
        Connection conn = connectionDAO.criarConexao();
        boolean resposta = false;
        try {
            conn.setAutoCommit(false);
            formDAO.removerCredencial(id, conn);
            formDAO.removerCliente(id, conn);
            enderecoDAO.removerEnderecoPorIdUsuario(id, conn);
            resposta = true;
            return resposta;
        } catch (SQLException e) {
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException e2) {
                logger.severe(e2.getLocalizedMessage());
                return resposta;
            }
            logger.severe(e.getLocalizedMessage());
            return resposta;
        }
    }

    private boolean verificaEnderecoPrincipalUnico(List<Endereco> enderecoLista){
        int verificador = (int) enderecoLista.stream().filter(Endereco::getIsPrincipal).count();
        boolean resposta = true;
        if(verificador != 1) {
            logger.severe("Verificação de endereço falhou!");
            resposta = false;
        }
        return resposta;
    }
}
