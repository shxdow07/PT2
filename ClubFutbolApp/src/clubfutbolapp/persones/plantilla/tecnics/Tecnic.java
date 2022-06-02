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
import clubfutbolapp.persones.plantilla.Plantilla;
import clubfutbolapp.validacions.Correu;
import clubfutbolapp.validacions.Dni;
import clubfutbolapp.validacions.Telefon;

public abstract class Tecnic extends Plantilla implements Serializable{
    private int anysExp;
    public int getAnysExp() {
        return anysExp;
    }

    public void setAnysExp(int anysExp) {
        this.anysExp = anysExp;
    }

    public Tecnic(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, double souBase, int anysExp) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase);
        this.anysExp = anysExp;
    }
    
    public Tecnic() {

    }

    @Override
    public String toString() {
        return super.toString() + "\nAnys Exp: " + anysExp;
    }

    public void altaTecnic() {
        altaTreballador();
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu els anys d'experiència: ");
        setAnysExp(sc.nextInt());
    }
    
    @Override
    public void modificar() {
        super.modificar();
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu els any d'experiència: ");

        int anysExp = sc.nextInt();
        setAnysExp(anysExp);
    }

    

    
}
