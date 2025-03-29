package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "transferrequest")
public class TransferRequestEntity {
    @Id
    @ColumnDefault("nextval('transferrequest_transferid_seq')")
    @Column(name = "transferid", nullable = false)
    private Integer id;

    @Column(name = "note", length = Integer.MAX_VALUE)
    private String note;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "transferdate")
    private LocalDate transferdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toinventoryid")
    private InventoryEntity toinventoryid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(LocalDate transferdate) {
        this.transferdate = transferdate;
    }

    public InventoryEntity getToinventoryid() {
        return toinventoryid;
    }

    public void setToinventoryid(InventoryEntity toinventoryid) {
        this.toinventoryid = toinventoryid;
    }

}