package hello.toy.LogTrace;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/aopTest")
public class LogTraceController {

    private final TestService test1;

    @LogTrace
    @GetMapping("/v1")
    public String tt() throws Exception{
        SleepThread.sleep();
        String result = test1.t1();
        return result;
    }


}
