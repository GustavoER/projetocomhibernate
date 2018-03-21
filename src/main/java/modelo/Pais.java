package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pais implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "iso", nullable = false, length = 3)
    private String iso;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;

        if (id != pais.id) return false;
        if (nome != null ? !nome.equals(pais.nome) : pais.nome != null) return false;
        return iso != null ? iso.equals(pais.iso) : pais.iso == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (iso != null ? iso.hashCode() : 0);
        return result;
    }

    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}
