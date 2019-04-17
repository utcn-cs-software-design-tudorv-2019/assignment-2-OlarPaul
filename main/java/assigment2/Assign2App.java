package assigment2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import assigment2.mvc.controller.HomePageController;
import assigment2.mvc.model.StudentModel;
import assigment2.mvc.model.TeacherModel;
import assigment2.mvc.view.HomePageView;

import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class Assign2App {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Assign2App.class)
		.headless(false)
		.run(args);
	}
		
	@Bean
	public StudentModel createStudentModel() {
		return new StudentModel();
	}
	@Bean
	public HomePageController createHomePageController() {
		return new HomePageController();
	}
	@Bean
	public HomePageView HomeFrame() {
		return new HomePageView();
	}
	
	@Bean
	public TeacherModel createTeacherModel() {
		return new TeacherModel();
	}
	
}

