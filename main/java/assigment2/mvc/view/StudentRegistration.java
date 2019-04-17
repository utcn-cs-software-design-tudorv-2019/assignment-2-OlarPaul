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

import assigment2.mvc.model.StudentModel;

public class StudentRegistration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentModel studentModel;

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_6;
	private JPasswordField textField_7;
	private JTextField textField_8;

	private JButton btnRegister = new JButton("Register");
	private JButton btnBack = new JButton("BACK");

	public StudentModel getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}

	public StudentRegistration() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 565, 455);
		setTitle("Student Registration");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIntroduceTheRequired = new JLabel("Introduce the required data:");
		lblIntroduceTheRequired.setBounds(23, 26, 171, 16);
		contentPane.add(lblIntroduceTheRequired);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(23, 84, 65, 16);
		contentPane.add(lblName);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(23, 114, 65, 16);
		contentPane.add(lblEmail);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 148, 65, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 177, 65, 16);
		contentPane.add(lblPassword);

		textField_8 = new JTextField();
		textField_8.setBounds(104, 110, 116, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(104, 81, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(104, 145, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JPasswordField();
		textField_7.setBounds(104, 174, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		btnRegister.setBounds(80, 307, 97, 25);
		contentPane.add(btnRegister);

		btnBack.setBounds(408, 353, 97, 25);
		contentPane.add(btnBack);
	}

	public List<String> getStudentRegInfo() {
		List<String> userInput = new ArrayList<>();

		String name = textField_1.getText();
		String username = textField_6.getText();
		String email = textField_8.getText();
		char[] pass = textField_7.getPassword();
		String password = String.valueOf(pass);

		userInput.add(name);
		userInput.add(email);
		userInput.add(username);
		userInput.add(password);

		return userInput;
	}

	public void addStudentRegisterListener(ActionListener al) {
		btnRegister.addActionListener(al);
	}

	public void addBackFromStudentRegListener(ActionListener al) {
		btnBack.addActionListener(al);
	}

}
