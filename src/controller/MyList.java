package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ListService;
import vo.*;

@WebServlet("/MyList")
public class MyList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ MyList Servlet 도착");
		// 받아온 값 저장
		String memberId = request.getParameter("memberId");
		// 저장한 값 확인
		System.out.println("memberId : "+memberId);
		
		// memberId의 값을 member에 셋팅
		Report report = new Report();
		report.setMember(new Member());
		report.getMember().setMemberId(memberId);
		// 셋팅 되었는지 확인
		System.out.println("report : "+report);
		
		// service에 member를 매개변수로 list를 리턴
		ListService listService = new ListService();
		List<Report> list = new ArrayList<Report>();
		
		list = listService.myReportList(report);
		// 받아온 값 확인
		System.out.println("list : "+list);
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		
		response.getWriter().write(json);	
	}
}
