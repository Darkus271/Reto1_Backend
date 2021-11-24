package com.cuatroa.retouno.repository;

import com.cuatroa.retouno.repository.crud.UserCrudRepository;
import com.cuatroa.retouno.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author dario
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;
    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}

