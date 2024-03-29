package com.company;

public abstract class Usuário implements Autenticar{
    protected String nome, email, senha;

    public Usuário(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
}
