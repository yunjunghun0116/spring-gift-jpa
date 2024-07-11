package gift.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "wish_product")
public class WishProduct extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;
    @NotNull
    @Column(name = "count")
    private Integer count;

    public WishProduct() {
    }

    public WishProduct(Integer count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Member getMember() {
        return member;
    }

    public Integer getCount() {
        return count;
    }

    public void updateCount(Integer count) {
        this.count = count;
    }

    public void addProduct(Product product) {
        this.product = product;
    }

    public void addMember(Member member) {
        member.getWishes().add(this);
        this.member = member;
    }

    public void removeWishProduct() {
        this.product = null;
        this.member = null;
    }
}
