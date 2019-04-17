package assigment2.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JList;
import javax.swing.JOptionPane;

import assigment2.entities.Course;
import assigment2.entities.Enrollment;
import assigment2.entities.Student;
import assigment2.entities.Teacher;
import assigment2.mvc.model.StudentModel;
import assigment2.mvc.model.TeacherModel;
import assigment2.mvc.view.HomePageView;
import assigment2.mvc.view.NewEnrollment;
import assigment2.mvc.view.StudentAccountView;
import assigment2.mvc.view.StudentEnrollments;
import assigment2.mvc.view.StudentInfoView;
import assigment2.mvc.view.StudentRegistration;
import assigment2.mvc.view.TeacherAccount;
import assigment2.mvc.view.TeacherRegistration;
import assigment2.service.CourseService;
import assigment2.service.EnrollmentService;
import assigment2.service.StudentService;
import assigment2.service.TeacherService;

public class HomePageController {

	@Inject
	StudentService studentService;
	@Inject
	TeacherService teacherService;
	@Inject
	CourseService courseService;
	@Inject
	EnrollmentService enrollmentService;

	private StudentModel studentModel;
	private TeacherModel teacherModel;

	private StudentRegistration studentRegistration;
	private StudentAccountView studentAccountView;
	private StudentInfoView studentInfoView;

	private TeacherRegistration teacherRegistration;
	private TeacherAccount teacherAccount;

	private HomePageView homePageView;

	private NewEnrollment newEnrollment;
	private StudentEnrollments studentEnrollments;

	public void init(StudentModel studentModel, HomePageView homePageView, TeacherModel teacherModel) {
		this.studentModel = studentModel;
		this.homePageView = homePageView;
		this.teacherModel = teacherModel;

		this.homePageView.setVisible(true);

		this.studentRegistration = new StudentRegistration();
		this.studentAccountView = new StudentAccountView();
		this.studentInfoView = new StudentInfoView();

		this.teacherRegistration = new TeacherRegistration();
		this.teacherAccount = new TeacherAccount();

		this.newEnrollment = new NewEnrollment();
		this.studentEnrollments = new StudentEnrollments();

		homePageView.addLoginListener(new LoginListener());
		homePageView.addStudentRegistrationListener(new StudentRegistrationListener());
		homePageView.addTeacherRegistrationListener(new TeacherRegistrationListener());

		studentRegistration.addBackFromStudentRegListener(new StudentRegBackListener());
		studentRegistration.addStudentRegisterListener(new StudentRegListener());

		studentAccountView.addDetailsListeners(new DetailsListeners());
		studentAccountView.addDeleteAccListener(new DelStudAccListener());
		studentAccountView.addEnrollmentsListener(new EnrollmentsLisener());
		studentAccountView.addLogoutListener(new StudLogoutListener());

		studentInfoView.addUpdateListener(new UpdateStudListener());
		studentInfoView.addBackListener(new BackFromDetailsListner());

		teacherRegistration.addBackFromTeacherRegListener(new TeacherRegBackListener());
		teacherRegistration.addTeacherRegisterListener(new TeacherRegListener());

		studentEnrollments.addBackListener(new BackEnrListener());
		studentEnrollments.addRemoveEnListener(new RemoveEnrollmentListener());
		studentEnrollments.addEnListener(new MakeEnrollListener());

		newEnrollment.addBackListner(new BackFromNewListener());
		newEnrollment.addNewEnListener(new NewEnrollListener());
	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = homePageView.getInputUsername();
			String password = homePageView.getInputPassword();

			try {
				Student student = studentService.getStudentByUsername(username);
				if (student.getPassword().equals(password)) {
					studentModel.setStudent(student);
					studentAccountView.setStudentModel(studentModel);
					studentAccountView.setTitle("Student account: " + studentModel.getStudent().getName());
					studentAccountView.setVisible(true);
					homePageView.setVisible(false);
				}
			} catch (Exception e1) {
				try {
					Teacher teacher = teacherService.getTeacherByUsername(username);

					if (teacher.getPassword().equals(password)) {

						teacherModel.setTeacher(teacher);
						teacherAccount.setTeacherModel(teacherModel);
						List<Enrollment> enrollments = enrollmentService
								.getByCourse(teacherModel.getTeacher().getCourses().get(0));
						List<String> studentNames = new ArrayList<String>();
						for (Enrollment en : enrollments) {
							studentNames.add(en.getStudent().getName());
						}
						teacherAccount.clear();
						teacherAccount.initializeList(studentNames);
						teacherAccount.initView(teacherModel.getTeacher());
						teacherAccount.addTheList();
						teacherAccount.setTitle("Teacher account: " + teacherModel.getTeacher().getName());
						teacherAccount.setCourseName(teacherModel.getTeacher().getCourses().get(0).getName());
						teacherAccount.setVisible(true);
						homePageView.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect password for teacher account.", "Log in error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No account exists for provided username.", "Log in error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	class StudentRegistrationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(false);
			studentRegistration.setVisible(true);
		}
	}

	class StudentRegListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> userInput = studentRegistration.getStudentRegInfo();
			Student newStudent = new Student(userInput.get(0), userInput.get(1), userInput.get(2), userInput.get(3));
			studentService.save(newStudent);
			JOptionPane.showMessageDialog(null, "Account created.", "Registration Status",
					JOptionPane.INFORMATION_MESSAGE);
			homePageView.setVisible(true);
			studentRegistration.setVisible(false);
		}
	}

