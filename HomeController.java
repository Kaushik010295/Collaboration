package com.kaushik.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kaushik.dao.BlogDAO;
import com.kaushik.dao.UserDAO;
import com.kaushik.model.Blog;
import com.kaushik.model.User;

@Controller
public class HomeController {


	@Autowired
	UserDAO us;
	BlogDAO bd;
	@RequestMapping("/")
	public ModelAndView WelcomeController()
	{
		
		ModelAndView mv=new ModelAndView("Welcome");
		mv.addObject("signup"," <a href=\"SignUp\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a>" );
		mv.addObject("login", "<a href=\"Login\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a>");
		mv.addObject("exception", " Exception occured");
	System.out.println("index controller called");
		
		
		return mv;
	}
	@RequestMapping("/SignUp")
	public ModelAndView displayReg(){
		ModelAndView mv=new ModelAndView("SignUp");
		mv.addObject("login", "<a href=\"Login\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a>");

		System.out.println("reg page is from login controller");
		return mv;
	}
	@RequestMapping("/Login")
	public ModelAndView Logincontroller()
	{
		ModelAndView mv= new ModelAndView("Login");
		mv.addObject("signup"," <a href=\"SignUp\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a>" );

		System.out.println("Registration control called");
		
		
		return mv;
	}
	@ModelAttribute
	public Object returnObject()
	{
	return new User();	
	}
	@RequestMapping(value="/signupcontroller",method=RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, HttpServletRequest request, Principal p)
    {	
		ModelAndView mv;

		if(bindingResult.hasErrors())
		{
			System.out.println("If in register controller");
			return new ModelAndView("SignUp");
		}
		System.out.println(" register controller");
		user.setAdmin(false);
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		if(user.getUpassword().equals(user.getUconfirmpassword()))
		{
		//	String name = p.getName();
		us.saveOrUpdate(user);
		mv = new ModelAndView("Login");
		//mv.addObject("welcome", "hi" + name + "Welcome to Chat Hub");

		return mv;
		}
		else
		{
			mv = new ModelAndView("SignUp");

			mv.addObject("wrongpassword", "Password and confirmpassword didnt match try again");
			return mv;
		}
	
		
	}
	@ModelAttribute
	public Object returnObjectBlog()
	{
	return new Blog();	
	}
	@RequestMapping("/blog")
	public ModelAndView BlogController()
	{
		
		ModelAndView mv=new ModelAndView("blog");
		
		
		return mv;
	}
	@RequestMapping("/forum")
	public ModelAndView forumController()
	{
		
		ModelAndView mv=new ModelAndView("forum");
		
		
		return mv;
	}
	
	@RequestMapping(value="/bpost",method=RequestMethod.POST)
	public ModelAndView blogcreate(@ModelAttribute("blog") Blog blog,BindingResult bindingResult, HttpServletRequest request, Principal p)
    {
		
		if(bindingResult.hasErrors())
		{
			System.out.println("If in Blog controller");
			return new ModelAndView("blog");
		}
		
		blog.setBlogCreatedUser("kaushik");

		blog.setBlogCreationDate(new java.util.Date());
		bd.saveOrUpdate(blog);
		ModelAndView mv =new ModelAndView("Blog");
		return mv;
		
    
    }
	
	List<Blog> blist;
	//@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues()throws Exception
	{
	String result = "";
	blist = bd.getBlogList();
	Gson gson = new Gson();
	result = gson.toJson(blist);
	return result;
	}
	
	
}
