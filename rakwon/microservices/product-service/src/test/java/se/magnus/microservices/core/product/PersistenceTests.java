package se.magnus.microservices.core.product;

import com.mongodb.DuplicateKeyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.magnus.microservices.core.product.persistence.ProductEntity;
import se.magnus.microservices.core.product.persistence.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class PersistenceTests {

    @Autowired
    private ProductRepository productRepository;
    private ProductEntity savedEntity;


    @BeforeEach
    public void setupDB(){
        productRepository.deleteAll();
        ProductEntity entity = ProductEntity.builder()
                .productId(1)
                .name("n")
                .weight(1)
                .build();

        savedEntity = productRepository.save(entity);
        assertEqualsProduct(entity, savedEntity);

    }

    @Test
    public void 엔티티_생성_태스트(){
        ProductEntity newEntity = ProductEntity.builder()
                .productId(2)
                .name("n")
                .weight(2)
                .build();
        savedEntity = productRepository.save(newEntity);

        ProductEntity foundEntity = productRepository.findById(newEntity.getId()).get();
        assertEqualsProduct(newEntity, foundEntity);
        assertEquals(2, productRepository.count());
    }

    @Test
    public void 엔티티_업데이트_테스트(){
        savedEntity.setName("n2");
        productRepository.save(savedEntity);

        ProductEntity foundEntity = productRepository.findById(savedEntity.getId()).get();
        assertEquals(1, (long)foundEntity.getVersion());
        assertEquals("n2", foundEntity.getName());
    }

    @Test
    public void 엔티티_삭제_테스트(){
        productRepository.delete(savedEntity);
        assertFalse(productRepository.existsById(savedEntity.getId()));
    }

    @Test
    public void 키중복_에러_테스트(){
        assertThrows(DuplicateKeyException.class, () -> {

            ProductEntity foundEntity = productRepository.findByProductId(savedEntity.getProductId()).get();
            ProductEntity entity = ProductEntity.builder()
                    .productId(savedEntity.getProductId())
                    .name("n")
                    .weight(1)
                    .build();

            productRepository.save(entity);

        });
    }
    private void assertEqualsProduct(ProductEntity expectedEntity, ProductEntity actualEntity) {
        assertEquals(expectedEntity.getId(),               actualEntity.getId());
        assertEquals(expectedEntity.getVersion(),          actualEntity.getVersion());
        assertEquals(expectedEntity.getProductId(),        actualEntity.getProductId());
        assertEquals(expectedEntity.getName(),           actualEntity.getName());
        assertEquals(expectedEntity.getWeight(),           actualEntity.getWeight());
    }
}
