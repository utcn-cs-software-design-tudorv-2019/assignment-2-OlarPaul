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

import assigment2.mvc.model.TeacherModel;

	public class TeacherRegistration extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private TeacherModel teacherModel;

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_2;
		private JPasswordField textField_3;

		private JButton btnRegister = new JButton("Register");
		private JButton btnBack = new JButton("BACK");

		public TeacherModel getTeacherModel() {
			return teacherModel;
		}

		public void setTeacherModel(TeacherModel teacherModel) {
			this.teacherModel = teacherModel;
		}

		public TeacherRegistration() {

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setTitle("Teacher Registration");
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblIntroduceTheRequired = new JLabel("Introduce the required data:");
			lblIntroduceTheRequired.setBounds(25, 23, 175, 16);
			contentPane.add(lblIntroduceTheRequired);

			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(35, 52, 67, 16);
			contentPane.add(lblName);

			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setBounds(35, 84, 67, 16);
			contentPane.add(lblUsername);

			JLabel lblPassword = new JLabel("Password: ");
			lblPassword.setBounds(35, 113, 67, 16);
			contentPane.add(lblPassword);

			textField = new JTextField();
			textField.setBounds(114, 52, 116, 22);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(114, 81, 116, 22);
			contentPane.add(textField_2);
			textField_2.setColumns(10);

			textField_3 = new JPasswordField();
			textField_3.setBounds(114, 110, 116, 22);
			contentPane.add(textField_3);
			textField_3.setColumns(10);

			btnRegister.setBounds(70, 189, 97, 25);
			contentPane.add(btnRegister);

			btnBack.setBounds(298, 215, 97, 25);
			contentPane.add(btnBack);
		}

		public List<String> getTeacherRegInfo() {
			List<String> userInput = new ArrayList<>();
			String name = textField.getText();
			String username = textField_2.getText();
			char[] pass = textField_3.getPassword();
			String password = String.valueOf(pass);

			userInput.add(name);
			userInput.add(username);
			userInput.add(password);

			return userInput;
		}

		public void addTeacherRegisterListener(ActionListener al) {
			btnRegister.addActionListener(al);
		}

		public void addBackFromTeacherRegListener(ActionListener al) {
			btnBack.addActionListener(al);
		}

	}
