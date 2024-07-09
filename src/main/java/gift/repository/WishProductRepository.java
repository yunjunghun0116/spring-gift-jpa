package gift.repository;

import gift.model.Member;
import gift.model.Product;
import gift.model.WishProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishProductRepository extends JpaRepository<WishProduct,Long> {
    WishProduct save(WishProduct wishProduct);

    boolean existsByProductAndMember(Product product, Member member);

    Optional<WishProduct> findById(Long id);

    WishProduct findByProductAndMember(Product product, Member member);

    List<WishProduct> findAllByMemberId(Long memberId);

    void deleteById(Long id);
}
