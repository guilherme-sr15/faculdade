/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DênisLeonardo
 */

import java.util.ArrayList;

public class ListaNome {
    
    private ArrayList<String> lista;
    
    public ListaNome() {
        lista = new ArrayList<>();
    }
    
    public boolean addNome(String nome) {
        if(nome != null && !nome.trim().isEmpty()) {
           return lista.add(nome);
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        for(String nome: lista) {
            builder.append(nome);
            builder.append("\n");
        }
        return builder.toString();
    }
}
