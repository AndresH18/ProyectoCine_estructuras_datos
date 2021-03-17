package interfaces.models;

import javax.swing.table.AbstractTableModel;

import cine.sala.asiento.Asiento;

public class AsientoTableModel extends AbstractTableModel {

	private Asiento[][] asientos;

//	public AsientoTableModel() {
//		
//	}

	public AsientoTableModel(Asiento[][] asientos) {
		this.asientos = asientos;
	}

	public void setAsientos(Asiento[][] asientos) {
		this.asientos = asientos;
	}

	@Override
	public int getRowCount() {
		return asientos.length;
	}

	@Override
	public int getColumnCount() {
		return asientos[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return asientos != null ? asientos[rowIndex][columnIndex] : null;
	}

}
