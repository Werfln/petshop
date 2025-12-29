/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Produto;
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
public class produtoDAO {
    private int sucesso=0;
    
    public int cadastrarProduto(Produto p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("insert into produto(nome,preco,descricao) values (?,?,?)");

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setString(3, p.getDescricao());

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
    
    public List<Produto> buscarProduto() 
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("Select *  from produto");
            rs = stmt.executeQuery();

            while (rs.next()) 
            {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setDescricao(rs.getString("descricao"));

                produtos.add(produto);
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

        return produtos;
    }
    
    public List<Produto> buscarProduto(String nome) 
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("Select *  from produto where nome=?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) 
            {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
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

        return produtos;
    }
    
    
}
