

import java.io.Serializable;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ficherroooor {
	
	public static void main(String[] args) {
		final File f = new File(System.getProperty("user.dir").concat("\\PRUEBA_FICHERO"));
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(f,"fiche.fc")))){
			out.writeObject(new PR("PROBANDO)"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(f, "fiche.fc")))){
			var p = (PR)in.readObject();
			System.out.println(p.s);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

}

class PR implements Serializable {
	transient final String s;
	public PR(String s) {
		this.s = s;
	}
}
