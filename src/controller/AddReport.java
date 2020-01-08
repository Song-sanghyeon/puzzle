package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.ReportService;
import vo.Member;
import vo.Report;

@WebServlet("/AddReport")
public class AddReport extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ AddReport Servlet 도착");
		// 받아온 값 저장 및 확인 (report)
		String memberId = request.getParameter("memberId");
		int timer = Integer.parseInt(request.getParameter("timer"));
		int count = Integer.parseInt(request.getParameter("count"));
		int bestCombo = Integer.parseInt(request.getParameter("bestCombo"));
		int exp = Integer.parseInt(request.getParameter("exp"));
		// 받아온 값 저장 및 확인 (member)
		int level = Integer.parseInt(request.getParameter("level"));
		
		System.out.println("memberId : "+memberId);
		System.out.println("timer : "+timer);
		System.out.println("count : "+count);
		System.out.println("bestCombo : "+bestCombo);
		System.out.println("exp : "+exp);
		System.out.println("level : "+level);
	
		// report 객체 만들어서 객체에 값 셋팅
		Report report = new Report();
		report.setMember(new Member());
		report.getMember().setMemberId(memberId);
		report.setTimer(timer);
		report.setCount(count);
		report.setBestCombo(bestCombo);
		report.getMember().setLevel(level);
		// 확인
		System.out.println("report : "+report);
		
		// member 객체 만들어서 객체에 값 셋팅
		Member member = new Member();
		member.setLevel(level);
		member.setExp(exp);
		member.setMemberId(memberId);
		// 확인
		System.out.println("member : "+member);
		
		// report & member insert
		ReportService reportService = new ReportService();
		reportService.AddReport(report, member);
		
		System.out.println("AddReport success!");
	}
}
