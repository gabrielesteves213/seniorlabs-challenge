package br.com.seniorlabschallenge.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public",name = "tb_clocking")
public class Clocking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "included_at")
    private Timestamp includedAt;

    @Column(name = "employer_id")
    private Long employerId;

    @Column(name = "employee_id")
    private Long employeeId;

}
