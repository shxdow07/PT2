/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubfutbolapp.persones.plantilla.tecnics;

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

public class Entrenador extends Tecnic implements Serializable{
    private int numeroTrofeus;
    private static int incentiuTrofeus = 3000;
    @Override
    public void calcularSouIncentivat() {
        setSouIncentivat(getSouBase() + (getNumeroTrofeus() * incentiuTrofeus));
    }

    public int getNumeroTrofeus() {
        return numeroTrofeus;
    }

    public void setNumeroTrofeus(int numeroTrofeus) {
        this.numeroTrofeus = numeroTrofeus;
    }

    public Entrenador(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, double souBase, int anysExp, int numTrofeus) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase, anysExp);
        this.numeroTrofeus = numTrofeus;
        calcularSouIncentivat();

    }

    public Entrenador() {

    }

    @Override
    public String toString() {
        return super.toString() + "\nNum. Trofeus: " + numeroTrofeus;
    }

    public Entrenador altaEntrenador() {
        altaTecnic();
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu el número de trofeus: ");
        setNumeroTrofeus(sc.nextInt());
        calcularSouIncentivat();
        return this;
    }

    public void modificar() {
        super.modificar();
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu el número de trofeus: ");
        int numTrofeus = sc.nextInt();
        setNumeroTrofeus(numTrofeus);
        calcularSouIncentivat();
    }

    
}
