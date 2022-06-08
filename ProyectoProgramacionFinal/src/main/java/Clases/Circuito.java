package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.CurvaInvalida;
import Excepciones.LugarInvalido;
import Excepciones.UsuarioNoExisteException;
import Utils.ConexionBD;

public class Circuito extends ElementoConNombre{
	private  byte numeroCircuito;
	private String lugar;
	private byte rectas;
	private byte curvas;
	private String dificultad;
	private float longitud;
	
	
	
public Circuito() {
	
}


	public Circuito(String nombre,byte numeroCircuito, String lugar, byte rectas, byte curvas, String dificultad, float longitud) throws SQLException, LugarInvalido, CurvaInvalida {
		super(nombre);
		if(!lugarValido(lugar)) {
			throw new LugarInvalido (" El lugar no puede estar vacio porfavor ");
		}
		if(curvaValida(curvas)) {
			throw new CurvaInvalida (" Las curvas no pueden ser menor a el numero indicado");
		}
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("insert into circuito (nombre,numeroCircuito,lugar,rectas,curvas,dificultad,longitud) values  ('"
				+nombre+"','"+numeroCircuito+"''"+lugar+"','"+rectas+"','"+curvas+"','"+dificultad+"','"+longitud+"')")>0) {
			this.numeroCircuito=numeroCircuito;
			this.lugar = lugar;
			this.rectas = rectas;
			this.curvas = curvas;
			this.dificultad = dificultad;
			this.longitud = longitud;
		
		
		}else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar un circuito correctamente");
			
		}
		
	}
	
public Circuito(int numeroCircuito) throws SQLException {
		
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM circuito WHERE numeroCircuito =" + numeroCircuito +";");
			
			if (cursor.next() ) {
				this.nombre=cursor.getString("nombre");
				this.lugar = cursor.getString("lugar");
				this.rectas = cursor.getByte("rectas");
				this.curvas = cursor.getByte("curvas");
				this.dificultad=cursor.getString("dificultad");
				this.longitud=cursor.getFloat("longitud");
			
			}	
		} finally {
			ConexionBD.desconectar();
		}
	}
	

	

	
	
	
	public byte getnumeroCircuito() {
		return numeroCircuito;
		
	}
	
	public void setnumeroCircuito(byte numeroCircuito) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update circuito set numeroCircuito="+numeroCircuito+" where  numeroCircuito="+this.numeroCircuito+"")>0) {
			this.numeroCircuito=numeroCircuito;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se puedo el lugar del circuito ");
		}
}	
		

	
	
	public static boolean lugarValido (String lugar) {
		return !lugar.isBlank();
	}


	public String getLugar() {
		return lugar;
	}
	
	
	public void setLugar(String lugar) throws SQLException, LugarInvalido {
		
		if(!lugarValido(lugar)) {
			throw new LugarInvalido (" El lugar no puede estar vacio porfavor ");
		}
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update circuito set lugar ="+lugar+" where numeroCircuito="+this.numeroCircuito+"")>0) {
			this.lugar=lugar;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar  el lugar del circuito ");
		}
}	
		
	
	
	public byte getRectas() {
		return rectas;
	}
	
	
	public void setRectas(byte rectas) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update  circuito set rectas="+rectas+" where numeroCircuito="+this.numeroCircuito+"")>0) {
			this.rectas=rectas;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el numero de rectas ");
		}
}	
		
	
	
	public static boolean curvaValida (byte curvas) {
		return !(curvas<16);
	}
	
	public byte getCurvas() {
		return curvas;
	}
	
	
	
	public void setCurvas(byte curvas) throws SQLException, CurvaInvalida {
		
		if(curvaValida(curvas)) {
			throw new CurvaInvalida (" Las curvas no pueden ser menor a el numero indicado");
		}
		
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update cirucito set curvas ="+curvas+" where numeroCircuito="+this.numeroCircuito+"")>0) {
			this.curvas=curvas;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el numero de curvas ");
		}
}	
		
	
	
	
	public String getDificultad() {
		return dificultad;
	}
	
	
	public void setDificultad(String dificultad) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update circuito set dificuitad ="+dificultad+" where numeroCircuito="+this.numeroCircuito+"")>0) {
			this.dificultad=dificultad;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar la dificultad del circuito  ");
		}
}	
	
	
	public float getLongitud() {
		return longitud;
	}
	
	
	public void setLongitud(float longitud) throws SQLException {
		
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update circuito set longitud="+longitud+" where numeroCircuito="+this.numeroCircuito+"")>0) {
			this.longitud=longitud;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar la longitud del circuito  ");
		}
}	
		
	
	
	
	public void eliminar() {
		Statement smt = ConexionBD.conectar();
		
		try {
			if (smt.executeUpdate("DELETE FROM circuito WHERE numeroCircuito =" +numeroCircuito ) > 0) {
				this.numeroCircuito = 0;
				this.nombre = null;
				this.lugar = null;
				this.rectas = 0;
				this.curvas=0;
				this.dificultad=null;
				this.longitud=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionBD.desconectar();
		}
}

	
	
	
	@Override
	public String toString() {
		return "Circuito [lugar=" + lugar + ", rectas=" + rectas + ", curvas=" + curvas + ", dificultad=" + dificultad
				+ ", longitud=" + longitud + "]";
	}

	
}
