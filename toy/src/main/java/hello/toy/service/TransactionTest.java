package hello.toy.service;

import hello.toy.dao.TestMapper;
import hello.toy.dto.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionTest {

    private final TestMapper testMapper;

    //insert,insert,delete
    //프록시로 DI를 할떄 함 감싸주니까 아마 txTest를 바로 호출하면 안돼지 않을까 싶은데
    @Transactional
    public String txTest()throws Exception{
        log.info(TransactionSynchronizationManager.getCurrentTransactionName());

        String random = UUID.randomUUID().toString().substring(0,8);

        User a = new User(random,"pass","a1","aa");

        testMapper.insertUser(a);

        return "ok";
    }

    public void callTx()throws Exception{
        String random = UUID.randomUUID().toString().substring(0,8);

        User a = new User(random,"pass","a1","aa");

        txTest2(a);
    }

    private void txTest2(User user){
        testMapper.insertUser(user);
    }




}
