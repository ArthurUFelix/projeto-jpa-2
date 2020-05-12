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

        entityManager.close();
        factory.close();
    }

    public static void insert() {
        entityManager.getTransaction().begin();

        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail("pedro@gmail.com");
        novoUsuario.setNome("Pedro Moratelli");
        novoUsuario.setSenha("12345");

        entityManager.persist(novoUsuario);

        entityManager.getTransaction().commit();
    }
}
