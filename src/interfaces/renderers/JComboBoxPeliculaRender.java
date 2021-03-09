package interfaces.renderers;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import cine.pelicula.Pelicula;

public class JComboBoxPeliculaRender extends JLabel implements ListCellRenderer<Pelicula>{
	
	public JComboBoxPeliculaRender() {
		setOpaque(true);
		setHorizontalAlignment(LEFT);
		setVerticalAlignment(CENTER);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Pelicula> list, Pelicula value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

		setText(String.valueOf(value.getId()));
		return this;
	}
}
