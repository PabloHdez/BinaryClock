package reloj;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Reloj{
    private int horas;
    private int minutos;
    private int segundos;
    private LocalDateTime localTime;
    private char[][] reloj_binario = new char[4][6];

    GraphicsDemo appwin;

    //Constructor
    public Reloj() {
        Color fondo = new Color(48,52,66);
        localTime = LocalDateTime.now();
        horas = localTime.getHour();
        minutos = localTime.getMinute();
        segundos = localTime.getSecond();

        appwin = new GraphicsDemo(reloj_binario);
        appwin.setSize(new Dimension(320, 220));
        appwin.setTitle("Reloj Binario");
        appwin.setVisible(true);
        appwin.setBackground(fondo);

        for (int i = 0; i < reloj_binario.length; i++) {
            for (int j = 0; j < reloj_binario[i].length; j++) {
                reloj_binario[i][j] = '0';
            }
        }
    }
    //Muestra la hora actual en la tabla binaria
    private void horaActualTabla() throws InterruptedException {
        /*
        for (int i = 0; i < reloj_binario.length; i++) {
            System.out.println(Arrays.toString(reloj_binario[i]));
        }

         */
        this.actualizarTabla();
        appwin.repaint();
        TimeUnit.SECONDS.sleep(1);
    }
    //Actualizar valores de la tabla
    private void actualizarTabla() throws InterruptedException {
        this.localTime = LocalDateTime.now();

        this.horas = localTime.getHour();
        this.minutos = localTime.getMinute();
        this.segundos = localTime.getSecond();

        String binary_segundos = toBinary(segundos);
        int valor_s = 0;
        for (int j = 4; j <= 5; j++) {
            for (int i = 0; i <=3; i++) {
                reloj_binario[i][j] = binary_segundos.charAt(valor_s);
                valor_s++;
            }
        }
        String binary_minutos = toBinary(minutos);
        int valor_m = 0;
        for (int j = 2; j <= 3; j++) {
            for (int i = 0; i <=3; i++) {
                reloj_binario[i][j] = binary_minutos.charAt(valor_m);
                valor_m++;
            }
        }
        String binary_horas = toBinary(horas);
        int valor_h = 0;
        for (int j = 0; j <= 1; j++) {
            for (int i = 0; i <=3; i++) {
                reloj_binario[i][j] = binary_horas.charAt(valor_h);
                valor_h++;
            }
        }
    }
    //Convertir numeros a binarios de longitud 8
    private String toBinary(int n) {
        String n_bin = (String) Integer.toBinaryString(n);
        while (n_bin.length() < 8) {
            n_bin = "0" + n_bin;
        }
        return n_bin;
    }
    //enciende el reloj
    public void activar() throws InterruptedException {
        while(true){
            this.horaActualTabla();
            /*
            for (int i = 0; i < 5; i++){
                System.out.println(" ");
            }
             */
        }
    }
}
