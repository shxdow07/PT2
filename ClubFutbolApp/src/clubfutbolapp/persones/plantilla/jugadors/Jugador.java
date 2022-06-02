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
import clubfutbolapp.persones.plantilla.Plantilla;
import clubfutbolapp.validacions.Correu;
import clubfutbolapp.validacions.Dni;
import clubfutbolapp.validacions.Telefon;

public abstract class Jugador extends Plantilla implements Serializable{
    private static int dorsals;
    private int dorsal;
    private boolean esTitular;
    public Jugador(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, double souBase, boolean esTitular) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase);
        this.dorsal = ++dorsals;
        this.esTitular = esTitular;
    }

    public Jugador() {

    }

    @Override
    public String toString() {
        return super.toString() + "\nDorsal: " + dorsal + "\nÉs titular: " + esTitular;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public static int getDorsals() {
        return dorsals;
    }

    public boolean getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(boolean esTitular) {
        this.esTitular = esTitular;
    }

    public static void setDorsals(int dorsals) {
        Jugador.dorsals = dorsals;
    }

    public void altaJugador() {
        altaTreballador();
        boolean valid = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--------------------------------");
            System.out.print("El jugador és titular? (S/N)");
            char titular = Character.toUpperCase(sc.nextLine().charAt(0));

            if (titular == 'S') {
                setEsTitular(true);
                valid = true;
            } else if (titular == 'N') {
                setEsTitular(false);
                valid = true;
            } else {
                System.out.println("Valor no vàlid");
            }
        } while (!valid);
    }

    @Override
    public void modificar() {
        super.modificar();
        Scanner sc = new Scanner(System.in);
        boolean valid = false;

        do {
            System.out.print("El jugador és titular? (S/N)");
            char titular = Character.toUpperCase(sc.nextLine().charAt(0));

            if (titular == 'S') {
                setEsTitular(true);
                valid = true;
            } else if (titular == 'N') {
                setEsTitular(false);
                valid = true;
            } else {
                System.out.println("Valor no vàlid");
            }
        } while (!valid);

        calcularSouIncentivat();
    }

    
}