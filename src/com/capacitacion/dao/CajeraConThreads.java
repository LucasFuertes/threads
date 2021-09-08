package com.capacitacion.dao;

public class CajeraConThreads implements Runnable{

	private String nombre;
	private Cliente cliente;
	private long initialTime;

	public CajeraConThreads(String nombre, Cliente cliente, long initialTime) {
		super();
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		System.out.println("La cajera: " + this.nombre + " Comienza a procesar la compra del cliente "
				+ cliente.getNombre() + " en el tiempo " + (System.currentTimeMillis() - initialTime) / 1000 + "seg");

		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesado el producto " + (i + 1) + " ->Tiempo: "
					+ (System.currentTimeMillis() - initialTime) / 1000 + "seg");

		}

		System.out.println("La cajera: " + this.nombre + " ha terminado de procesar " + cliente.getNombre()
				+ " en el tiempo " + (System.currentTimeMillis() - initialTime) / 1000 + "seg");

	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
