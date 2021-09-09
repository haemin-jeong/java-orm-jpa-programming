package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn("order_id")
    private Order order;

    @ManyToOne
    @JoinColumn("item_id")
    private Item item;

    private int orderPrice;
    private int count;

}
