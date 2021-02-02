package edu.eci.arsw.primefinder;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

        boolean confirmar = true;
        long timeStart = System.currentTimeMillis();
        PrimeFinderThread pft = new PrimeFinderThread(0, 10000000);
        PrimeFinderThread pft_2 = new PrimeFinderThread(10000001, 20000000);
        PrimeFinderThread pft_3 = new PrimeFinderThread(20000001, 30000000);
        pft.start();
        pft_2.start();
        pft_3.start();
        while (confirmar) {
            if (System.currentTimeMillis()-timeStart > 5000) {
                pft.suspend();
                pft_2.suspend();
                pft_3.suspend();
                System.out.println("el numero de primos encontrados es: " + (pft.getPrimes().size()+pft_2.getPrimes().size()+pft_3.getPrimes().size()));
                System.in.read();
                pft.resume();
                pft_2.resume();
                pft_3.resume();
                confirmar=false;

            }
        }


		
	}
	
}
