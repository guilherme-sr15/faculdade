package br.edu.ifsp.arq.ads.poo.entidades;

import br.edu.ifsp.arq.ads.poo.gerenciadores.GerenciaListaExemplares;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno Siqueira
 */
public abstract class Obras implements Cloneable{

    private static int codigoSequencial = 0;
    private final int codigo;
    private String titulo;
    private final String tipo;
    private final GerenciaListaExemplares gerenciaListaExemplares;

    /**
     * @return the gerenciaListaExemplares
     */
    public GerenciaListaExemplares getGerenciaListaExemplares() {
        return gerenciaListaExemplares;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    public Obras(String titulo,String tipo) {
        this.titulo = titulo;
        codigo = ++codigoSequencial;
        gerenciaListaExemplares = new GerenciaListaExemplares();
        this.tipo = tipo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    public void addExemplar(Exemplar ex) {
        gerenciaListaExemplares.addExemplar(ex);
    }

    @Override
    public String toString() {
        return "Obras:" + "\nCodigo:" + codigo + "\nTitulo:" + titulo + "\n" + gerenciaListaExemplares;
    }

    public Obras retornaClone () {
      try {
        return (Obras)this.clone();
      }
      catch (CloneNotSupportedException ex) {
        ex.printStackTrace();
        return null;
      }
    }

    public String getTipo() {
        return tipo;
    }
    
}
