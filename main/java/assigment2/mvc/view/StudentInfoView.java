package assigment2.mvc.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import assigment2.entities.Student;

public class StudentInfoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JPasswordField textField_7;

	private JButton btnUpdate = new JButton("Update");
	private JButton btnBack = new JButton("BACK");

	public StudentInfoView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);
		setTitle("Student Profile Information");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStudentid = new JLabel("StudentID:");
		lblStudentid.setBounds(30, 29, 70, 21);
		contentPane.add(lblStudentid);

		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(30, 63, 70, 16);
		contentPane.add(lblFullName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(30, 94, 70, 16);
		contentPane.add(lblEmail);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(30, 124, 70, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 153, 70, 16);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(110, 28, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		textField_1 = new JTextField();
		textField_1.setBounds(110, 60, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 90, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(110, 120, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JPasswordField();
		textField_7.setBounds(110, 150, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		btnUpdate.setBounds(62, 190, 97, 25);
		contentPane.add(btnUpdate);

		btnBack.setBounds(469, 394, 97, 25);
		contentPane.add(btnBack);
	}

	public void initView(Student student) {
		textField.setText(String.valueOf(student.getStudentById()));
		textField_1.setText(student.getName());
		textField_2.setText(student.getEmail());
		textField_6.setText(student.getUsername());
		textField_7.setText(student.getPassword());
	}

	public void addUpdateListener(ActionListener al) {
		btnUpdate.addActionListener(al);
	}

	public void addBackListener(ActionListener al) {
		btnBack.addActionListener(al);
	}

	public List<String> getInput() {
		List<String> input = new ArrayList<String>();
		input.add(textField_1.getText());
		input.add(textField_6.getText());
		char[] pass = textField_7.getPassword();
		String password = String.valueOf(pass);
		input.add(password);

		return input;
	}

}
