package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.services.UserService;

@Controller
@RequestMapping("Admin")
public class AdminController {
	private final UserService userService;
	
	@Autowired
	public AdminController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/doctorManagement", method = RequestMethod.GET)
	public String doctorManagement(HttpServletRequest request) {
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";		
	}
	
	@RequestMapping(value ="/deleteDoctor", method = RequestMethod.GET)
	public String deleteDoctor(HttpServletRequest request) {
		int idDoctor = Integer.parseInt(request.getParameter("id"));
		userService.deleteUserById(idDoctor);
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";
	}
	
	@RequestMapping(value ="/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
		return "homeAdmin";
	}
	
	/*
	 * 
	 * final int idUpd = Integer.parseInt(request.getParameter("id"));
			final String nameUpdate = request.getParameter("name");
			final String surnameUpdate = request.getParameter("surname");
			final String usernameUpdate = request.getParameter("username");
			final String passwordUpdate = request.getParameter("password");
			final String type = request.getParameter("type");
			final boolean state = Boolean.parseBoolean(request.getParameter("state"));
			
			final DoctorDTO doctor = new DoctorDTO(nameUpdate,surnameUpdate,usernameUpdate,passwordUpdate,type,state);
			doctor.setDoctorId(idUpd);
				
			adminServiceDTO.updateDoctor(doctor);
			showAllDoctor(request, response);
	 */
	
	@RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request)
	{
		int idUpd = Integer.parseInt(request.getParameter("id"));
		String nameUpdate = request.getParameter("name");
		String surnameUpdate = request.getParameter("surname");
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		//String type = request.getParameter("type");
		boolean state = Boolean.parseBoolean(request.getParameter("state"));
		
		final UserDTO doctor = new UserDTO(nameUpdate,passwordUpdate,usernameUpdate,"doctor",surnameUpdate,state);
		doctor.setUserId(idUpd);
		
		userService.updateUser(doctor);
		request.setAttribute("doctor", getDoctor());
		return "doctorManagement";	
		
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idDoctor = Integer.parseInt(request.getParameter("id"));
		
		UserDTO doctor = userService.getUserDTOById(idDoctor);
		
		request.setAttribute("doctor", doctor);
		return "updateDoctor";
	}
	
	@RequestMapping(value = "/insertDoctor", method = RequestMethod.POST)
	public String insertDoctor(HttpServletRequest request) {
		
		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("user_pass");
		String userSurname = request.getParameter("user_surname");
		String userUser = request.getParameter("user_user");
		
		UserDTO userDTO = new UserDTO(userName, userPass, userUser, "doctor", userSurname, true);
		
		userService.insertUser(userDTO);
		
		request.setAttribute("doctor", getDoctor());
		
		return "doctorManagement";		
	}
	
	public List<UserDTO> getDoctor() {
		List<UserDTO> tmpList = userService.getListaUserDTO();
		List<UserDTO> doctorList = new ArrayList<>();
		for(UserDTO user: tmpList) {
			if(user.getUserType().equals("doctor")) {
				doctorList.add(user);
			}
		}
		return doctorList;
	}
}
