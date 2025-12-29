/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Consulta;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class consultaDAO {
    private int sucesso=0;
    
    public int inserirConsulta(Consulta c,int id_animal)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("insert into consulta(descricao,dt_consulta,id_animal) values (?,?,?)");

            stmt.setInt(3,id_animal);
            stmt.setString(1, c.getDescricao());
            stmt.setDate(2,new java.sql.Date(c.getDt_consulta().getTime()));

            stmt.executeUpdate();
        }
        
        catch (SQLException ex) 
        {
            sucesso = 1;
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } 
        finally 
        {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
            return sucesso;
        }
    }
    
     public List<Consulta> buscarConsulta(int id_animal) 
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Consulta> consultas = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("Select *  from consulta where id_animal=?");
            stmt.setInt(1, id_animal);
            rs = stmt.executeQuery();

            while (rs.next()) 
            {

                Consulta consulta = new Consulta();

                consulta.setId(rs.getInt("id"));
                consulta.setDescricao(rs.getString("descricao"));
                consulta.setDt_consulta(rs.getDate("dt_consulta"));

                consultas.add(consulta);
            }

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally 
        {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }

        return consultas;
    }
    
}
