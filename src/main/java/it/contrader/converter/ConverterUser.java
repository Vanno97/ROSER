package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class ConverterUser {

	public static UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setUserId(user.getUserId());
			userDTO.setUserName(user.getUserName());
			userDTO.setUserPass(user.getUserPass());
			userDTO.setUserUser(user.getUserUser());
			userDTO.setUserSurname(user.getUserSurname());
			userDTO.setUserType(user.getUserType());
			userDTO.setUserState(user.isUserState());
		}
		return userDTO;
	}

	public static User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setUserId(userDTO.getUserId());
			user.setUserName(userDTO.getUserName());
			user.setUserPass(userDTO.getUserPass());
			user.setUserUser(userDTO.getUserUser());
			user.setUserSurname(userDTO.getUserSurname());
			user.setUserType(userDTO.getUserType());
			user.setUserState(userDTO.isUserState());
		}
		return user;
	}

	public static List<UserDTO> toListDTO(List<User> list) {
		List<UserDTO> listUserDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (User user : list) {
				listUserDTO.add(ConverterUser.toDTO(user));
			}
		}
		return listUserDTO;
	}

	public static List<User> toListEntity(List<UserDTO> listUserDTO) {
		List<User> list = new ArrayList<>();
		if (!listUserDTO.isEmpty()) {
			for (UserDTO userDTO : listUserDTO) {
				list.add(ConverterUser.toEntity(userDTO));
			}
		}
		return list;
	}
}
