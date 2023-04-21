package com.uptc.electiva.Services;


import com.uptc.electiva.Entities.BillEntity;
import com.uptc.electiva.Entities.CustomerEntity;
import com.uptc.electiva.Repositories.BillRepository;
import com.uptc.electiva.Repositories.CustomerReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    BillRepository reposity;

    @Autowired
    CustomerReposity customerReposity;


    public BillEntity save(BillEntity bill,int id){
        if (reposity.findById(bill.getNumber()).isPresent()){
            return null;
        }else {
            if (customerReposity.findById(id).isPresent()){
                bill.setCustomer(customerReposity.findById(id).get());
                return reposity.save(bill);
            }else{
                return null;
            }

        }
    }

    public List<BillEntity> findByCustomer(int id){
        Optional<CustomerEntity> optional = customerReposity.findById(id);
        if (optional.isPresent()){
            return reposity.findByCustomer(optional.get());
        }else{
            return null;
        }
    }

    public List<BillEntity> findByPay(String id){
        /*Optional<CustomerEntity> optional = customerReposity.findById(id);
        if (optional.isPresent()){
            return reposity.findByCustomer(optional.get());
        }else{
            return null;
        }*/
        return reposity.findByTypePay(id);
    }

    public List<BillEntity> findByDate(LocalDate start,LocalDate end){
        /*Optional<CustomerEntity> optional = customerReposity.findById(id);
        if (optional.isPresent()){
            return reposity.findByCustomer(optional.get());
        }else{
            return null;
        }*/
        return reposity.findByDateBetween(start,end);
    }

    public List<BillEntity> findAll(){
        return  reposity.findAll();
    }

    public  BillEntity findById(String id){
        Optional<BillEntity> optional = reposity.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }

    public  BillEntity update(String id, BillEntity newBill){
        BillEntity bill = reposity.findById(id).get();

        if (bill!=null){
            bill.setDate(newBill.getDate());
            //bill.setCustomer(newBill.getCustomer());
            bill.setTotal(newBill.getTotal());
            bill.setTypePay(newBill.getTypePay());
            return reposity.save(bill);
        }else{
            return null;
        }
    }

    public boolean delete(String id){
        Optional<BillEntity> optional = reposity.findById(id);

        if (optional.isPresent()){
            reposity.delete(optional.get());
            return true;
        }else{
            return false;
        }
    }

}
