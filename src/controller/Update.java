package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ Update Servlet 도착");
		// update.html에서 입력한 패스워드의 값을 저장할 변수 만들고 값 저장
		String newMemberPw = request.getParameter("newMemberPw");
		String memberId = request.getParameter("memberId");
		String newMemberLevel = request.getParameter("newMemberLevel");
		
		// 확인
		System.out.println("newMemberPw : "+newMemberPw);
		System.out.println("memberId : "+memberId);
		System.out.println("newMemberLevel : "+newMemberLevel);
		
		// member 객체에 셋팅
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(newMemberPw);
		member.setMemberLevel(newMemberLevel);
		// 확인
		System.out.println("member : "+member);
		
		// 셋팅한 객체를 매개변수로 service 실행
		MemberService memberService = new MemberService();
		memberService.update(member);
		System.out.println("update servlet success!");
	}
}
