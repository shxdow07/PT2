/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubfutbolapp.validacions;

/**
 *
 * @author marpo
 */
import java.io.Serializable;

public class Dni implements Serializable{
    private String dni;

   public boolean validarDNI(String DNI){
        String letraMayuscula;
        if(DNI.length() != 9 || Character.isLetter(DNI.charAt(8)) == false ){
        return false;
        }
        letraMayuscula = (DNI.substring(8)).toUpperCase();
        
        if(soloNumeros(DNI) == true && letraDNI(DNI).equals(letraMayuscula)){
            return true;
        } else{
            return false;
        }
        
    }
    
    public boolean soloNumeros(String DNI){
        int i, j = 0;
        String numero = "";
        String miDNI = "";
        String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
        
        for( i=0; i<DNI.length() - 1; i++){
            numero = DNI.substring(i, i+1);
            
            for (j=0; j<unoNueve.length;j++){
                if(numero.equals(unoNueve[j])){
                    miDNI += unoNueve[j];
                }
            }
        }
        
        if(miDNI.length() != 8){
            return false;
        } else{
            return true;
        }
    }
    
    private String letraDNI(String DNI){
        int miDNI = Integer.parseInt(DNI.substring(0,8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        resto = miDNI % 23;
        miLetra = asignacionLetra[resto];
        return miLetra;
        
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public Dni(String dni) {
        this.dni = dni;
    }

    public Dni() {
    }

    @Override
    public String toString() {
        return dni;
    }
    
}