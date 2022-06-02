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

public class PreparadorFisic extends Tecnic implements Serializable{
    private static int incentiuAnys = 200;
    @Override
    public void calcularSouIncentivat() {
        setSouIncentivat(getSouBase() + (getAnysExp() * incentiuAnys));

    }

    public PreparadorFisic(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, double souBase, int anysExp) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, nss, souBase, anysExp);
        calcularSouIncentivat();
    }

    public PreparadorFisic() {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public PreparadorFisic altaPreparadorFisic() {
        altaTecnic();
        calcularSouIncentivat();
        return this;
    }

    public void modificar() {
        super.modificar();
        calcularSouIncentivat();
    }

    
}
