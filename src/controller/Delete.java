package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/Delete")
public class Delete extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ Delete Servlet 도착");
		// 받아온 값 저장 확인
		String memberId = request.getParameter("memberId");
		System.out.println("memberId : "+memberId);
		
		// member 객체에 셋팅
		Member member = new Member();
		member.setMemberId(memberId);
		// 확인
		System.out.println("member : "+member);
		
		// 셋팅한 객체를 매개변수로 service 실행
		MemberService memberService = new MemberService();
		memberService.delete(member);
		System.out.println("delete servlet success!");
	}
}
