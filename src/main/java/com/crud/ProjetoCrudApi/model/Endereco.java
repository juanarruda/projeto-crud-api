package com.crud.ProjetoCrudApi.model;

import java.sql.Timestamp;

public class Endereco {

    private String nomeEndereco;
    private String cep;
    private String bairro;
    private String estado;
    private boolean isPrincipal;
    private Long idUsuario;

    public Endereco(){}

    private long idEndereco;

    public long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(boolean principal) {
        isPrincipal = principal;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


}
