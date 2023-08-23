/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ClientesDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select * from cliente";
        List<Clientes> lista=new ArrayList();
        
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Clientes cli=new Clientes();
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getInt(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setEstado(rs.getString(5));
                lista.add(cli);
            }
        } catch (SQLException ex) {

        }
        return lista;
    }
    
    public int agregar(Clientes c){
        String sql="insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getDni()); 
            ps.setString(2, c.getNom());                       
            ps.setString(3, c.getDir());
            ps.setString(4, c.getEstado());
            r=ps.executeUpdate();
        } catch (SQLException ex) {

        }
        
        return r;
    }
    
    public int actualizar(Clientes c){
        String sql="update cliente set Dni=?,Nombres=?,Direccion=?,Estado=? where IdCliente=?";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getDni()); 
            ps.setString(2, c.getNom());                       
            ps.setString(3, c.getDir());
            ps.setString(4, c.getEstado());
            ps.setInt(5, c.getId());
            r=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    public Clientes listarId(int id){
        String sql="select * from cliente where IdCliente="+id;
        Clientes cli=new Clientes();
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getInt(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cli;
    }
    
    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Clientes buscar(int Dni){
        Clientes c=new Clientes();
        String sql="select * from cliente where Dni="+Dni;
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getInt(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
}
