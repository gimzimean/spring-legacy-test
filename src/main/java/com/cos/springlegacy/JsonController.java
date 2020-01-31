package com.cos.springlegacy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springlegacy.dto.RequestJsonDto;

@Controller//IOC
public class JsonController {
	//Spring은 form의 name값과 혹은 QueryString만 Object로 자동 변환 해줌.--> 원초적인 방법인 getReader Buffered Reader 사용하면됨.
	@RequestMapping(value = "/jsonTest", method = RequestMethod.POST)//get으로는  json 안됨  get 방식을 querySTring 만됨.하지만,!!json은 DTo만드는게 최고임
	public @ResponseBody RequestJsonDto jsonTest(@RequestBody RequestJsonDto requestJsonDto) {//{JSON} spring은 "="로 되어있는 걸로 바꿔야함. 그래서 객체로 바꿔야함. 
		// 이 어노테이션 view resolver가 관여 못함 이렇게 하면 
		//통신시 json stream이 필요함. 
		
		/*
		 * Map<String, Object>; ---> requestJsonDto.getId("id);
		 */
		System.out.println(requestJsonDto.getId());
		return requestJsonDto;// 이렇게 하면 오류ㅇ남--> 그래서 @Responsebody을 붙여야함. 
		/* AOP: 관점지향 프로그램 -- 필요없는 거는 버리기 */
	}
	
	//http://localhost:8080/springlegacy/jsonHome/안녕(다 들어옴) -------페이징 할떄 .
	@RequestMapping(value = "/jsonHome/{num}", method = RequestMethod.GET)//num은 변수임 
	public String JsonHome(@PathVariable("num")  int num) {
		
		System.out.println("num:"+num);
		
	
	return "jsonHome";
	}

}
