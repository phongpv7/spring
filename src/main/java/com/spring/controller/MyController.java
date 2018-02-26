package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.oderDetail;
import com.spring.service.OrderDetailsService;

@Controller
@RequestMapping("/")
public class MyController {

	@Autowired
	OrderDetailsService service;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listStudents(ModelMap model) {
		Integer id = null;
		List<oderDetail> students = service.getOrderDetails(id);
		model.addAttribute("orders", students);
		model.addAttribute("searchOrder", new oderDetail());
		return "index";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String listStudentsSearch(ModelMap model,@ModelAttribute("searchOrder") oderDetail odr) {
		List<oderDetail> students = service.getOrderDetails(odr.getOrderID());
		model.addAttribute("orders", students);
		model.addAttribute("searchOrder", odr);
		return "index";
	}
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteID(HttpServletRequest reques) {
		String bien1 = reques.getParameter("oid").toString();
		String bien2 = reques.getParameter("pid").toString();
		int oid = Integer.parseInt(bien1);
		int pid = Integer.parseInt(bien2);
		service.delete(oid, pid);
		return "redirect:/";
	}
	@RequestMapping(value = {"/edit"},method =  RequestMethod.GET)
	public String getID(HttpServletRequest reques,Model model) {
		String bien1 = reques.getParameter("oid").toString();
		String bien2 = reques.getParameter("pid").toString();
		int oid = Integer.parseInt(bien1);
		int pid = Integer.parseInt(bien2);
		model.addAttribute("orderDetail", service.getDetail(oid, pid));
		return "edit";
	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("searchOrder") oderDetail odr) {
		service.save(odr);
		return "redirect:/";
	}
}
