/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Luan
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private int quantidade;
    private double precoTotal;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getQuantidade()
    {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade)
    {
        this.quantidade=quantidade;
    }
    
    public double getPrecoTotal()
    {
        return precoTotal;
    }
    
    public void setPrecoTotal(double precoTotal)
    {
        this.precoTotal=precoTotal;
    }
}
