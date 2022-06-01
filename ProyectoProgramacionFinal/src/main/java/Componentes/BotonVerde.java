package Componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonVerde extends BotonRojo{
	public BotonVerde(String s) {
		super(s);
		estilosDefault();
this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(0, 0, 0));
				setBackground(new Color(255, 255, 255));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estilosDefault();
			}
		});
	}
	private void estilosDefault() {
		this.setForeground(new Color(255, 0, 0));
		this.setBackground(new Color(0, 0, 0));
	}

}
	

