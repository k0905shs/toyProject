package hello.toy.controller;

import hello.toy.dao.TestMapper;
import hello.toy.service.TransactionTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {
    private final TestMapper testMapper;
    private final TransactionTest transactionTest;

    @GetMapping("/")
    public String main(){
        testMapper.selectAll();
        return "ok";
    }

    @GetMapping("/Transaction")
    public String mai(){
        try {
            transactionTest.txTest();
            log.info("tx완료");
        } catch (Exception e) {
            return "transaction_status";
        }

        try {
            transactionTest.callTx();
            log.info("2개 들어갔냐");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }

}
