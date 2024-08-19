package tw.brad.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable {
	private GiftDB db;
	
	public GiftTable() {
		
		try {
			db = new GiftDB();
			db.query();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		GiftModel model = new GiftModel();
		model.setColumnIdentifiers(db.getFieldNames());
		setModel(model);
		
	}

	private class GiftModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}
		
		
		
		
	}

}
