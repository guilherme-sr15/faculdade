/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

/**
 *
 * @author Bruno Siqueira
 */
public class FactoryPanel {
    public PainelAbstrato getPanel(String panel){
        switch (panel){
            case "aluno":
                return new PanelInsercaoAlunos();
            case "professor":
                return new PanelInsercaoProfessor();
            case "livro":
                return new PanelInsercaoLivros();
            case "emprestar":
                return new PanelRealizarEmprestimo();
            case "devolver":
                return new PanelRealizarDevolucao();
        }
        return new PanelInsercaoRevistas();
    }
}
