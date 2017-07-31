/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import br.edu.ifsp.arq.ads.poo.bancos.BancoUsuariosBiblioteca;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusDisp;

/**
 *
 * @author Bruno Siqueira
 */
public class Devolucao {
    private float multa;
    
    public boolean devolucao(int idObra, int nroExemplar, Calendar dataAtoDevolucao) {
        Emprestimo emprestimo = buscaEmprestimo(idObra, nroExemplar);
        
        if (emprestimo != null) {
            if (!emprestimo.verificarAtrasDeUmEmprestimo(dataAtoDevolucao)) {
                Exemplar ex = emprestimo.getExemplaresEmprestados().busca(nroExemplar);
                ex.setStatus(EnumStatusDisp.DISPONIVEL);
                return emprestimo.getExemplaresEmprestados().remove(nroExemplar);                
            } else {
                Exemplar ex = emprestimo.getExemplaresEmprestados().busca(nroExemplar);
                multa = new FabricaMulta().
                        getMulta(ex.getObraDoExemplar()).
                        calcularDiasAtraso(emprestimo, dataAtoDevolucao);
        
            }
        }
        return false;
    }
    
    private Emprestimo buscaEmprestimo(int idObra, int nroExemplar) {
        BancoUsuariosBiblioteca bancoUsuariosBiblioteca = BancoUsuariosBiblioteca.getInstance();

        Set<Usuarios> usuariosBiblioteca = bancoUsuariosBiblioteca.getListaUsuarios();

        for (Usuarios usuarios : usuariosBiblioteca){
            List<Emprestimo> listaEmprestimoUsuario = usuarios.getEmprestimos().getListaEmprestimos();
            for (Emprestimo emprestimo : listaEmprestimoUsuario) {
                Set<Exemplar> exemplaresEmprestados = emprestimo.getExemplaresEmprestados().getListaObrasUsuario();
                for (Exemplar exemplaresEmprestado : exemplaresEmprestados) {
                    if(exemplaresEmprestado.getCodigo() == nroExemplar && exemplaresEmprestado.getStatus()==EnumStatusDisp.EMPRESTADO){
                        if(exemplaresEmprestado.getObraDoExemplar().getCodigo()==idObra){
                            return emprestimo;
                        }
                    }
                }

            }
        }
        return null;
    }

    /**
     * @return the multa
     */
    public float getMulta() {
        return multa;
    }
    
    
}
