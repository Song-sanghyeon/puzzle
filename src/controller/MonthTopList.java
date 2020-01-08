package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ListService;
import vo.Report;

@WebServlet("/MonthTopList")
public class MonthTopList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ MonthTopList Servlet 도착");	
		
		ListService listService = new ListService();
		List<Report> list = new ArrayList<Report>();
		Report report = new Report();
		
		list = listService.monthTopList(report);
		System.out.println(list);
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		
		response.getWriter().write(json);
		
		System.out.println("MonthTopList Servlet success!");
	}
}
