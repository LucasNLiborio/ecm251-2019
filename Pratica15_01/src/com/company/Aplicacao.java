package com.company;

import auxiliar_database.UsuariosDAO;
import model.Usuario;
import utilities.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private UsuariosDAO usuariosDAO;
    private List<Usuario> users;
    private Usuario user;
    public Aplicacao(){
        usuariosDAO = new UsuariosDAO(Constants.URL_MEU_BANCO);
        users = new ArrayList<>();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        do{
            menu();
            int op = scanner.nextInt();
            int id;
            Usuario resultUser;
            switch (op){
                case 1:
                    String nome, email, senha;
                    System.out.println("Informe:");
                    nome = scanner.next();
                    email = scanner.next();
                    senha = scanner.next();
                    Usuario user = new Usuario(
                            nome, email, senha
                    );
                    usuariosDAO.insertUsuario(user);
                    break;
                    case 2:
                        users = usuariosDAO.getAllUsuario();
                        for (Usuario u : users) {
                            System.out.print("ID: " + u.id);
                            System.out.println(" Nome: " + u.nome);
                        }
                    break;
                case 3:
                        System.out.println("Informe o ID: ");
                        id = scanner.nextInt();
                        resultUser = usuariosDAO.getUsuario(id);
                        if(resultUser == null)
                        {
                            System.out.println("Usuário não cadastrado");
                        }
                        else
                        {
                            System.out.println("ID: " + resultUser.id);
                            System.out.println(" Nome: " + resultUser.nome);
                        }
                case 4:
                    System.out.println("Informe o ID: ");
                    id = scanner.nextInt();
                    resultUser = usuariosDAO.getUsuario(id);
                    if(resultUser == null)
                    {
                        System.out.println("Usuário não cadastrado");
                    }
                    else{
                        System.out.println("ID: " + resultUser.id);
                        System.out.println(" Nome: " + resultUser.nome);
                        System.out.println(" Email: " + resultUser.email);
                        System.out.println("Qual campo atualizar?: ");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Email");
                        System.out.println("3 - Senha");
                        op = scanner.nextInt();
                        System.out.println("Novo Valor:");
                        String temp = scanner.next();
                        switch (op){
                            case 1: resultUser.nome = temp; break;
                            case 2: resultUser.email = temp; break;
                            case 3: resultUser.senha = temp; break;
                        }
                        if(usuariosDAO.updateUserById(resultUser))
                            System.out.println("Atualizado com sucesso");
                        else
                            System.out.println("Falha na atualização");
                    }
                    break;
                case 5:
                    System.out.println("ID para deletar: ");
                    id = scanner.nextInt();
                    usuariosDAO.deleteUserById(id);
                    break;
            }
            if(op == 0) break;
        }while(true);
    }
    public void menu(){
        System.out.println("1 - Inserir Usuario");
        System.out.println("2 - Mostrar todos os usuarios");
        System.out.println("3 - Buscar usuario");
        System.out.println("4 - Atualizar usuario");
        System.out.println("5 - Remover usuario");
        System.out.println("0 - Sair");
    }
}
