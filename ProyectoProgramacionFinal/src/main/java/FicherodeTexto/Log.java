package FicherodeTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
	private String txt;
	
	
	
	
	
	
	
public static void log(String msg) {
	DateTimeFormatter formatoFechaHora=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime fechaHora=LocalDateTime.now();
	try {
		FileWriter txt = new FileWriter("./logUsuarios.txt",true);
		txt.write(msg+"el dia:"+fechaHora.format(formatoFechaHora)+"\n");
		txt.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
}

}
