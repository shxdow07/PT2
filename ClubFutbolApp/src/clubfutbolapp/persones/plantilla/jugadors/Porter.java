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

public class Porter extends Jugador implements Serializable{
    private int golsAturats;
    private int golsRebuts;
    private static int incentiuGolsAturats = 150;

    public int getGolsAturats() {
        return golsAturats;
    }

    public void setGolsAturats(int golsAturats) {
        this.golsAturats = golsAturats;
    }

    public int getGolsRebuts() {
        return golsRebuts;
    }

    public void setGolsRebuts(int golsRebuts) {
        this.golsRebuts = golsRebuts;
    }

    public static int getIncentiuGolsAturats() {
        return incentiuGolsAturats;
    }

    public static void setIncentiuGolsAturats(int incentiuGolsAturats) {
        Porter.incentiuGolsAturats = incentiuGolsAturats;
    }

    @Override
    public void calcularSouIncentivat() {
        setSouIncentivat(getSouBase() + (getGolsAturats() * incentiuGolsAturats));;
    }

    public Porter(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, int souBase, boolean esTitular, int golsAturats,
            int golsRebuts) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase, esTitular);
        this.golsAturats = golsAturats;
        this.golsRebuts = golsRebuts;
        calcularSouIncentivat();
    }

    @Override
    public String toString() {
        return super.toString() + "\nGols Aturats: " + golsAturats + "\nGols Rebuts: " + golsRebuts;
    }

    public Porter() {
        
    }

    public Porter altaPorter() {
        altaJugador();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.print("Escriu els gols aturats: ");
        setGolsAturats(sc.nextInt());
        System.out.print("Escriu els gols rebuts: ");
        setGolsRebuts(sc.nextInt());
        return this;
    }

    @Override
    public void modificar() {
        super.modificar();
        Scanner sc = new Scanner(System.in);
        System.out.print("Gols aturats: ");
        int ga = sc.nextInt();
        setGolsAturats(ga);

        System.out.print("Gols rebuts: ");
        int gr = sc.nextInt();
        setGolsRebuts(gr);
        
        calcularSouIncentivat();
    }
}