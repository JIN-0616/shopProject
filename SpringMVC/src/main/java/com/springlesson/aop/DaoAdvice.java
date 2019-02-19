package com.springlesson.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //root-context.xml에서 bean으로 등록할 수 있게 하는 어노테이션
@Aspect //spring aop의 a를 의미 -> aop 기술을 사용하겠다. aop:aspectj-autoproxy가 검사
public class DaoAdvice {
	private static final Logger logger = LoggerFactory.getLogger(DaoAdvice.class);
	
	//Join points 기술에는 Before(메소드 실행 전), After(메소드 실행 후), AfterReturning(반환된 값),
	//AfterThrowing(예외발생), Around(메소드가 실행되기 전 후)가 있다.
	//pointcuts 기술로 DAO에 어떤 메서드 Aspect를 적용할 것인지 결정
	@Before("execution(* com.springlesson.dao.*.*(..))")//Join points 기술
	public void startLog(JoinPoint joinPoint){//JoinPoint는 실행되는 메소드에 넘어오는 정보를 가지고 있다.
		//logger.info("method path : " + joinPoint.getSignature());	
	}//end

	@After("execution(* com.springlesson.dao.*.*(..))")
	public void endLog(JoinPoint joinPoint){
		//logger.info("method path : " + joinPoint.getSignature());
	}//end
	
	//@Around는 굉장히 강력한 AOP 기능으로 ProceedingJoinPoint으로 메소드 실행을 제어할 수 있다.
	//@Around는 꼭 반환 타입으로 pjp.proceed() 즉 Object를 써야하고 throws Throwable을 사용해야 한다.
	@Around("execution(* com.springlesson.dao.*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
		//해당 메소드가 실행되는 시간
		//logger.info("timeLog start");
		long startTime = System.currentTimeMillis(); //메소드 실행 전 시간
		Object result = pjp.proceed(); //메소드 실행
		long endTime = System.currentTimeMillis(); //메소드 실행 후 시간
		//logger.info("time Log end time:("+((endTime-startTime)/1000.0)+"초)");
		logger.info("time Log :("+((endTime-startTime)/1000.0)+"초)");
		return result;
	}//end
	
}//DaoAdvice class END
