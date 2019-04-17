package assigment2;
import javax.inject.Inject;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import assigment2.mvc.controller.HomePageController;
import assigment2.mvc.model.StudentModel;
import assigment2.mvc.model.TeacherModel;
import assigment2.mvc.view.HomePageView;
import assigment2.service.StudentService;
import assigment2.service.TeacherService;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {
	@Inject
	StudentService studentService;
	
	@Inject
	TeacherService teacherService;
	
	@Inject
	StudentModel studentModel;
	
	@Inject 
	TeacherModel teacherModel;
	
	@Inject
	HomePageController homePageController;
	
	@Inject
	HomePageView homePage;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		homePageController.init(studentModel,homePage,teacherModel);
		
	}

}
