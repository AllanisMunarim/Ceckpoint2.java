package br.com.model;

public class Receita {

    private String titulo;
    private String ingredientes;
    private String preparo;
    private String custo;
    private String categoria;

    public Receita(String titulo, String ingredientes, String preparo, String custo, String categoria) {
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.preparo = preparo;
        this.custo = custo;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
       
        return  titulo + "\nINGREDIENTES:" + ingredientes + "\nPREPARO: " + preparo  + 
        "\nCUSTO: " + custo + "\nCATEGORIA: " + categoria;
    }

}
