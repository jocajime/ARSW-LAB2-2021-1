package edu.eci.arsw.primefinder;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		boolean confirmar = true;
		
		PrimeFinderThread pft=new PrimeFinderThread(0, 10000000);
		PrimeFinderThread pft_2=new PrimeFinderThread(10000001, 20000000);
		PrimeFinderThread pft_3=new PrimeFinderThread(20000001, 30000000);
		pft.start();
		pft_2.start();
		pft_3.start();
		while(confirmar){
			System.out.println(System.currentTimeMillis()+"--------------------------------------");
			if(System.currentTimeMillis()>5000){
				System.out.println(System.currentTimeMillis()+"--------------------------------------");
				pft.setActivo(false);
				pft_2.setActivo(false);
				pft_3.setActivo(false);
				System.in.read();
				confirmar = false;
				pft.setActivo(true);
				pft_2.setActivo(true);
				pft_3.setActivo(true);
			}

		}

		
	}
	
}
