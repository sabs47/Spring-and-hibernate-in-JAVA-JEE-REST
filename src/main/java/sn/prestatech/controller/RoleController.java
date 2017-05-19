package sn.prestatech.controller;

import java.util.List;

import javax.management.relation.Role;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import sn.prestatech.interfaces.manager.RoleService;
import sn.prestatech.model.Status;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleservices;
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	private Role role;




	static final Logger logger = Logger.getLogger(RoleController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Role role) {
		try {
			roleservices.addEntity(role);
			return new Status(1, "role create Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Role> getEmployee() {

		List<Role> role = null;
		try {
			role = roleservices.getEntityList();
			 MailMail email = new MailMail();
			 email.sendMail("hadjisabs@gmail.com","eminemsabaly@hotmail.fr", "test","did you get it");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return role;
	}	}
	
	

