package com.cuatroa.retouno.service;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author dario
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
    /**
     * 
     * @param user
     * @return 
     */
    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            }else {
                return user;
            }
        } else{
            return user;
        }
    }    
    /**
     * 
     * @param email
     * @return 
     */
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        
        if (usuario.isEmpty()){
            return new User(email, password, "NO DEFINIDO");
        } else{
            return usuario.get();
        }
    }
    
} 


