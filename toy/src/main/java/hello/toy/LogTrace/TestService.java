package hello.toy.LogTrace;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository test2;

    /**
     * 자기 자신을 DI로 받으면 순환 참조 에러가 발생한다.(생성자 주입 사용시)
     * 이런식으로 순환 참조 하게 될 경우 부트 버전 2.6이상은 순환참조 에러 발생
     * 가장 좋은 방법은 순환 참조할 경우를 아예 없에면 좋지만 이거는 테스트 이니까 만들어 봄
     */
//    private final Test1 test1;

    /**
     * 객체 지연 조회 사용
     *     private final ObjectProvider<Test1> test1;
     *         Test1 test1 = this.test1.getObject();
     */
    private final ObjectProvider<TestService> test1;


    @LogTrace
    public String t1() {
        SleepThread.sleep();
        TestService test1 = this.test1.getObject();
//        return t2();//그냥 이렇게 호출하면 AOP 프로시 적용된 t2()가 아니라 이 인스턴스의 t2가 불려진다!!!!
        return test1.t2();
    }


    @LogTrace
    public String t2(){
        SleepThread.sleep();
        /**
         * 20퍼 확률로 로직 처리중 예외 발생
         */
        if (Math.random() < 0.2){
            throw new NullPointerException();
        }

        return test2.t3();
    }


}
