package sn.prestatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sn.prestatech.interfaces.manager.UsersService;
import sn.prestatech.model.Status;
import sn.prestatech.model.Users;
import org.apache.log4j.Logger;
import java.util.List;
@Controller
@RequestMapping("/users")
public class EtudiantController {
	@Autowired
	UsersService suerservices;
	private Users users;


	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	static final Logger logger = Logger.getLogger(EtudiantController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Users etudiant) {
		try {
			suerservices.addEntity(etudiant);
			return new Status(1, "user create Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Users> getEmployee() {

		List<Users> etudiant = null;
		try {
			etudiant = suerservices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return etudiant;
	}	}