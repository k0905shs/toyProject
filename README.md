
# 1. AOP 로그 추적기
#### (hello.toy.logTrace.정리.txt)    
#### 위치 : hello.toy.logTrace  
#### Spring AOP를 활용해서 만든 Log 추적기호출기  
#### 각각의 Layer Level을 표현을 구현하기 위해 ThreadLocal을 사용해서 각 Thread마다 쓰레드 지역 변수를 가질 수 있도록 했다.  
#### 로그 추적 결과 :
[ID]  level 위치 ,  메소드 위치, level, (예외 발생시) 예외 정보  
#### (정상 호출)
[e3991604]   --> , location : String hello.toy.LogTrace.LogTraceController.tt(), level : 1  
[e3991604]  |   | --> , location : String hello.toy.LogTrace.TestService.t1(), level : 2  
[e3991604]  |   ||   | --> , location : String hello.toy.LogTrace.TestService.t2(), level : 3  
[e3991604]  |   ||   ||   | --> , location : String hello.toy.LogTrace.TestRepository.t3(), level : 4  
[e3991604]  |   ||   ||   | <-- , location : String hello.toy.LogTrace.TestRepository.t3(), level : 4  
[e3991604]  |   ||   | <-- , location : String hello.toy.LogTrace.TestService.t2(), level : 3  
[e3991604]  |   | <-- , location : String hello.toy.LogTrace.TestService.t1(), level : 2  
[e3991604]   <-- , location : String hello.toy.LogTrace.LogTraceController.tt(), level : 1  

#### (예외 발생)
[9ce3388a]   --> , location : String hello.toy.LogTrace.LogTraceController.tt(), level : 1  
[9ce3388a]  |  | --> , location : String hello.toy.LogTrace.TestService.t1(), level : 2  
[9ce3388a]  |   ||   | --> , location : String hello.toy.LogTrace.TestService.t2(), level : 3  
[9ce3388a]  |   ||   ||   | --> , location : String hello.toy.LogTrace.TestRepository.t3(), level : 4  
[9ce3388a]  |   ||   ||   | x-- , location : String hello.toy.LogTrace.TestRepository.t3(), level : 4, Exception : java.lang.IllegalStateException  
[9ce3388a]  |   ||   | x-- , location : String hello.toy.LogTrace.TestService.t2(), level : 3, Exception : java.lang.IllegalStateException  
[9ce3388a]  |   | x-- , location : String hello.toy.LogTrace.TestService.t1(), level : 2, Exception : java.lang.IllegalStateException  
[9ce3388a]   x-- , location : String hello.toy.LogTrace.LogTraceController.tt(), level : 1, Exception : java.lang.IllegalStateException  
  
2022-01-26 16:35:42.470 ERROR 18116 --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.IllegalStateException] with root cause
