package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.MemberDao;
import service.MemberService;
import vo.Member;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ login servlet"); // 서블릿 도착
		String memberId = request.getParameter("memberId"); // login.html ajax에서 data로 받은 값 저장
		String memberPw = request.getParameter("memberPw");
		System.out.println("memberId : "+memberId); // 확인
		System.out.println("memberPw : "+memberPw);
		
		Member member = new Member(); // 넘겨받은 값 Member에 set
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		MemberService memberService = new MemberService();
		// set 해준 member를 매개변수로 사용하여 service에 있는 login 메소드 실행
		String returnMemberId = memberService.login(member);
		System.out.println("returnMemberId : "+returnMemberId);
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("sessionInfo", returnMemberId);
		
		System.out.println("loginServlet success!");
	}
}
