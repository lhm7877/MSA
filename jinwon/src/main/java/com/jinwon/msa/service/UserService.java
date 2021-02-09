package com.jinwon.msa.service;

import com.jinwon.msa.dto.UserDto;
import com.jinwon.msa.entity.UserEntity;
import com.jinwon.msa.enums.AuthorityType;
import com.jinwon.msa.message.ExceptionMessage;
import com.jinwon.msa.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    @NonNull
    private final UserRepository userRepository;

    @Transactional
    public boolean save(UserDto userDto) {
        UserEntity userEntity = userDto.of(userDto);
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Optional<UserEntity> userByAccount = userRepository.findByAccount(account);
        UserEntity userEntity = userByAccount
                .orElseThrow(() -> new UsernameNotFoundException(ExceptionMessage.NOT_EXIST_USER_ACCOUNT));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(AuthorityType.MEMBER.getValue()));

        return new User(userEntity.getAccount(), userEntity.getUniquePass(), authorities);
    }

}
