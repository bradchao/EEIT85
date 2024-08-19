package tw.brad.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable {
	public GiftTable() {
		
		GiftModel model = new GiftModel();
		setModel(model);
		
	}

	private class GiftModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return 10;
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return String.format("%s %dx%d", "Brad", row, column);
		}
		
		
		
		
	}

}
