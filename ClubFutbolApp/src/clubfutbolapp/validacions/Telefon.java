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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefon implements Serializable{
    private String telf;
    
     public boolean validarTel(String Telefon) {
    Pattern p = Pattern.compile("^\\d{9}$");
    Matcher m = p.matcher(Telefon);
    return (m.matches());
    }

    public Telefon(String telf) {
        this.telf = telf;
    }

    public Telefon() {
        this.telf = telf;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    @Override
    public String toString() {
        return telf;
    }
}