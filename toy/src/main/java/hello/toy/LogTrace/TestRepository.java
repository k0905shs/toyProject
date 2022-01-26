package hello.toy.LogTrace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TestRepository {

    @LogTrace
    public String t3(){
        SleepThread.sleep();
        //30퍼 확률로 DB관련 작업을 하다가 예외 발생
        if(Math.random() < 0.4){
            throw new IllegalStateException();
        }
        return "ok";
    }

}
