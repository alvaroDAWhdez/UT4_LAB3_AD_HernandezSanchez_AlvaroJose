/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Entity.HibernateUtil;
import Entity.Nave;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author alvaro
 */
public class HoloNetControl {
    
    //Desafio 1
    public List<Nave> obtenerNavesPorBandoPlaneta(String bando){        
        String query = "FROM Nave n "
                + "INNER JOIN n.planetaOrigen p "
                + "WHERE p.afiliacion = :afiliacionPlaneta "
                + "AND n.estadoSistema != 'Mantenimiento' ";
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Nave> queryFiltro = session.createQuery(query, Nave.class);
            queryFiltro.setParameter("afiliacionPlaneta", bando);
            
            return queryFiltro.getResultList();
        } catch (Exception e) {
            System.err.println("❌ Error en el escaneo avanzado de uniones HQL: " + e.getMessage());
            return List.of();
        } 
        
    }
    
    //Desafio 2
 
    public List<Nave> obtenerFlotaCriticaConPlaneta(){
        String query = "FROM Nave n "
                + "INNER JOIN FETCH n.planetaOrigen p "
                + "WHERE estadoSistema = 'Critico' ";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Nave> queryFiltro = session.createQuery(query, Nave.class);
            
            return queryFiltro.getResultList();
        } catch (Exception e) {
            System.err.println("❌ Error en el escaneo avanzado de uniones HQL: " + e.getMessage());
            return List.of();
        } 
    }
    
    //Desafio 3
    //Como hibernate mapea sobre una entidad, por ejemplo Nave, hara falta hacer uso de Object[] para poder almacenar el objeto de Nave y Planeta
    public List<Object[]> obtenerReportePlanetasAsignados(){
        String query ="SELECT p.nombrePlaneta, n.nombre "
                + "FROM Nave n "
                + "LEFT JOIN n.planetaOrigen p";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Object[]> queryFiltro = session.createQuery(query, Object[].class);
            
            return queryFiltro.getResultList();
        } catch (Exception e) {
            System.err.println("❌ Error en el escaneo avanzado de uniones HQL: " + e.getMessage());
            return List.of();
        } 
    }
    
}
