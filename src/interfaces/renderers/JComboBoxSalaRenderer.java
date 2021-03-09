package interfaces.renderers;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import cine.sala.Sala;

public class JComboBoxSalaRenderer extends JLabel implements ListCellRenderer<Sala> {

	public JComboBoxSalaRenderer() {
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

		setText(String.valueOf(value.getId()));
		return this;
	}

}
