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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class VentaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public String generarserie(){
        String numeroserie=null;
        String sql="select max(NumeroSerie) from ventas";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numeroserie;
    }
    
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idventas=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idventas;
    }
    
    public int guardarventa(Venta v){
          String sql="insert into ventas(IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado)values(?,?,?,?,?,?)";
          con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdempleado());
            ps.setString(3, v.getNumserie());
            ps.setString(4,v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            r=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;          
    }
    
    public int guardardetalleventa(Venta v){
        String sql="insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)value(?,?,?,?)";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setInt(2, v.getIdproducto());
            ps.setInt(3, v.getCantidad());
            ps.setDouble(4, v.getPrecio());
            r=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return r;
    }
}