	class StudentRegBackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(true);
			studentRegistration.setVisible(false);
		}
	}

	class DetailsListeners implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studentInfoView.setVisible(true);
			studentInfoView.initView(studentModel.getStudent());
			studentAccountView.setVisible(false);

		}
	}

	class DelStudAccListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studentService.delete(studentModel.getStudent());

			JOptionPane.showMessageDialog(null, "Student account deleted.", "Delete status.",
					JOptionPane.INFORMATION_MESSAGE);

			studentAccountView.setVisible(false);
			homePageView.setVisible(true);
			homePageView.clear();
		}
	}

	class StudLogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studentAccountView.setVisible(false);
			homePageView.setVisible(true);
			homePageView.clear();
		}
	}

	class UpdateStudListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> input = studentInfoView.getInput();

			Student updatedStudent = new Student(input.get(0), input.get(1), input.get(2), input.get(3));
			updatedStudent.setStudentById(studentModel.getStudent().getStudentById());
			studentService.update(updatedStudent);

			JOptionPane.showMessageDialog(null, "Student account information updated.", "Update status.",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	class BackFromDetailsListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studentInfoView.setVisible(false);
			homePageView.setVisible(true);
			homePageView.clear();
		}
	}

	class TeacherRegistrationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(false);
			teacherRegistration.setVisible(true);
		}
	}

	class TeacherRegBackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(true);
			teacherRegistration.setVisible(false);
		}
	}

	class TeacherRegListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> userInput = teacherRegistration.getTeacherRegInfo();
			Teacher newTeacher = new Teacher(userInput.get(0), userInput.get(1), userInput.get(2));
			teacherService.insert(newTeacher);
			homePageView.setVisible(true);
			teacherRegistration.setVisible(false);
			JOptionPane.showMessageDialog(null, "Account created.", "Registration Status",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	class EnrollmentsLisener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> courseNames = new ArrayList<String>();
			List<Course> allCourses = studentService.findStudentCourses(studentModel.getStudent().getStudentById());
			allCourses.stream().forEach(a -> courseNames.add(a.getName()));
			studentEnrollments.getListModel().removeAllElements();
			studentEnrollments.initializeList(courseNames);
			studentEnrollments.setTitle("Student Account: " + studentModel.getStudent().getName() + " COURSES");
			studentEnrollments.addTheList();
			studentEnrollments.setVisible(true);
			studentAccountView.setVisible(false);
		}
	}

	
	class MakeEnrollListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<Course> allCourses = courseService.getAllCourses();
			List<Course> allCoursesOfStud = studentService
					.findStudentCourses(studentModel.getStudent().getStudentById());
			List<Course> remainingCourses = new ArrayList<Course>();
			for (Course allC : allCourses) {
				int ok = 1;
				for (Course studC : allCoursesOfStud) {
					if (allC.getCourseid() == studC.getCourseid()) {
						ok = 0;
					}
				}
				if (ok == 1) {
					remainingCourses.add(allC);
				}
			}
			List<String> courseNames = new ArrayList<String>();
			for (Course c : remainingCourses) {
				courseNames.add(c.getName());
			}
			newEnrollment.getListModel().removeAllElements();
			newEnrollment.initializeList(courseNames);
			newEnrollment.setTitle("Student: " + studentModel.getStudent().getName() + "  New Enrollment.");
			newEnrollment.addTheList();
			newEnrollment.setVisible(true);
			studentEnrollments.setVisible(false);
		}
	}

	class NewEnrollListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selectedCourse = newEnrollment.getList().getSelectedValue();
			String courseName = (String) selectedCourse;
			if (selectedCourse != null) {
				try {
					Course selCourse = courseService.getByName(courseName);
					Enrollment newEnroll = new Enrollment(selCourse, studentModel.getStudent());
					enrollmentService.insert(newEnroll);
					JOptionPane.showMessageDialog(null, "The enrollment was performed.", "Enrollment Status",
							JOptionPane.INFORMATION_MESSAGE);
					newEnrollment.setVisible(false);
					studentEnrollments.getListModel().addElement(courseName);
					studentEnrollments.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "No course selected", "Make enrollment", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	class RemoveEnrollmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selectedCourse = studentEnrollments.getList().getSelectedValue();
			String courseName = (String) selectedCourse;
			int selectedIndex = studentEnrollments.getList().getSelectedIndex();

			if (selectedCourse != null) {
				try {
					Course toRemoveCourse = courseService.getByName(courseName);
					Enrollment enroll = enrollmentService.getByStudentAndCourse(studentModel.getStudent(),
							toRemoveCourse);
					studentEnrollments.getListModel().removeElementAt(selectedIndex);
					enrollmentService.delete(enroll);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "No course selected.", "Remove Enrollment",JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	class BackEnrListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studentEnrollments.setVisible(false);
			studentAccountView.setVisible(true);
		}
	}

	class BackFromNewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newEnrollment.setVisible(false);
			studentEnrollments.setVisible(true);
		}
	}
}
