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

public class Defensa extends Jugador implements Serializable{
    private int atacsAturats;
    private int balonsRecuperats;
    private static int incentiuAA = 100;
    private static int incentiuBR = 100;
    public int getAtacsAturats() {
        return atacsAturats;
    }

    public void setAtacsAturats(int atacsAturats) {
        this.atacsAturats = atacsAturats;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    public static int getIncentiuAA() {
        return incentiuAA;
    }

    public static void setIncentiuAA(int incentiuAA) {
        Defensa.incentiuAA = incentiuAA;
    }

    public static int getIncentiuBR() {
        return incentiuBR;
    }

    public static void setIncentiuBR(int incentiuBR) {
        Defensa.incentiuBR = incentiuBR;
    }

   
    public Defensa(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, int souBase, boolean esTitular, int atacsAturats,
            int balonsRecuperats) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase, esTitular);
        this.atacsAturats = atacsAturats;
        this.balonsRecuperats = balonsRecuperats;
        calcularSouIncentivat();
    }

    public Defensa() {
        
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtacs Aturats: " + atacsAturats + "\nBalons Recuperats: " + balonsRecuperats;
    }

    public Defensa altaDefensa() {
        altaJugador();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.print("Escriu els atacs aturats: ");
        setAtacsAturats(sc.nextInt());
        System.out.print("Escriu els balons recuperats: ");
        setBalonsRecuperats(sc.nextInt());
        return this;
    }

    @Override
    public void modificar() {
        super.modificar();
        Scanner sc = new Scanner(System.in);
        System.out.print("Atacs aturats: ");
        int aa = sc.nextInt();
        setAtacsAturats(aa);

        System.out.print("Balons recuperats: ");
        int br = sc.nextInt();
        setBalonsRecuperats(br);

        calcularSouIncentivat();
    }
    
     @Override
    public void calcularSouIncentivat() {
        setSouIncentivat(getSouBase() + (atacsAturats * incentiuAA) + (balonsRecuperats * incentiuBR));;
    }

}
