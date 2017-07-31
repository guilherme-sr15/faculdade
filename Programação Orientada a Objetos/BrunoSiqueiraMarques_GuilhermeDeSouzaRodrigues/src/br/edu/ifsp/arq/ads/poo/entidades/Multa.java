/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.entidades;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Bruno Siqueira
 */
public abstract class Multa {
    private int valorMulta;
    public abstract Number calcularMulta(Emprestimo emp,Calendar dataAtoDevolucao);
    
    public int calcularDiasAtraso(Emprestimo emp, Calendar dataAtoDevolucao) {
        int diasAtraso;
        int milisegundoParaDia = (1000*60*60*24);

        Date dataDe = emp.getDataDevolucao().getTime();
        Date dataAte = dataAtoDevolucao.getTime();
        
        return diasAtraso = (int) ((dataAte.getTime() - dataDe.getTime()) / milisegundoParaDia);
    }    
}
