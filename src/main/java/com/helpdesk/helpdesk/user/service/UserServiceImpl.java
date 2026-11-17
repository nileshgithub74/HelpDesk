package com.helpdesk.helpdesk.user.service;

import com.helpdesk.helpdesk.user.dto.UserRequestDTO;
import com.helpdesk.helpdesk.user.dto.UserResponseDTO;
import com.helpdesk.helpdesk.user.entity.User;
import com.helpdesk.helpdesk.user.enums.UserRole;
import com.helpdesk.helpdesk.user.enums.UserStatus;
import com.helpdesk.helpdesk.user.mapper.UserMapper;
import com.helpdesk.helpdesk.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static com.helpdesk.helpdesk.user.mapper.UserMapper.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        List<User> user = userRepository.findAllAndNotDeleted();

        // convert this to the response dto;
        return user.stream().map(UserMapper::EntitytoResponse).toList();


    }


    @Override
    public UserResponseDTO createUsers(@Valid UserRequestDTO userRequestDTO) {


        boolean exisitinguser = userRepository.existsByEmail(userRequestDTO.getEmail());

        if (exisitinguser) {
            return null;
//             throw new Throwable("User with this email already exist..!!"); /// later add on the
        }


        User user = RequestToEntity(userRequestDTO);

        //encode the password;
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashpassword = passwordEncoder.encode(user.getPassword());

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setPassword(hashpassword);

        user.setRole(UserRole.CUSTOMER);
        user.setStatus(UserStatus.ACTIVE);

        // save the data to databse now;
        User savedUser = userRepository.save(user);


        // now convert this to response;

        return EntitytoResponse(savedUser);


    }

    @Override
    public UserResponseDTO findUserById(Long id) {

        // check if there user exists;
        Optional<User> userExits = userRepository.findById(id);
        if (userExits.isEmpty()) {
            return null;
        }
        return EntitytoResponse(userExits.get());


    }

    @Override
    public UserResponseDTO updateUsers(Long Id, UserRequestDTO requestDTO) {
        // find the user by id :

        Optional<User> user = userRepository.findById(Id);
        if (user.isEmpty()) {
            return null;
        }
        // now changes the content;
        User exisitingUser = user.get();
        User updatedUser = UpdateMapper(requestDTO, exisitingUser);

        return EntitytoResponse(updatedUser);


    }

    @Override
    public UserResponseDTO deletedUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        }

        userRepository.deleteById(id);
        return null;

    }

    @Override
    public UserResponseDTO softDelete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        }

        User softDeleted = user.get();
        softDeleted.setDeleted(true);

        return null;

    }


}
