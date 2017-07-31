package br.edu.ifsp.arq.ads.poo.bancos;

import br.edu.ifsp.arq.ads.poo.entidades.Usuarios;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno Siqueira
 */
public class BancoUsuariosBiblioteca {

    private final Set<Usuarios> listaUsuarios;
    private static BancoUsuariosBiblioteca gerenciaListaUsuarios;

    private BancoUsuariosBiblioteca() {
        listaUsuarios = new HashSet<>();
    }

    public static BancoUsuariosBiblioteca getInstance() {
        if (getGerenciaListaUsuarios() == null) { //se gerenciaAluno for nula, significa que não criamos ainda uma instância
            gerenciaListaUsuarios = new BancoUsuariosBiblioteca();
        }
        return getGerenciaListaUsuarios(); //apenas retornamos a referência para a instância já criada
    }

    public boolean addUsuario(Usuarios u) {
        if (u != null) {
            return getListaUsuarios().add(u);
        }
        return false;
    }

    /**
     * @return the listaUsuarios
     */
    public Set<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuarios buscaUsuario(String rg){
        for(Usuarios user: listaUsuarios){
            if(rg.equals(user.getRg()))
                return user;
        }
        return null;
    }
    
    /**
     * @return the gerenciaListaUsuarios
     */
    public static BancoUsuariosBiblioteca getGerenciaListaUsuarios() {
        return gerenciaListaUsuarios;
    }
    
}
