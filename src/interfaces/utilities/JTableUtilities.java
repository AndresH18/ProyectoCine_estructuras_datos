package interfaces.utilities;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class JTableUtilities {

	public static void setCellsAlignment(JTable table, int alignment) {
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(alignment);

		TableModel tableModel = table.getModel();

		for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
			table.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);
		}

	}
}

class TableAsientoRenderer extends DefaultTableCellRenderer{
	
	public TableAsientoRenderer() {
		super();
		setHorizontalAlignment(JLabel.CENTER);
	}

}