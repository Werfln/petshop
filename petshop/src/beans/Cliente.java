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
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String CPF;
    private int idade;
    private String telcel;

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
     * @return the nome
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) 
    {
        this.email = email;
    }

    /**
     * @return the CPF
     */
    public String getCPF() 
    {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) 
    {
        this.CPF = CPF;
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

    /**
     * @return the telcel
     */
    public String getTelcel() 
    {
        return telcel;
    }

    /**
     * @param telcel the telcel to set
     */
    public void setTelcel(String telcel) 
    {
        this.telcel = telcel;
    }
}
