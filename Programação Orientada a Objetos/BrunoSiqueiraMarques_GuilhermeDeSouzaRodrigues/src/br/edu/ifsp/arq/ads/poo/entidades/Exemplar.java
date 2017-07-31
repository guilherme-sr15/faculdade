/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusDisp;
import java.util.Objects;

/**
 *
 * @author Bruno Siqueira
 */
public class Exemplar implements Comparable<Exemplar>{

    private final int codigo;
    private EnumStatusDisp status;
    private final Obras obraDoExemplar;

    public Exemplar(int codigo,Obras obraDoExemplar) {
        this.codigo = codigo;
        this.status = EnumStatusDisp.DISPONIVEL;
        this.obraDoExemplar = obraDoExemplar;
    }

    /**
     * @return the status
     */
    public EnumStatusDisp getStatus() {
        return status;
    }

    public boolean exists(Exemplar e) {
        return e.getCodigo() == this.getCodigo();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(EnumStatusDisp status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.obraDoExemplar);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exemplar other = (Exemplar) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Exemplar{" + "codigo=" + codigo + ", status=" + status + ", titulo da obra=" + getObraDoExemplar().getTitulo() + '}';
    }



    @Override
    public int compareTo(Exemplar o) {
         return Integer.compare(this.codigo, o.codigo);
    }

    /**
     * @return the obraDoExemplar
     */
    public Obras getObraDoExemplar() {
        return obraDoExemplar;
    }

}
