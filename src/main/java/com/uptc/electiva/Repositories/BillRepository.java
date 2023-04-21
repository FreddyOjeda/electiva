package com.uptc.electiva.Repositories;

import com.uptc.electiva.Entities.BillEntity;
import com.uptc.electiva.Entities.CustomerEntity;
import com.uptc.electiva.Entities.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity,String> {

    //List<BillEntity> findByType_pay(Pay type_pay);
    List<BillEntity> findByCustomer(CustomerEntity customer);
    //List<BillEntity> findByDate_billBetween(LocalDate startDate, LocalDate endDate);



    //@Query("SELECT b FROM Bill b WHERE b.fecha BETWEEN :start AND :end")
    //List<BillEntity> findBillsByDateRange(@Param("start") LocalDate start, @Param("end") LocalDate end);

}
