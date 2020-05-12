package br.sc.senai.dao;

import br.sc.senai.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("users-db");

        entityManager = factory.createEntityManager();

        insert();

//        Usuario usuario = new Usuario();
//        usuario.setEmail("arthur@gmail.com");
//        usuario.setNome("Arthur Felix");
//        usuario.setSenha("12345");
//
//        boolean found = login(usuario);
//
//        if(found) {
//            System.out.println("Login efetuado com sucesso");
//        } else {
//            System.out.println("Usuário e/ou senha inválidos");
//        }

        entityManager.close();
        factory.close();
    }

    public static void insert() {
        try {
            entityManager.getTransaction().begin();

            Usuario novoUsuario = new Usuario();
            novoUsuario.setEmail("arthur@gmail.com");
            novoUsuario.setNome("Arthur Felix");
            novoUsuario.setSenha("12345");

            entityManager.persist(novoUsuario);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("O email informado já está em uso");
        }
    }

    public static boolean login(Usuario usuario) {
        boolean found = true;

        try {
            Query q = entityManager.createNamedQuery("Usuario.login");

            q.setParameter("email", usuario.getEmail());
            q.setParameter("senha", usuario.getSenha());

            Usuario usuarioLogin = (Usuario) q.getSingleResult();

            System.out.println("O usuário logado é: " + usuarioLogin.getNome());
        } catch (Exception e) {
//            e.printStackTrace();
            found = false;
        }

        return found;
    }
}
