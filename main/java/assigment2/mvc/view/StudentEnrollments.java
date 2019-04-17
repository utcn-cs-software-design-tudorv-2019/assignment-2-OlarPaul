package assigment2.mvc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class StudentEnrollments extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	private DefaultListModel<String> listModel = new DefaultListModel<>();

	private JButton btnRemoveEnrollment = new JButton("Remove Enrollment");
	private JButton btnNewEnrollment = new JButton("New Enrollment");
	private JButton btnBack = new JButton("BACK");

	public StudentEnrollments() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 450, 500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCourseEnrollments = new JLabel("Course enrollments:");
		lblCourseEnrollments.setBounds(36, 26, 133, 28);
		contentPane.add(lblCourseEnrollments);

		list = new JList();

		btnRemoveEnrollment.setBounds(36, 292, 170, 36);
		contentPane.add(btnRemoveEnrollment);

		btnNewEnrollment.setBounds(36, 361, 170, 36);
		contentPane.add(btnNewEnrollment);

		btnBack.setBounds(289, 404, 97, 25);
		contentPane.add(btnBack);
	}

	public void addListListener(MouseListener al) {
		list.addMouseListener(al);
	}

	public void addRemoveEnListener(ActionListener al) {
		btnRemoveEnrollment.addActionListener(al);
	}

	public void addEnListener(ActionListener al) {
		btnNewEnrollment.addActionListener(al);
	}

	public void addBackListener(ActionListener al) {
		btnBack.addActionListener(al);
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

	public JList getList() {
		return list;
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}
}