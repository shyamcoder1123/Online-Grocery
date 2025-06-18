package com.shyam.OnlineGrocery.repositoryservices;

import com.shyam.OnlineGrocery.dto.Customer;
import com.shyam.OnlineGrocery.dto.Grocery;
import com.shyam.OnlineGrocery.models.CustomerEntity;
import com.shyam.OnlineGrocery.models.GroceryEntity;
import com.shyam.OnlineGrocery.repositories.CustomerRepository;
import com.shyam.OnlineGrocery.repositories.GroceryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryRepositoryServiceImpl implements GroceryRepositoryService{

    private final ModelMapper modelMapper;


    private final GroceryRepository groceryRepository;
    public GroceryRepositoryServiceImpl(ModelMapper modelMapper,
                                        GroceryRepository groceryRepository) {
        this.modelMapper = modelMapper;
        this.groceryRepository = groceryRepository;
    }

    @Override
    public List<Grocery> findAllGroceries() {
        return groceryRepository.findAll().stream()
                .map(groceryEntity -> modelMapper.map(groceryEntity, Grocery.class))
                .toList();
    }

    @Override
    public Grocery findGroceryById(Integer groceryId) {
        return groceryRepository.findById(groceryId)
                .map(entity -> modelMapper.map(entity, Grocery.class))
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Customer %d not found".formatted(groceryId)));
    }

    @Override
    public Grocery updateGroceryById(Integer groceryId, Grocery grocery) {
        GroceryEntity existingEntity = groceryRepository.findById(groceryId)
                .orElseThrow(() -> new EntityNotFoundException("Customer %d not found".formatted(groceryId)));

        modelMapper.map(grocery, existingEntity);

        GroceryEntity updated = groceryRepository.save(existingEntity);

        return modelMapper.map(updated, Grocery.class);
    }

    @Override
    public boolean deleteGroceryById(Integer groceryId) {
        groceryRepository.deleteById(groceryId);
        return true;
    }

    @Override
    public Grocery createGrocery(Grocery grocery) {
        GroceryEntity entity = modelMapper.map(grocery, GroceryEntity.class);

        GroceryEntity saved = groceryRepository.save(entity);

        return modelMapper.map(saved, Grocery.class);
    }
}
