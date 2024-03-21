package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok은 Java의 반복적인 코드를 줄여 주는 라이브러리. @Getter/Setter, @ToString 등 사용
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Offer {
    private int id;
    private String name;
    private String email;
    private String text;
}
