package com.reservationsystem.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservationsystem.converters.FormToReservation;
import com.reservationsystem.modelForms.ReservationForm;
import com.reservationsystem.models.User;
import com.reservationsystem.services.HotelService;
import com.reservationsystem.services.RoomService;
import com.reservationsystem.services.UserService;

@Controller
public class HotelController {
	
	private UserService userService;
	
	private HotelService hotelService;
	
	private RoomService roomService;
	
	private FormToReservation formToReservation;

    @Autowired
    public void setFormToReservation(FormToReservation formToReservation) {
    	this.formToReservation = formToReservation;
    }
	@Autowired
    public void setRoomService(RoomService roomService) {
    	this.roomService = roomService;
    }
	@Autowired
    public void setHotelService(HotelService hotelService) {
    	this.hotelService = hotelService;
    }
	
    @Autowired
    public void setUserService(UserService userService) {
    	this.userService = userService;
    }
		
	@PostMapping(value="/makereservation")
	public String reservation(@Valid ReservationForm reservationForm, BindingResult bindingResult, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null){
			session.removeAttribute("notification");
			session.setAttribute("notifications", userService.getNotifications(user));
			hotelService.makeReservation(reservationForm, user);
			return "/";
		}
		else {
			session.setAttribute("notification", "You are not logged in.");
			return "/login";
		}
	}
	@GetMapping(value="/makereservation")
	public String reservationForm(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null){
			session.removeAttribute("notification");
			session.setAttribute("notifications", userService.getNotifications(user));
			HashMap<Integer, String> categories = roomService.getCategories();
			session.setAttribute("categories", categories);
			return "makereservation";
		}
		return "/";
	}
		
	@RequestMapping(value="/postjob",method = RequestMethod.POST)
	public String postjob(HttpServletRequest req, HttpSession session){
		boolean valid = true;
		String title = req.getParameter("title");
		String desc = req.getParameter("description");
		String budget  = req.getParameter("budget");
		String category = req.getParameter("category");
		String reqExp = req.getParameter("reqExp");
		String expire = req.getParameter("expire");
		boolean isSponsored = false;
		String page = "index";
		if (session.getAttribute("user") != null) {
			session.removeAttribute("notification");
			session.setAttribute("notifications", UserDAO.getNotifications((User) session.getAttribute("user")));
			User user = (User) session.getAttribute("user");
			if(title.isEmpty() || desc.isEmpty() || budget.isEmpty() || category.isEmpty() || reqExp.isEmpty() || expire.isEmpty()){
				valid = false;
			}
			if(valid){
				Job job = new Job(user, title, desc, Integer.parseInt(budget), Integer.parseInt(category), Integer.parseInt(reqExp), isSponsored, Integer.parseInt(expire), null);
				try {
					JobDAO.getInstance().postJob(job);
					session.setAttribute("notification", "Your job was posted successfully.");
				} catch (SQLException e) {
					System.out.println("Job posting error - " + e.getMessage());
					HashMap<Integer, String> categories = UserDAO.getCategories();
					req.setAttribute("categories", categories);
					session.setAttribute("notification", "There was an error with your job. Please try again.");
					page = "postjob";
				}
			}
			else{
				HashMap<Integer, String> categories = UserDAO.getCategories();
				req.setAttribute("categories", categories);
				session.setAttribute("notification", "One ore more fields were empty. Please try again.");
				page = "postjob";
			}
		}
		return page;
	}
}
