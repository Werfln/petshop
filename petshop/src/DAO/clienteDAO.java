/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class clienteDAO {
    private int sucesso=0;
    
    public int cadastrarCliente(Cliente c)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("insert into cliente(nome,email,cpf,idade,telecel) values (?,?,?,?,?)");

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getCPF());
            stmt.setInt(4, c.getIdade());
            stmt.setString(5, c.getTelcel());

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
    
    public List<Cliente> buscarCliente() 
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("Select *  from cliente");
            rs = stmt.executeQuery();

            while (rs.next()) 
            {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setTelcel(rs.getString("telecel"));

                clientes.add(cliente);
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

        return clientes;
    }
    
    public List<Cliente> buscarCliente(int id) 
    {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("Select *  from cliente where id=?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            while (rs.next()) 
            {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setTelcel(rs.getString("telecel"));

                clientes.add(cliente);
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

        return clientes;
    }
    
     public void atualizarCliente(Cliente p) 
    {
        Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            try 
            {
                stmt = con.prepareStatement("UPDATE cliente set nome=?, email=?, cpf=?, idade=?, telecel=? where id=?");
                stmt.setString(1,p.getNome());
                stmt.setString(2,p.getEmail());
                stmt.setString(3,p.getCPF());
                stmt.setInt(4,(int)p.getIdade());
                stmt.setString(5,p.getTelcel());
                stmt.setInt(6,p.getId());
                stmt.executeUpdate();
            } 
            catch (SQLException ex)
            {
                Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            } 
            finally 
            {
                ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
            }
    }
     
    public void deletarCliente(int id) 
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt= null;
        try
        {
            stmt= con.prepareStatement("DELETE from cliente where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso");
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
