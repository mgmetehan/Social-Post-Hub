package com.mgmetehan.SocialPostHub.task;

import com.mgmetehan.SocialPostHub.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDailyTask {
    private final UsersService usersService;

    @Scheduled(cron = "0 30 23 * * ? *")
    public void getAllUsernames() {
        try {
            log.info("UserDailyTask -> getAllUsernames is started");
            //send slack message
            usersService.getAllFirstNames();
        } catch (Exception ex) {
            log.error("UserDailyTask -> getAllUsernames", ex);
        }
    }

    @Scheduled(cron = "0 30 23 * * ? *")
    public void getAllEmails() {
        try {
            log.info("UserDailyTask -> getAllEmails is started");
            //send slack message
            usersService.getAllEmails();
        } catch (Exception ex) {
            log.error("UserDailyTask -> getAllEmails", ex);
        }
    }

}
