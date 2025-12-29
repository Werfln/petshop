/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Luan
 */
public class Consulta {
    private int id;
    private String descricao;
    private Date dt_consulta;

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
     * @return the descricao
     */
    public String getDescricao() 
    {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    /**
     * @return the dt_consulta
     */
    public Date getDt_consulta() 
    {
        return dt_consulta;
    }

    /**
     * @param dt_consulta the dt_consulta to set
     */
    public void setDt_consulta(Date dt_consulta) 
    {
        this.dt_consulta = dt_consulta;
    }

}
