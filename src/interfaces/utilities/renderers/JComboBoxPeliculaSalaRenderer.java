package interfaces.utilities.renderers;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import cine.sala.Sala;

public class JComboBoxPeliculaSalaRenderer extends JLabel implements ListCellRenderer<Sala> {

	public JComboBoxPeliculaSalaRenderer() {
		setOpaque(true);
		setHorizontalAlignment(LEFT);
		setVerticalAlignment(CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Sala> list, Sala value, int index, boolean isSelected,
			boolean cellHasFocus) {

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		StringBuilder sb = new StringBuilder();
		sb.append(value.getPelicula().getNombre()).append(", ").append(value.getId());
		setText(sb.toString());

		return this;
	}

}
