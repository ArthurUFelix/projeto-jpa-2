package br.sc.senai.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@NamedQueries({
        @NamedQuery(name="Usuario.login", query="select u from Usuario u where u.email = :email and u.senha = :senha"),
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    @Column(length=40)
    private String nome;

    @Column(length=12)
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
