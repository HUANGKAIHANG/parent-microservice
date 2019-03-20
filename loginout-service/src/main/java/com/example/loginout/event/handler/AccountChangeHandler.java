package com.example.loginout.event.handler;

import com.example.loginout.event.model.AccountChangeModel;
import com.example.loginout.event.sink.AccountChangeSink;
import com.example.loginout.model.Account;
import com.example.loginout.repository.AccountRepository;
import com.example.loginout.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(AccountChangeSink.class)
public class AccountChangeHandler {

    private static final Logger logger = LoggerFactory.getLogger(AccountChangeHandler.class);

    @Autowired
    private AccountRepository accountRepository;

    @StreamListener("accountChangeInput")
    public void handle(AccountChangeModel model) {
        logger.info("监听到消息队列有新消息" + model.getUsername());
        Account account = Account.builder().username(model.getUsername())
                .password(model.getPassword())
                .accountType(model.getAccountType()).build();
        accountRepository.save(account);
    }
}
