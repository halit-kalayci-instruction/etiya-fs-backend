package com.etiya.training.core.configuration;

import com.etiya.training.entities.Product;
import com.etiya.training.services.dtos.product.AddProductRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfiguration
{
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD).setAmbiguityIgnored(true);

        // Custom mapping tiplemeleri..

        mapper.typeMap(AddProductRequest.class, Product.class).addMappings(m -> {
           m.map(AddProductRequest::getActive, Product::setDiscontinued);
           m.map(AddProductRequest::getQuantityPerUnit, Product::setQuantityPerUnit);
        });

        return mapper;
    }

}
