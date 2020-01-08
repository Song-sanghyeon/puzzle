package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/Join")
public class Join extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ join Servlet");
		
		// join.html에서 받은 값 저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		// 값 확인
		System.out.println("memberId : "+memberId);
		System.out.println("memberPw : "+memberPw);
		
		// Member 객체에 받아온 값 저장
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// Service로 세팅한 객체 보내기
		MemberService memberService = new MemberService();
		memberService.join(member);
	}
}
