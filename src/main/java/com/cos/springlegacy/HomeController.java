package com.cos.springlegacy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.springlegacy.dto.RequestInfoDto;

/*http://localhost:8080/springlegacy/
*/
//Controller annotation은 페이지를 리턴하는 어노테이션이다 

@Controller

public class HomeController {
	/*
	 *  1. 데이터 전달(1)Query , form 데이터 , JSon (request Param으로 받음)//json은 DTO  만들어서 한방에 만들기 
	 *  2. 데이터 받기(1)Query , form 데이터 , JSon 
	 *  3. pathvariable 사용해보기 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String  home(Model model) {
		// 린턴하는 순간 컨드롤러 어노테이션이 있는 클래스에서 함수가 return 하는 순간 view resolver 가 관여하여 prefix와 suffix를 만들어서 페이지를 return을 해준다.webinf를 달고 ! 
	
		/* HttpServelet 적기만 하면 DW 주입해줌 */
		/* req.setAttribute("username", "ssar"); 이게 된다는 거임  Cookie, session 다 됨 */
		/*톰캣은 request, response를 만들어주는데  spring model(requestDispatcher, request)을 만들어줌-->model을 "뷰"라고 함. */ 
		// request에 담기 => model
		String username="ssar";
		model.addAttribute("username",username);//String , Object
		return "home";
		
		
	}
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String  hello(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {//Query String, x-www-forunlenchoded받을 수 있음 
		
		
		//@RequestParam("id") 생략 가능
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		
		return "hello";// 린턴하는 순간 컨드롤러 어노테이션이 있는 클래스에서 함수가 return 하는 순간 view resolver 가 관여하여 prefix와 suffix를 만들어서 페이지를 return을 해준다.webinf를 달고 ! 
		
	}
	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String  goodbye(RequestInfoDto requestInfoDto) {
		
		System.out.println("addr:"+requestInfoDto.getAddr());
		System.out.println("hobby"+requestInfoDto.getHobby());
		return "goodbye";// 린턴하는 순간 컨드롤러 어노테이션이 있는 클래스에서 함수가 return 하는 순간 view resolver 가 관여하여 prefix와 suffix를 만들어서 페이지를 return을 해준다.webinf를 달고 !
		
//		데이터 리턴을 할 때, 
		
	}
	
	
}

