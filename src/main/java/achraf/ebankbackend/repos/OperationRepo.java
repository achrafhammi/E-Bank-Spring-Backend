package achraf.ebankbackend.repos;

import achraf.ebankbackend.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface OperationRepo extends JpaRepository<Operation, Long> {
    List<Operation> findByBankAccountId(String accountId);
    Page<Operation> findByBankAccountId(String accountId, Pageable pageable);

}
