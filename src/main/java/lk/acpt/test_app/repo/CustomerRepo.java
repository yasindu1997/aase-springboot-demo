package lk.acpt.test_app.repo;

import lk.acpt.test_app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
