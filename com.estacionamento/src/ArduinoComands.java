

import java.util.Scanner;

import arduino.*;

public class ArduinoComands {

    static Arduino obj = new Arduino("COM4",115200);

    public static void abrirArduino() throws InterruptedException {
        obj.openConnection();
        Thread.sleep(1100);
    }

    public static void fecharArduino(){
        obj.closeConnection();
    }
    

    Scanner sc = new Scanner(System.in);
    public static String getRFIDreading(){

        String aux = "";
        long start = System.currentTimeMillis();
        long end = start + 5 * 1000;
        while ((aux.length() < 2) && System.currentTimeMillis() < end) {
            aux = obj.serialRead();
        }
        return(aux);

    }

    public static void openGate1() throws InterruptedException{
        Thread.sleep(1100);
       obj.serialWrite('a');

    }

    public static void openGate2() throws InterruptedException{
        Thread.sleep(1100);
        obj.serialWrite('b');

    }

    public static void setPrice(String price){
        obj.serialWrite("p" + price);
    }
}
