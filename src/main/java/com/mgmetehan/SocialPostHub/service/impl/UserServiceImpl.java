package com.mgmetehan.SocialPostHub.service.impl;

import com.mgmetehan.SocialPostHub.converter.UsersConverter;
import com.mgmetehan.SocialPostHub.core.exception.ErrorStatusCode;
import com.mgmetehan.SocialPostHub.core.exception.GeneralException;
import com.mgmetehan.SocialPostHub.entity.Users;
import com.mgmetehan.SocialPostHub.repository.UsersRepository;
import com.mgmetehan.SocialPostHub.service.UsersService;
import com.mgmetehan.SocialPostHub.shared.model.resource.UsersRequest;
import com.mgmetehan.SocialPostHub.shared.model.resource.UsersUpdateRequest;
import com.mgmetehan.SocialPostHub.shared.model.response.UsersResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;


    @Override
    @Transactional
    public UsersResponse create(UsersRequest newUsers) {
        log.info("UserServiceImpl -> create is started, newUsers: {}", newUsers);
        //slack mesage send

        var users = usersRepository.save(usersConverter.toRequest(newUsers));
        var usersResponse = usersConverter.toResponse(users);

        log.info("UserServiceImpl -> create is finished, newUsers: {}", usersResponse);

        return usersResponse;
    }

    @Override
    public UsersResponse getById(String id) {
        log.info("UserServiceImpl -> getById is started, id: {}", id);

        Optional<Users> user = usersRepository.findById(id);
        if (user.isEmpty()) {
            throw new GeneralException(ErrorStatusCode.NOT_FOUND);
        }

        log.info("UserServiceImpl -> getById is finished, user: {}", user);

        return usersConverter.toResponse(user.get());
    }


    @Override
    public List<UsersResponse> getAll() {
        log.info("UserServiceImpl -> getAll is started");

        Optional<List<Users>> usersOptional = Optional.ofNullable(usersRepository.findAll());

        List<UsersResponse> usersResponseList = usersOptional
                .orElseThrow(() -> new RuntimeException("Users not found"))
                .stream()
                .map(usersConverter::toResponse)
                .collect(Collectors.toList());

        log.info("UserServiceImpl -> getAll is finished, users: {}", usersResponseList);

        return usersResponseList;
    }

    @Override
    public UsersResponse delete(String id) {
        log.info("UserServiceImpl -> delete is started, id: {}", id);

        Optional<Users> user = usersRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        usersRepository.deleteById(id);

        log.info("UserServiceImpl -> delete is finished, user: {}", user);

        return usersConverter.toResponse(user.get());
    }

    @Override
    public UsersResponse update(UsersUpdateRequest updateUsers) {
        log.info("UserServiceImpl -> update is started, updateUsers: {}", updateUsers);

        Optional<Users> user = usersRepository.findById(updateUsers.getId());
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        user.get().update(usersConverter.toUpdateRequest(updateUsers));
        var users = usersRepository.save(user.get());

        log.info("UserServiceImpl -> update is finished, users: {}", users);

        return usersConverter.toResponse(users);
    }

    @Override
    public List<String> getAllFirstNames() {
        log.info("UserServiceImpl -> getAllUsernames is started");

        List<String> usernames = usersRepository.findAllFirstNamesWithTodayCreatedAt();

        log.info("UserServiceImpl -> getAllUsernames is finished, usernames: {}", usernames);

        return usernames;
    }

    @Override
    public List<String> getAllEmails() {
        log.info("UserServiceImpl -> getAllEmails is started");

        LocalDate today = LocalDate.now();

        List<Users> todaysUsers = usersRepository.findByCreatedAtBetween(
                today.atStartOfDay(), today.atTime(23, 59, 59)
        );

        List<String> emailList = todaysUsers.stream()
                .map(Users::getEmail)
                .collect(Collectors.toList());

        log.info("UserServiceImpl -> getAllEmails is finished, emails: {}", emailList);

        return emailList;
    }
}
