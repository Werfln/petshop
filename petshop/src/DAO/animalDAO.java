/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Animal;
import beans.Cliente;
import connection.ConnectionFactory;
import java.sql.Connection;
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
public class animalDAO {
    private int sucesso=0;
    
    public int cadastrarAnimal(Animal a, int id)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("insert into animal(tipo,idade,raca,idCliente) values (?,?,?,?)");

            stmt.setString(1, a.getTipo());
            stmt.setInt(2, a.getIdade());
            stmt.setString(3, a.getRaca());
            stmt.setInt(4,id);

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
    
    public List<Animal> buscarAnimal(int id) 
    {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Animal> animais = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("Select *  from animal where idCliente=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) 
            {

                Animal animal = new Animal();

                animal.setId(rs.getInt("id"));
                animal.setTipo(rs.getString("tipo"));
                animal.setIdade(rs.getInt("idade"));
                animal.setRaca(rs.getString("raca"));

                animais.add(animal);
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

        return animais;
    }
    
    public void deletarAnimal(int id) 
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt= null;
        try
        {
            stmt= con.prepareStatement("DELETE from animal where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Animal excluido com sucesso");
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } 
        finally
        {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection)con,stmt);
        }
    }
}
