package com.hackathon.wagle.domain.professor.initializer;


import com.hackathon.wagle.domain.professor.entity.Professor;
import com.hackathon.wagle.domain.professor.repository.ProfessorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProfessorInitializer {
    @Bean
    public CommandLineRunner init(ProfessorRepository repo) {
        return args -> {
            List<Professor> professors = List.of(
                    new Professor("윤유림", "yryoon", "컴퓨터공학전공", 325),
                    new Professor("이강윤", "keylee", "컴퓨터공학전공", 312),
                    new Professor("황희정", "hwanghj", "컴퓨터공학전공", 319),
                    new Professor("김우성", "wooseong", "컴퓨터공학전공", 326),
                    new Professor("김창복", "cbkim", "컴퓨터공학전공", 308),
                    new Professor("박양재", "parkyj", "컴퓨터공학전공", 314),
                    new Professor("오기욱", "king5", "컴퓨터공학전공", 328),
                    new Professor("왕보현", "bhwang99", "컴퓨터공학전공", 531),
                    new Professor("윤유림", "yryoon", "컴퓨터공학전공", 325),
                    new Professor("강석환", "shkang", "컴퓨터공학전공", 322),
                    new Professor("이병문", "bmlee", "컴퓨터공학전공", 311),
                    new Professor("이수현", "leesh", "컴퓨터공학전공", 317),
                    new Professor("이영호", "lyh", "컴퓨터공학전공", 320),
                    new Professor("황태호", "hth7277", "컴퓨터공학전공", 103),
                    new Professor("조영임", "yicho", "컴퓨터공학전공", 323),
                    new Professor("황성운", "sohwang", "컴퓨터공학전공", 330),
                    new Professor("최창", "changchoi", "컴퓨터공학전공", 315),
                    new Professor("한기태", "gthan", "컴퓨터공학전공", 316),
                    new Professor("황보택근", "tkwhangbo", "컴퓨터공학전공", 309),
                    new Professor("김원", "wonkimtx", "AI·소프트웨어학부", 401),
                    new Professor("노웅기", "wkloh2", "AI·소프트웨어학부", 422),
                    new Professor("정옥란", "orjeong", "AI·소프트웨어학부", 425),
                    new Professor("이상웅", "slee", "AI·소프트웨어학부", 416),
                    new Professor("최재혁", "jchoi", "AI·소프트웨어학부", 435),
                    new Professor("유 준", "joon.yoo", "AI·소프트웨어학부", 423),
                    new Professor("정용주", "yjung", "AI·소프트웨어학부", 430),
                    new Professor("최아영", "aychoi", "AI·소프트웨어학부", 434),
                    new Professor("민홍", "hmin", "AI·소프트웨어학부", 431),
                    new Professor("이주형", "j17.lee", "AI·소프트웨어학부", 424),
                    new Professor("강상우", "swkang", "AI·소프트웨어학부", 419),
                    new Professor("최재영", "jychoi19", "AI·소프트웨어학부", 420),
                    new Professor("조정찬", "thinkai", "AI·소프트웨어학부", 429),
                    new Professor("정윤현", "younhyun.jung", "AI·소프트웨어학부", 421),
                    new Professor("안종현", "jhonghyun", "AI·소프트웨어학부", 740),
                    new Professor("오현영", "hyoh", "AI·소프트웨어학부", 741),
                    new Professor("최재용", "andrewjchoi", "AI·소프트웨어학부", 428),
                    new Professor("구자경", "jakeoung", "AI·소프트웨어학부", 433),
                    new Professor("조풍진", "pjcho", "AI·소프트웨어학부", 417),
                    new Professor("한명묵", "mmhan", "AI·소프트웨어학부", 401),
                    new Professor("정성철", "scchung", "AI·소프트웨어학부", 530),
                    new Professor("이형철", "hchullee", "AI·소프트웨어학부", 421),
                    new Professor("임정준", "leemjj", "AI·소프트웨어학부", 129),
                    new Professor("김현구", "traveler", "AI·소프트웨어학부", 324),
                    new Professor("김해림", "haeriming52", "AI·소프트웨어학부", 505),
                    new Professor("황호은", "zzxz", "AI·소프트웨어학부", 305),
                    new Professor("한상연", "hsyeon", "AI·소프트웨어학부", 405),
                    new Professor("신윤정", "yunyun3855", "AI·소프트웨어학부", 305),
                    new Professor("김보미", "swdm", "AI·소프트웨어학부", 406),
                    new Professor("김태웅", "swdm", "AI·소프트웨어학부", 201)
            );

            for (Professor professor : professors) {
                repo.save(professor);
            }

        };
    }

}
