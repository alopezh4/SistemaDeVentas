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
public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public Empleado validar(String user, String dni){
        Empleado em=new Empleado();
        try {
            String sql="SELECT* from empleado WHERE User=? AND Dni=?";
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return em;
    }
    
    public List listar(){
        String sql="select * from empleado";
        List<Empleado> lista=new ArrayList();
        
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int agregar(Empleado e){
        String sql="insert into Empleado(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getTel());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getUser());
            r=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    public int actualizar(Empleado e){
        String sql="update Empleado set Dni=?,Nombres=?,Telefono=?,Estado=?,User=? where IdEmpleado=?";
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getTel());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getUser());
            ps.setInt(6, e.getId());
            r=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    public Empleado listarId(int id){
        String sql="select * from Empleado where IdEmpleado="+id;
        Empleado emp=new Empleado();
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return emp;
    }
    
    public void delete(int id){
        String sql="delete from Empleado where IdEmpleado="+id;
        con=cn.Conexion();
        try {
            ps=con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
