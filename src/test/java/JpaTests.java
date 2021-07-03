import config.JpaConfig;
import enums.AccountType;
import enums.AuctionType;
import enums.CurrencyUnit;
import model.Address;
import model.Item;
import model.MonetaryAmount;
import model.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class JpaTests {

    @Test
    public void testItemAdd() {
        EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Item item = new Item();
        item.setItemName("item name");
        item.setAuctionType(AuctionType.FIXED_PRICE);
        item.setAuctionStart(LocalDateTime.now().minusDays(5));
        item.setAuctionEnd(LocalDateTime.now().plusDays(5));
        item.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        item.setMetricWeight(10);
        item.setQuantity(120);

        MonetaryAmount monetaryAmount = new MonetaryAmount(CurrencyUnit.TRY, 120.5);
        item.setInitialPrice(monetaryAmount);

        MonetaryAmount forceBuyPrice = new MonetaryAmount(CurrencyUnit.EUR, 10.5);
        item.setForceBuyPrice(forceBuyPrice);

        entityManager.persist(item);
        tx.commit();
        entityManager.close();
        JpaConfig.getEntityManagerFactory().close();
    }

    @Test
    public void testUserAdd() {
        EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        User user = new User();
        user.setUserName("USER--NAME");
        user.setAccountType(AccountType.BRONZE);

        Address address = new Address("sokak", "333", "ANKARA");
        user.setBillingAdress(address);

        entityManager.persist(user);

        tx.commit();
        entityManager.close();
        JpaConfig.getEntityManagerFactory().close();
    }

    @Test
    public void testJpaSetup() {
        EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        tx.commit();
        entityManager.close();
        JpaConfig.getEntityManagerFactory().close();
    }
}
