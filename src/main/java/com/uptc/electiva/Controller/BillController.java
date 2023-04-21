package com.uptc.electiva.Controller;


import com.uptc.electiva.Entities.BillEntity;
import com.uptc.electiva.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("")
    public ResponseEntity getAllBills() {
        List<BillEntity> bills = billService.findAll();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillEntity> getBillById(@PathVariable String id) {
        BillEntity bill = billService.findById(id);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<BillEntity> createBill(@RequestBody BillEntity billDto,@PathVariable int id) {
        BillEntity createdBill = billService.save(billDto,id);
        return new ResponseEntity<>(createdBill, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillEntity> updateBill(@PathVariable String id, @RequestBody BillEntity billDto) {
        BillEntity updatedBill = billService.update(id,billDto);
        return new ResponseEntity<>(updatedBill, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable String id) {
        if (billService.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

