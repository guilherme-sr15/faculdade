/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

import java.util.Calendar;

/**
 *
 * @author Bruno Siqueira
 */
public class MultaLivro extends Multa{
    private final int multa = 2;
    
    @Override
    public Number calcularMulta(Emprestimo emp, Calendar dataAtoDevolucao) {
        int diasAtraso;
        int anos;
        diasAtraso = calcularDiasAtraso(emp, dataAtoDevolucao);
        anos = (int) diasAtraso/365;
        
        return diasAtraso*(multa+anos);
    }
    
}
