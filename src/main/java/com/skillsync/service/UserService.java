package com.skillsync.service;

import com.skillsync.model.Role;
import com.skillsync.model.User;
import com.skillsync.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save new user
    public void saveUser(User user) {
        if (user.getRole() == null) {
            user.setRole(Role.USER);  // 👈 Default role laga diya
        }
        userRepository.save(user);
    }


    // Get user by username (Optional)
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    // Delete user by username
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    // Update user
    public boolean updateUser(String username, User updatedUser) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            // aur koi fields ho to set kar lena
            userRepository.save(existingUser);
            return true;
        }
        return false;
    }
}
