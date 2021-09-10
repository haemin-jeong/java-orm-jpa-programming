package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    /*
    필요하면 Member 조회하고 Order를 따로 조회하는 것이 좋다.
    회원의 주문이 필요하면 보통 Order 테이블에서 외래키를 가고 조회한다.
    이 코드는 예제로 넣은 것일뿐 잘못된 코드라고 생각된다.
     */
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
