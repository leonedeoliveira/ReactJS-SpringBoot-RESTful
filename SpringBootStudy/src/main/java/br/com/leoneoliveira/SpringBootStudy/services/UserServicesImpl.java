package br.com.leoneoliveira.SpringBootStudy.services;

import br.com.leoneoliveira.SpringBootStudy.converter.DozerConverter;
import br.com.leoneoliveira.SpringBootStudy.data.model.Person;
import br.com.leoneoliveira.SpringBootStudy.data.vo.PersonVO;
import br.com.leoneoliveira.SpringBootStudy.exception.ResourceNotFoundException;
import br.com.leoneoliveira.SpringBootStudy.repository.interfaces.PersonRepository;
import br.com.leoneoliveira.SpringBootStudy.repository.interfaces.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var User = repository.findByUsername(username);
        if (User != null)
            return User;
        else
            throw  new UsernameNotFoundException("UserName:" + username + " not fount");
    }
}
