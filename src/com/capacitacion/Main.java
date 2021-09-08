package com.capacitacion;

//import com.capacitacion.dao.Cajera;
import com.capacitacion.dao.CajeraConThreads;
import com.capacitacion.dao.Cliente;

/*
 * Todo lo comentado hace referencia a como funcionaria el programa 
 * Threads
 * */


public class Main {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

//		Cajera cajera1 = new Cajera("Cajera 1");
//		Cajera cajera2 = new Cajera("Cajera 2");
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		CajeraConThreads cajeraConThread1 = new CajeraConThreads("Cajera 1", cliente1, initialTime);
		CajeraConThreads cajeraConThread2 = new CajeraConThreads("Cajera 2", cliente2, initialTime);
		
		Thread thread1 = new Thread(cajeraConThread1);
		Thread thread2 = new Thread(cajeraConThread2);
		
		thread1.start();
		thread2.start();


//		cajera1.procesarCompra(cliente1, initialTime);
//		cajera2.procesarCompra(cliente2, initialTime);

	}

}
