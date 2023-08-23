/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Clientes;
import modelo.ClientesDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;

/**
 *
 * @author user
 */
public class Controlador extends HttpServlet {
    
    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    
    Producto pr=new Producto();
    ProductoDAO pdao=new ProductoDAO();
    
    Clientes cl=new Clientes();
    ClientesDAO cdao=new ClientesDAO();
    
    Venta v=new Venta();
    List<Venta> lista=new ArrayList();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao=new VentaDAO();
    
    int ide;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if(menu.equals("principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("Producto")){
            switch(accion){
                case "Listar":
                    List lista1=pdao.listar();
                    request.setAttribute("productos", lista1);
                    break;
                case "Agregar":
                    String nomb=request.getParameter("txtNombre");
                    String precio=request.getParameter("txtPrecio");
                    String stock=request.getParameter("txtStock");
                    String est=request.getParameter("txtEstado");
                    pr.setNom(nomb);
                    pr.setPrecio(Integer.parseInt(precio));
                    pr.setStock(Integer.parseInt(stock));
                    pr.setEstado(est);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Producto obj=pdao.listarId(ide);
                    request.setAttribute("producto", obj);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomb1=request.getParameter("txtNombre");
                    String precio1=request.getParameter("txtPrecio");
                    String stock1=request.getParameter("txtStock");
                    String est1=request.getParameter("txtEstado");
                    pr.setNom(nomb1);
                    pr.setPrecio(Integer.parseInt(precio1));
                    pr.setStock(Integer.parseInt(stock1));
                    pr.setEstado(est1);
                    pr.setId(ide);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    pdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("Clientes")){
            switch(accion){
                case "Listar":
                    List lista2=cdao.listar();
                    request.setAttribute("clientes", lista2);
                    break;
                case "Agregar":
                    String dni1=request.getParameter("txtDni");
                    String nomb2=request.getParameter("txtNombre");                   
                    String dir2=request.getParameter("txtDireccion");
                    String est2=request.getParameter("txtEstado");
                    cl.setDni(Integer.parseInt(dni1));
                    cl.setNom(nomb2);
                    cl.setDir(dir2);
                    cl.setEstado(est2);
                    cdao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Clientes c=cdao.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni2=request.getParameter("txtDni");
                    String nomb3=request.getParameter("txtNombre");                   
                    String dir3=request.getParameter("txtDireccion");
                    String est3=request.getParameter("txtEstado");
                    cl.setDni(Integer.parseInt(dni2));
                    cl.setNom(nomb3);
                    cl.setDir(dir3);
                    cl.setEstado(est3);
                    cl.setId(ide);
                    cdao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if(menu.equals("Empleado")){
            switch(accion){
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados", lista);                   
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTelefono");
                    String est=request.getParameter("txtEstado");
                    String user=request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String tel1=request.getParameter("txtTelefono");
                    String est1=request.getParameter("txtEstado");
                    String user1=request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if(menu.equals("RegistrarVenta")){
            switch(accion){
                case "BuscarCliente":
                    int nuevo=Integer.parseInt(request.getParameter("codigocliente"));
                    cl=cdao.buscar(nuevo);
                    request.setAttribute("c", cl);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    pr=pdao.listarId(id);
                    request.setAttribute("producto", pr);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("c", cl);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    request.setAttribute("c", cl);
                    totalPagar=0;
                    item=item+1;
                    cod=pr.getId();
                    descripcion=request.getParameter("nombresproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*cant;
                    v=new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for(int i=0 ; i<lista.size() ; i++){
                        totalPagar=totalPagar+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "GenerarVenta":
                    
                    for(int i=0 ; i<lista.size() ; i++){
                        Producto p=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO dao=new ProductoDAO();
                        p=dao.buscar(idproducto);
                        int sac=p.getStock()-cantidad;
                        System.out.println(sac+" "+idproducto);
                        dao.actualizarstock(idproducto, sac);
                    }
                    
                    v.setIdcliente(cl.getId());
                    v.setIdempleado(1);
                    v.setNumserie(numeroserie);
                    v.setFecha("2022-02-27");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarventa(v);
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for(int i=0 ; i<lista.size() ; i++){
                        v=new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(ide).getPrecio());
                        vdao.guardardetalleventa(v);
                    }
                    request.setAttribute("nserie", numeroserie);
                    break;
                default:
                    numeroserie=vdao.generarserie();
                    if(numeroserie==null){
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }else{
                        int incrementar;
                        System.out.println(numeroserie);
                        incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs=new GenerarSerie();
                        numeroserie=gs.numeroserie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
