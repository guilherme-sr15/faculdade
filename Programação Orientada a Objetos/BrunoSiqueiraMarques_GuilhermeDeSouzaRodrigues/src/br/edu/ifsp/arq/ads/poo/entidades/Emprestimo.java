/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import br.edu.ifsp.arq.ads.poo.bancos.BancoObrasBiblioteca;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusDisp;
import br.edu.ifsp.arq.ads.poo.gerenciadores.GerenciaExemplaresEmprestimo;

/**
 *
 * @author Bruno Siqueira
 */
public abstract class Emprestimo {

    private final Calendar dataEmprestimo;
    private final Calendar dataDevolucao;
    private final Usuarios usuario;
    private final GerenciaExemplaresEmprestimo exemplaresEmprestados;

    public Emprestimo(int dataDevolucao, Usuarios usuario) {
        this.dataEmprestimo = GregorianCalendar.getInstance();
        this.dataDevolucao = calculaDataDevolucao(dataDevolucao);
        this.usuario = usuario;
        this.exemplaresEmprestados = new GerenciaExemplaresEmprestimo();
    }

    public abstract boolean emprestimo(int idObra, int nroExemplar);

    public abstract int nrMaxExemplares();

    private Calendar calculaDataDevolucao(int qtdDias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataEmprestimo.getTime());
        cal.add(Calendar.DAY_OF_MONTH, qtdDias);
        return cal;
    }

    public boolean acaoEmprestimo(int idObra, int nroExemplar) {
        int qtdObras = calcularQtdObrasDoUsuario();

        if (qtdObras < nrMaxExemplares()) {

            BancoObrasBiblioteca obras = BancoObrasBiblioteca.getInstance();

            Obras obraDoBanco = obras.busca(idObra);

            if (obraDoBanco != null) {
                Obras obraParaAdicionar = obraDoBanco.retornaClone();

                Exemplar exemplar = obraDoBanco.getGerenciaListaExemplares().busca(nroExemplar);

                if (exemplar != null && exemplar.getStatus() != EnumStatusDisp.EMPRESTADO) {

                    if (this.exemplaresEmprestados.add(exemplar)) {
                        exemplar.setStatus(EnumStatusDisp.EMPRESTADO);
                        return true;
                    }

                }
            }
        }
        return false;
    }
    public boolean verificarAtrasosNosEmprestimos(Calendar cal) {
        List<Emprestimo> listaObrasUsuario = this.getUsuario().getEmprestimos().getListaEmprestimos();
        for (Emprestimo emprestimo : listaObrasUsuario) {
            if(!emprestimo.verificarAtrasDeUmEmprestimo(cal)){
                return false;
            }
        }
        return true;
    }
    
    public int calcularQtdObrasDoUsuario(){
        int acumulador=0;
        
        List<Emprestimo> lista = usuario.getEmprestimos().getListaEmprestimos();
        for (Emprestimo emprestimo : lista) {
            Set<Exemplar> lista2 = emprestimo.getExemplaresEmprestados().getListaObrasUsuario();
            for (Exemplar exemplar : lista2) {
                acumulador++;
            }
        }
        return acumulador;
    }
    
    public boolean verificarAtrasDeUmEmprestimo(Calendar cal) {
        int i = this.getDataDevolucao().compareTo(cal);
        if (i != -1) {// testa se não tem atraso nos emprestimos do usuario
            return false;
        }
        return true;
    }    
    /**
     * @return the dataDevolucao
     */
    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @return the usuario
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     * @return the exemplaresEmprestados
     */
    public GerenciaExemplaresEmprestimo getExemplaresEmprestados() {
        return exemplaresEmprestados;
    }

    /**
     * @return the dataEmprestimo
     */
    public Calendar getDataEmprestimo() {
        return dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "dataEmprestimo=" + dataEmprestimo.getTime() + ", dataDevolucao=" + dataDevolucao.getTime() + ", usuario=" + usuario + ", exemplaresEmprestados=" + exemplaresEmprestados + '}';
    }
    
}
