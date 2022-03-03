package com.example.ellina.project.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @Column(name = "product_entities")
    private List<ProductEntity> productEntities;

    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String categoryName, List<ProductEntity> productEntities) {
        this.id = id;
        this.categoryName = categoryName;
        this.productEntities = productEntities;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }
}
