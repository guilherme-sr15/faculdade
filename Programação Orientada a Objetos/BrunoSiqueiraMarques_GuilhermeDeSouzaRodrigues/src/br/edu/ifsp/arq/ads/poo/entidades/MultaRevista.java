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
public class MultaRevista extends Multa {

    private final float multa = 0.5f;

    @Override
    public Number calcularMulta(Emprestimo emp, Calendar dataAtoDevolucao) {
        return multa * this.calcularDiasAtraso(emp, dataAtoDevolucao);
    }
}
