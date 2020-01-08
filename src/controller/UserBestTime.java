package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReportService;
import vo.Member;
import vo.Report;

@WebServlet("/UserBestTime")
public class UserBestTime extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ userBestTime Servlet 도착");
		
		int bestTime = 0;
		
		ReportService reportService = new ReportService();
		Report report = new Report();
		
		bestTime = reportService.bestTimeReport(report);
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		String json = gson.toJson(bestTime);
		
		response.getWriter().write(json);
		System.out.println("UserBestTime Servlet success!");
	}
}
