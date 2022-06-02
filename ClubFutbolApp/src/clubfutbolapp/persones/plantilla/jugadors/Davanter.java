/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubfutbolapp.persones.plantilla.jugadors;

/**
 *
 * @author marpo
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
import clubfutbolapp.validacions.Correu;
import clubfutbolapp.validacions.Dni;
import clubfutbolapp.validacions.Telefon;

public class Davanter extends Jugador implements Serializable{
    private int gols;
    private int balonsRecuperats;
    private static int incentiuGols = 1000;
    private static int incentiuBR = 300;
   

    public Davanter(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, int souBase, boolean esTitular, int gols,
            int balonsRecuperats) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase, esTitular);
        this.gols = gols;
        this.balonsRecuperats = balonsRecuperats;
        calcularSouIncentivat();
    }

    public Davanter() {

    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    public Davanter altaDavanter() {
        altaJugador();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.print("Escriu els gols anotats: ");
        setGols(sc.nextInt());

        System.out.print("Escriu els balons recuperats: ");
        setBalonsRecuperats(sc.nextInt());
        calcularSouIncentivat(); 
        return this;
    }

    @Override
    public void modificar() {
        super.modificar();
        Scanner sc = new Scanner(System.in);
        System.out.print("Gols del jugador: ");
        int gols = sc.nextInt();
        setGols(gols);

        System.out.print("Balons recuperats: ");
        int balonsRec = sc.nextInt();
        setBalonsRecuperats(balonsRec);
        
        calcularSouIncentivat();
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nBalons Recuperats: " + balonsRecuperats + "\nGols: " + gols;
    }
    
     @Override
    public void calcularSouIncentivat() {
        setSouIncentivat(getSouBase() + (gols * incentiuGols) + (balonsRecuperats * incentiuBR));
        
    }
    
}
