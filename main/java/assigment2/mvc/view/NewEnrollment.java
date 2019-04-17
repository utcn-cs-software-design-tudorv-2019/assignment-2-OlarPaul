package assigment2.mvc.view;

	import java.awt.event.ActionListener;
	import java.util.List;

	import javax.swing.DefaultListModel;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JList;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;

	public class NewEnrollment extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JList list;
		private JButton btnBack = new JButton("BACK");
		private JButton btnMakeEnrollment = new JButton("Make enrollment");
		private DefaultListModel<String> listModel = new DefaultListModel<>();

		public NewEnrollment() {

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(400, 400, 550, 500);

			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			list = new JList();
			
			JLabel lblChooseFromThe = new JLabel("Choose a course:");
			lblChooseFromThe.setBounds(35, 18, 205, 25);
			contentPane.add(lblChooseFromThe);

			btnMakeEnrollment.setBounds(39, 289, 147, 51);
			contentPane.add(btnMakeEnrollment);

			btnBack.setBounds(270, 394, 97, 25);
			contentPane.add(btnBack);

		}

		public void addBackListner(ActionListener al) {
			btnBack.addActionListener(al);
		}

		public void addNewEnListener(ActionListener al) {
			btnMakeEnrollment.addActionListener(al);
		}

		public void initializeList(List<String> courseNames) {
			for (String st : courseNames) {
				listModel.addElement(st);
			}
			list = new JList<>(listModel);

			list.setBounds(36, 67, 200, 190);
			list.setVisible(true);

		}

		public void addTheList() {
			contentPane.add(list);
		}

		public DefaultListModel<String> getListModel() {
			return listModel;
		}

		public JList getList() {
			return list;
		}
		
	}

