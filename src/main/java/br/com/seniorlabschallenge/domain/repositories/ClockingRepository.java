package br.com.seniorlabschallenge.domain.repositories;

import br.com.seniorlabschallenge.domain.entities.Clocking;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockingRepository extends JpaRepository<Clocking,Long>, JpaSpecificationExecutor<Clocking> {
    static Specification<Clocking> byEmployeerId(Long employeerId){
        return (clocking,cq,cb)->cb.equal(clocking.get("employeeId"),employeerId);
    }
}
