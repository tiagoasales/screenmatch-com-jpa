package br.com.alura.screenmatch.model;

import java.util.OptionalDouble;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private String poster;

    @Enumerated(EnumType.STRING)
    private Categoria genero;

    private String atores;

    private String sinopse;

    private Integer totalTemporadas;

    private Double avaliacao;

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.poster = dadosSerie.poster();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        // this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim();
        this.sinopse = dadosSerie.sinopse();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPoster() {
        return poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public String getAtores() {
        return atores;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Serie [titulo=" + titulo + ", poster=" + poster + ", genero=" + genero + ", atores=" + atores
                + ", sinopse=" + sinopse + ", totalTemporadas=" + totalTemporadas + ", avaliacao=" + avaliacao + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
