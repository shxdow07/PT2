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

public class Migcampista extends Jugador implements Serializable{
    private int assistencies;
    private int balonsRecuperats;
    private static int incentiuAssist = 200;
    private static int incentiuBR = 100;
    

    public Migcampista(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, int souBase, boolean esTitular, int assistencies,
            int balonsRecuperats) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase, esTitular);
        this.assistencies = assistencies;
        this.balonsRecuperats = balonsRecuperats;
        calcularSouIncentivat();
    }

    public Migcampista() {
        
    }

    public int getAssistencies() {
        return assistencies;
    }

    public void setAssistencies(int assistencies) {
        this.assistencies = assistencies;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }


    public Migcampista altaMigcampista() {
        altaJugador();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.print("Escriu les assistències: ");
        setAssistencies(sc.nextInt());
        System.out.print("Escriu els balons recuperats: ");
        setBalonsRecuperats(sc.nextInt());
        return this;
    }

    @Override
    public void modificar() {
        super.modificar();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nº assistències: ");
        int assistencies = sc.nextInt();
        setAssistencies(assistencies);

        System.out.println("Balons recuperats");
        int br = sc.nextInt();
        setBalonsRecuperats(br);

        calcularSouIncentivat();
    }
    
    @Override
    public void calcularSouIncentivat() {
        setSouIncentivat(getSouBase() + (assistencies * incentiuAssist) + (balonsRecuperats * incentiuBR));;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "\nAssistencies: " + assistencies + "\nBalons Recuperats: " + balonsRecuperats;
    }

    
}