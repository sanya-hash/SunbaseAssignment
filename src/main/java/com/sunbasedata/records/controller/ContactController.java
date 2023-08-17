package com.sunbasedata.records.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunbasedata.records.entity.Contact;
import com.sunbasedata.records.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="/addcontact" , method=RequestMethod.POST)
	public ModelAndView add(HttpServletResponse response) throws IOException{
		return new ModelAndView("addcontact");
	}
	@RequestMapping(value="/welcome")
	public ModelAndView gotoWelcome(HttpServletResponse response) throws IOException{
		return new ModelAndView("welcome");
	}
	@RequestMapping(value="/delete")
	public String deleteData(@RequestParam("uuid") String uuid,@RequestParam("token") String access_token) {
		contactService.deleteContact(uuid,access_token);
		return "redirect:/welcome";
	}
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	public ModelAndView addData(@RequestParam("first_name") String first_name,
			                       @RequestParam("last_name") String last_name,
			                       @RequestParam("street") String street,
			                       @RequestParam("address") String address,
			                       @RequestParam("city") String city,
			                       @RequestParam("state") String state,
			                       @RequestParam("email") String email,
			                       @RequestParam("phone") String phone,
			                       @RequestParam("token") String token,Model model) throws IOException{
		Contact c = new Contact(first_name,last_name,street,address,city,state,email,phone);
		String result = contactService.addContact(c,token);
		System.out.println("result"+result);
	    if(!result.equals("Successfully Created")) {
	    	boolean success=false;
	    	model.addAttribute("success", success);
	    }else {
	    	boolean success = true;
	    	model.addAttribute("success", success);
	    }
		return new ModelAndView("addcontact");
	}
	@RequestMapping(value="/edit")
	public ModelAndView openEdit(@RequestParam("uuid") String uuid,
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
            @RequestParam("street") String street,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("token") String token,Model model) {
		Contact contact = new Contact(first_name,last_name,street,address,city,state,email,phone);
		model.addAttribute("token", token);
		model.addAttribute("contact", contact);
		model.addAttribute("uuid", uuid);
		return new ModelAndView("editcontact");
	}
	@RequestMapping(value="/update")
	public ModelAndView updateData(
			@RequestParam("uuid") String uuid,
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
            @RequestParam("street") String street,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("token") String token,Model model) {
		Contact contact = new Contact(first_name,last_name,street,address,city,state,email,phone);
		String result = contactService.updateContact(contact, token, uuid);
	    boolean success = false;
	    if(result.equals("Successfully Updated")) {
	    	success = true;
	    }
	    model.addAttribute("success", success);
		return new ModelAndView("editcontact");
	}
	@RequestMapping(value="/add")
	public ModelAndView gotoAdd() {
		return new ModelAndView("addcontact");
	}
	
}
