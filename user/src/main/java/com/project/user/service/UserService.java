package com.project.user.service;

import com.project.user.domain.UserType;
import com.project.user.message.event.UserTypeUpdatedEvent;
import com.project.user.repository.UserRepository;
import com.project.user.domain.Users;
import com.project.user.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public Users signUp(SignupDto signupDto){

        this.validateDuplicateUserId(signupDto.getUserId());

        SignupDto dto = SignupDto.builder()
                 .userId(signupDto.getUserId())
                 .password(passwordEncoder.encode(signupDto.getPassword()))
                 .name(signupDto.getName())
                 .build();

        return userRepository.save(new Users(dto));
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(user.getUserId(), user.getPassword(),
                true, true, true, true,
                Collections.emptyList()
        );
    }

    public Users getUser(String userId){
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void validateDuplicateUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new DuplicateKeyException("userId");
        }
    }

    public void updateUserType(UserTypeUpdatedEvent userTypeUpdatedEvent){
        Users user = getUser(userTypeUpdatedEvent.getUserId());
        user.setUserType(userTypeUpdatedEvent.getUserType());
        userRepository.save(user);
    }

}
