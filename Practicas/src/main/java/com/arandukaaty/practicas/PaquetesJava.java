package com.arandukaaty.practicas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PaquetesJava {

    public static void paquetesJavaSystem() {
        // System
        System.out.println("Edad: ");
        Scanner scanner = new Scanner(System.in);
        int edad = scanner.nextInt();
        System.out.println("Tienes " + edad + " años.");

        // Date
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(gc.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Hoy es :" + sdf.format(gc.getTime()));

        // Ramdon
        Random random = new Random();
        System.out.println(random.nextInt(10));

        // StringTokenizer
        String datos = "1,Juan Perez, 35";
        StringTokenizer st = new StringTokenizer(datos, ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        // File
        File file = new File("./hola.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Hola Mundo desde Java\n");
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
