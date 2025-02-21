package com.hackathon.wagle.domain.user.service;

import com.hackathon.wagle.domain.user.dto.request.UserRequestDto;
import com.hackathon.wagle.domain.user.dto.request.UserLoginDto;
import com.hackathon.wagle.domain.user.dto.response.LoginDto;
import com.hackathon.wagle.domain.user.dto.response.UserResponseDto;
import com.hackathon.wagle.domain.user.entity.User;
import com.hackathon.wagle.domain.user.exception.DuplicatedStudentNumberException;
import com.hackathon.wagle.domain.user.exception.UserNotFoundException;
import com.hackathon.wagle.domain.user.repository.UserRepository;
import com.hackathon.wagle.global.auth.jwt.utils.JwtProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Transactional
    public void saveUser(UserRequestDto dto) {
        // 학번, 학교 이메일 유효성 검증
        checkDuplicatedStuentNumber(dto.studentNumber());
        checkDuplicatedEmail(dto.email());

        User user = User.of(dto);
        userRepository.save(user);
    }

    public LoginDto login(UserLoginDto dto) {
        User user = findByStudentNumber(dto.studentNumber());
        String token = generateToken(user);

        return LoginDto.of(UserResponseDto.from(user), token);
    }


    /*
    * refactor
    * */

    public String generateToken(User user) {
        return jwtProvider.generateAccessToken(
                user.getId(), user.getEmail(), user.getRole().name()
        );
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User findByStudentNumber(String studentNumber) {
        return userRepository.findByStudentNumber(studentNumber)
                .orElseThrow(UserNotFoundException::new);
    }

    private void checkDuplicatedStuentNumber(String studentNumber) {
        userRepository.findByStudentNumber(studentNumber)
                .ifPresent(user -> { throw new DuplicatedStudentNumberException(); });
    }

    private void checkDuplicatedEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(user -> { throw new DuplicatedStudentNumberException(); });
    }

}
