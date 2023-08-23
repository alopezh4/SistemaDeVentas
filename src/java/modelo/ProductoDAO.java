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
public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select * from producto";
        List<Producto> lista=new ArrayList();
        
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pro=new Producto();
                pro.setId(rs.getInt(1));
                pro.setNom(rs.getString(2));
                pro.setPrecio(rs.getInt(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
                lista.add(pro);
            }
        } catch (SQLException ex) {

        }
        return lista;
    }
    
    public int agregar(Producto p){
        String sql="insert into Producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getPrecio());            
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            r=ps.executeUpdate();
        } catch (SQLException ex) {

        }
        
        return r;
    }
    
    public int actualizar(Producto p){
        String sql="update Producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getPrecio());            
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId());
            r=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    public Producto listarId(int id){
        String sql="select * from Producto where IdProducto="+id;
        Producto pro=new Producto();
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                pro.setId(rs.getInt(1));
                pro.setNom(rs.getString(2));
                pro.setPrecio(rs.getInt(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pro;
    }
    
    public void delete(int id){
        String sql="delete from Producto where IdProducto="+id;
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Producto buscar(int id){
        String sql="select * from producto where IdProducto="+id;
        Producto p=new Producto();
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public int actualizarstock(int id,int stock){
        String sql="update producto set Stock=? where IdProducto=?";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            r=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
