package com.hackathon.wagle.domain.user.service;

import com.hackathon.wagle.domain.user.dto.request.UserRequestDto;
import com.hackathon.wagle.domain.user.entity.User;
import com.hackathon.wagle.domain.user.exception.DuplicatedStudentNumberException;
import com.hackathon.wagle.domain.user.exception.UserNotFoundException;
import com.hackathon.wagle.domain.user.repository.UserRepository;
import com.hackathon.wagle.test.TestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserRequestDto dto) {
        // 학번, 학교 이메일 유효성 검증
        checkDuplicatedStuentNumber(dto.studentNumber());
        checkDuplicatedEmail(dto.email());

        User user = User.of(dto);
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
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
