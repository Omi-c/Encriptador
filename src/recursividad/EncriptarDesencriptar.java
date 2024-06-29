package recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class EncriptarDesencriptar {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String texto, textocifrado, clave;
        texto = JOptionPane.showInputDialog("Digite el texto.");
        texto=texto.replaceAll(" ", "");
        clave = JOptionPane.showInputDialog("Digite la clave.");
        clave=clave.replaceAll(" ","");
        textocifrado = encriptar(texto, clave);
        System.out.println("El valor encriptado es: "+textocifrado);
        String textoDesencriptado = desencriptar(textocifrado, clave);
    }

    public static String desencriptar(String bin, String c) {
        try {
            System.out.println(bin);
            bin = invertir(bin, c.length());
            System.out.println(bin);
            //bin = bin.replaceAll(c, "");
            String dec = "";
            String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
            String temporal = "";
            for (int i = 0; i < bin.length() - 4; i = i + 5) {
                temporal = convertirDec(bin.substring(i, i + 5));
                int val = Integer.parseInt(temporal);
                dec = dec + abc.substring(val - 1, val);
            }
            System.out.println("El valor desencriptado es: " + dec);
        } catch (Exception e) {
            System.out.println("Error encriptar en desenceiptar" + e.toString());
        }
        return bin;
    }

    public static String encriptar(String s, String c) {
        try {
            s = c + s + c;
            s = s.toUpperCase();
            String x = "";
            for (int i = 0; i < s.length(); i++) {
                x = x + convertirBin(s.substring(i, i + 1));
            }
            s = invertir(x, c.length());
        } catch (Exception e) {
            System.out.println("Error encriptar " + e.toString());
        }
        return s;
    }

    public static String convertirBin(String l) {
        try {
            l = valor(l);
            l = String.valueOf(Integer.toBinaryString(Integer.parseInt(l)));
            if (l.length() < 5) {
                int dif = 5 - l.length();
                switch (dif) {
                    case 1:
                        l = "0" + l;
                        break;
                    case 2:
                        l = "00" + l;
                        break;
                    case 3:
                        l = "000" + l;
                        break;
                    case 4:
                        l = "0000" + l;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error convertir " + e.toString());
        }
        return l;
    }

    public static String convertirDec(String l) {
        try {
            l = Integer.toString(Integer.parseInt(l, 2));
            if (l.length() == 1) {
                l = "0" + l;
            }
        } catch (Exception e) {
            System.out.println("Error convertir " + e.toString());
        }
        return l;
    }

    public static String valor(String l) {
        String salida = "";
        try {
            String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
            for (int i = 0; i < abc.length(); i++) {
                if (abc.substring(i, i + 1).equals(l)) {
                    salida = Integer.toString(i + 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error valor " + e.toString());
        }
        return salida;
    }

    public static String invertir(String s, int t) {
        System.out.println(s);
        String aux = "";
        try {
            if (t % 2 == 0) {
                aux = s;
            } else {
                for (int x = s.length() - 1; x >= 0; x--) {
                    aux = aux + s.charAt(x);
                }
            }
        } catch (Exception e) {
            System.out.println("Error invertir " + e.toString());
        }
        return aux;
    }
}
