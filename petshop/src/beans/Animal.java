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
public class Animal {
    private int id;
    private String tipo;
    private int idade;
    private String raca;

    /**
     * @return the id
     */
    public int getId() 
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) 
    {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public String getTipo() 
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    /**
     * @return the idade
     */
    public int getIdade() 
    {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) 
    {
        this.idade = idade;
    }
    
    public String getRaca()
    {
        return raca;
    }
    
    public void setRaca(String raca)
    {
        this.raca=raca;
    }
}
