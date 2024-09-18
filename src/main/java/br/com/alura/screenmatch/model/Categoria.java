package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action"),
    COMEDIA("Comedy"),
    ROMANCE("Romance"),
    CRIME("Crime"),
    DRAMA("Drama");

    private String categoriaOmdb;

    Categoria(String categoriaOmdbd){
        this.categoriaOmdb = categoriaOmdbd;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
