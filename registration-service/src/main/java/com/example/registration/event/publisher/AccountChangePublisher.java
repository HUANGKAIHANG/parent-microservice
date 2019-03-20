package com.example.registration.event.publisher;

import com.example.registration.event.model.AccountChangeModel;
import com.example.registration.event.source.AccountChangeSource;
import com.example.registration.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(AccountChangeSource.class)
public class AccountChangePublisher {

    private static final Logger logger = LoggerFactory.getLogger(AccountChangePublisher.class);

    @Autowired
    private AccountChangeSource source;

    public void publish(Account account){
        AccountChangeModel model = new AccountChangeModel(
                account.getUsername(),
                account.getPassword(),
                account.getAccountType()

        );
        logger.info("注册服务发送队列信息name:{} password:{} type:{}",
                account.getUsername(),account.getPassword(),account.getAccountType());
        source.output().send(MessageBuilder.withPayload(model).build());
    }
}
