package com.example.ellina.project;

import com.example.ellina.project.entity.CategoryEntity;
import com.example.ellina.project.entity.ProductEntity;
import com.example.ellina.project.repository.CategoryRepo;
import com.example.ellina.project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ServerApplicationInit implements CommandLineRunner {
    @Autowired
    protected CategoryRepo categoryRepo;
    @Autowired
    protected ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        List<ProductEntity> productEntities = new ArrayList<>();
        CategoryEntity category1 = new CategoryEntity(1L, "Fruit", productEntities);
        CategoryEntity category2 = new CategoryEntity(2L, "Vegetable", productEntities);
        CategoryEntity category3 = new CategoryEntity(3L, "Drink", productEntities);
        CategoryEntity category4 = new CategoryEntity(4L, "Food", productEntities);
        categoryRepo.saveAll(List.of(category1, category2, category3, category4));

        ProductEntity product1 = new ProductEntity(1L, "Milk", "Milk is essentially an emulsion" +
                "of fat and protein in water, along with dissolved sugar (carbohydrate), minerals, and vitamins", category3);
        ProductEntity product2 = new ProductEntity(2L, "Water", "water, a substance composed of the chemical elements hydrogen and oxygen and existing in gaseous, liquid, and solid states", category3);
        ProductEntity product3 = new ProductEntity(3L, "Tea", "Tea is an aromatic beverage prepared by pouring hot or boiling water over cured or fresh leaves of Camellia sinensis", category3);
        ProductEntity product4 = new ProductEntity(4L, "Meat", "meat, the flesh or other edible parts of animals (usually domesticated cattle, swine, and sheep) used for food, including not only the muscles and fat but also the tendons and ligaments.", category4);
        ProductEntity product5 = new ProductEntity(5L, "Carrot", "carrot, (Daucus carota), herbaceous, generally biennial plant of the Apiaceae family that produces an edible taproot", category2);
        ProductEntity product6 = new ProductEntity(6L, "Tomatoes", "They are usually red, scarlet, or yellow, though green and purple varieties do exist, and they vary in shape from almost spherical to oval and elongate to pear-shaped", category2);
        ProductEntity product7 = new ProductEntity(7L, "Cucumber", "The cucumber plant is a tender annual with a rough, succulent, trailing stem", category2);
        ProductEntity product8 = new ProductEntity(8L, "Onion", "An onion is a round vegetable with brown skin that grows underground", category2);
        ProductEntity product9 = new ProductEntity(9L, "Banana", "banana Add to list Share. A banana is a curved, yellow fruit with thick skin and soft sweet flesh", category1);
        ProductEntity product10 = new ProductEntity(10L, "Apple", "apple, (Malus domestica), fruit of the domesticated tree Malus domestica (family Rosaceae), one of the most widely cultivated tree fruits", category1);
        productRepo.saveAll(List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10));

    }
}

