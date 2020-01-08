package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;
import vo.Report;

@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("▶▶▶▶▶ userinfo servlet 도착");
		// 넘겨받은 데이터값 저장할 변수 만들고 저장 후 확인
		String memberId = request.getParameter("memberId");
		System.out.println("memberId : "+memberId);
		
		// member의 데이터를 가지고와야하기때문에, memberService 호출
		MemberService memberService = new MemberService();
		// member의 객체를 생성해서 객체에서 level과 exp 가져와서 json의 저장
		
		Member member = new Member();
		
		// 멤버 객체에 해당 로그인되어있는 유저의 id값을 셋팅
		member.setMemberId(memberId);
		
		// 현재 로그인되어있는 유저의 id값이 저장되어있는 멤버객체를 매개변수로 service에 userInfo 메소드 호출
		member = memberService.userInfo(member);
		// 현재 로그인되어있는 유저의 해당하는 level과 exp값이 제대로 들어와있는지 확인
		System.out.println("member : "+member);
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		String json = gson.toJson(member);
		System.out.println("json : "+json);
		
		response.getWriter().write(json);
		System.out.println("UserInfo Servlet success!");
	}
}
