package controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import service.StudentService;

@Controller
public class StudentController {
	
	@Inject
	StudentService studentService;

}
