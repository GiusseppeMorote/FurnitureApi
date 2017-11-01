package edu.cibertec.start;

import org.glassfish.jersey.server.ResourceConfig;
//rest con jersy
public class Arrancador extends ResourceConfig {
	//genero un constructor del arrancador
	public Arrancador() {
		// indico donde estan las clases
		packages("edu.cibertec");//este en globa los paquetes
	}

}
