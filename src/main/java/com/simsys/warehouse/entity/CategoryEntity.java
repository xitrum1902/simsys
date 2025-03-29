package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @ColumnDefault("nextval('category_categoryid_seq')")
    @Column(name = "categoryid", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid")
    private ProductEntity productid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductEntity getProductid() {
        return productid;
    }

    public void setProductid(ProductEntity productid) {
        this.productid = productid;
    }

}