/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.principal;

import java.util.Calendar;
import br.edu.ifsp.arq.ads.poo.entidades.Aluno;
import br.edu.ifsp.arq.ads.poo.bancos.BancoUsuariosBiblioteca;
import br.edu.ifsp.arq.ads.poo.enumeracoes.EnumStatusAluno;
import br.edu.ifsp.arq.ads.poo.entidades.Usuarios;
import br.edu.ifsp.arq.ads.poo.bancos.BancoObrasBiblioteca;
import br.edu.ifsp.arq.ads.poo.entidades.Exemplar;
import br.edu.ifsp.arq.ads.poo.entidades.Obras;
import br.edu.ifsp.arq.ads.poo.entidades.Emprestimo;
import br.edu.ifsp.arq.ads.poo.entidades.EmprestimoAluno;
import br.edu.ifsp.arq.ads.poo.entidades.Livros;
import br.edu.ifsp.arq.ads.poo.interfaceGrafica.JanelaPrincipal;


/**
 *
 * @author Bruno Siqueira
 */
public class Principal {

    public static void main(String[] args) {
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        /*Obras o = new Livros("teste", 1234);
        Obras o2 = new Livros("teste", 12334);
        Exemplar exemplar = new Exemplar(0,o);
        Exemplar exemplar1 = new Exemplar(1,o);

        o.addExemplar(exemplar);
        o.addExemplar(exemplar1);
        BancoObrasBiblioteca bancoObrasBiblioteca = BancoObrasBiblioteca.getInstance();
        bancoObrasBiblioteca.add(o);
        bancoObrasBiblioteca.add(o2);

     //   System.out.println(bancoObrasBiblioteca.busca(0).getGerenciaListaExemplares().getTamanhoLista());
     //   System.out.println(bancoObrasBiblioteca.busca(0).getGerenciaListaExemplares().getListaExemplares());

        Usuarios aluno = new Aluno("123123", EnumStatusAluno.MATRICULADO, "bruno", "13123");
        BancoUsuariosBiblioteca bancoUsuariosBiblioteca = BancoUsuariosBiblioteca.getInstance();
        bancoUsuariosBiblioteca.addUsuario(aluno);

        Emprestimo emp = new EmprestimoAluno(aluno);
        Emprestimo emp2 = new EmprestimoAluno(aluno);

        aluno.add(emp);
        aluno.add(emp2);

        System.out.println(emp.emprestimo(0, 0));
        System.out.println(emp2.emprestimo(0, 0));
        System.out.println(emp);

     //   System.out.println(emp.getDataDevolucao().getTime());

       // Devolucao devolucao = new Devolucao();
     //   devolucao.devolucao(0, 0, Calendar.getInstance());

      //  System.out.println(bancoObrasBiblioteca.busca(0).getGerenciaListaExemplares().getListaExemplares());
        System.out.println(bancoObrasBiblioteca);*/
    }
}
