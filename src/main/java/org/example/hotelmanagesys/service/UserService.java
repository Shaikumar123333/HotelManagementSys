package org.example.hotelmanagesys.service;

import lombok.AllArgsConstructor;
import org.example.hotelmanagesys.Dto.RegisterRequest;
import org.example.hotelmanagesys.Dto.UserDTO;
import org.example.hotelmanagesys.entity.Hotel;
import org.example.hotelmanagesys.entity.User;
import org.example.hotelmanagesys.exception.ResourceNotFoundException;
import org.example.hotelmanagesys.mapper.HotelMapper;
import org.example.hotelmanagesys.mapper.UserMapper;
import org.example.hotelmanagesys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository  userRepository;

    //create user

    public UserDTO createUser(RegisterRequest req){
        User user = new User();
        user.setEmail(req.getEmail());
        user.setName(req.getName());
        user.setPassword(req.getPassword());
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    //get all

    public List<UserDTO> getAll(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    //get by id

    public UserDTO getUserById(long id){
        User user =  userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("user not found"));

        return UserMapper.toDTO(user);
    }

    //delete

    public String deleteUser(long id){
        userRepository.deleteById(id);
        return "user deleted successfully";
    }
}
