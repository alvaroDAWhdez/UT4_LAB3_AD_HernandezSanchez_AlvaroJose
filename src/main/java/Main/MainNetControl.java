/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controladores.HoloNetControl;
import Entity.Nave;
import java.util.List;

/**
 *
 * @author DAM2P
 */
public class MainNetControl {
    public static void main(String[] args) {
        HoloNetControl controlador = new HoloNetControl();
        
        System.out.println("------ INFORMACION CLASIFICADA SOBRE NAVES Y PLANETAS ------");
        
        System.out.println("DESAFIO 1");
        //Desafio 1. Muestro por pantalla las naves con afiliacion en Imperio y que no este en mantenimiento
        List<Nave> navesBandoBuscadas= controlador.obtenerNavesPorBandoPlaneta("Imperio");
        System.out.println("NAVES PERTENECIENTES AL IMPERIO: ");
        for (Nave navesBandoBuscada : navesBandoBuscadas) {
            System.out.println("Nombre: " + navesBandoBuscada.getNombre() + ". Modelo: " + navesBandoBuscada.getModelo());
        }
        
        
        //Desafio 2. Muestro por pantalla las naves que esten en estado critico
        List<Nave> navesCriticasBuscadas = controlador.obtenerFlotaCriticaConPlaneta();
        for (Nave navesCriticaBuscada : navesCriticasBuscadas) {
            System.out.println("Nombre: " + navesCriticaBuscada.getNombre() + ". Modelo: " + navesCriticaBuscada.getModelo());
        }
        
        //Desafio 3. Muestro por pantalla los planetas y naves que hay en la base de datos
        List<Object[]> navesYPlanetas = controlador.obtenerReportePlanetasAsignados();
        for (Object[] navesYPlaneta : navesYPlanetas) {
            
            String planeta = String.valueOf(navesYPlaneta[0]);
            String nave = String.valueOf(navesYPlaneta[1]);
            
            System.out.println("Nave: " + nave + " | Planeta asignado: " + planeta);
        }
        
        
    }
}
