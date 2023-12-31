package com.etiya.training.services.concretes;

import com.etiya.training.core.utils.exceptions.types.BusinessException;
import com.etiya.training.entities.Category;
import com.etiya.training.entities.Product;
import com.etiya.training.repositories.ProductRepository;
import com.etiya.training.services.abstracts.CategoryService;
import com.etiya.training.services.abstracts.ProductService;
import com.etiya.training.services.dtos.product.AddProductRequest;
import com.etiya.training.services.dtos.product.GetListProductResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// interface-interface => extends
// class-class => extends
// class-interface => implements
@Service
@AllArgsConstructor
public class ProductManager implements ProductService
{
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    private final ModelMapper modelMapper;
    //private final CategoryRepository categoryRepository; // yanlış kullanım

    // 15:00

    @Override
    public Product add(AddProductRequest request) {
        // ekleme işi için iş akışı
        // dTo => Transfer => Mapping
        // request.categoryId 6
        // 6 ?
        // ** => Business rulelar method içerisine direkt yazılmamalı ayrı methodlar halinde kodlanmalıdır..
        Category category = throwExceptionIfCategoryNotExists(request.getCategoryId());


        // Manual Mapping
        // AddProductRequest - Product
        Product mappedProduct = modelMapper.map(request,Product.class);
        //     (source) AddProductRequest -> Product (destination)
        Product newProduct = new Product();
        newProduct.setProductName(request.getProductName());
        newProduct.setQuantityPerUnit(request.getQuantityPerUnit());
        newProduct.setDiscontinued(request.getActive());
        newProduct.setCategory(category);

        return this.productRepository.save(newProduct);
    }

    @Override
    public void delete(Short id)
    {
        Product productToDelete = productRepository.findById(id).orElseThrow( () -> new RuntimeException("Bu id ile bir ürün bulunamadı.") );
        // kod bu satırda kesilecek

        productRepository.delete(productToDelete);
    }

    @Override
    public Product update() {
        throwExceptionIfCategoryNotExists((short)6);

        return null;
    }

    @Override
    public List<GetListProductResponse> getAll() {
        // Manual Mapping
        /* List<Product> products = productRepository.findAllCustom();

        List<GetListProductResponse> response=new ArrayList<>();

        // TODO: Refactor
        for (Product product: products) {
            GetListProductResponse dto = new GetListProductResponse(product.getProductId(), product.getProductName());
            response.add(dto);
        }
        */

        // SQL olarak işlem daha mı kolay? Daha mı zor?

        // Lambda Expression & Stream API
        List<Product> products = productRepository.findAll();

        // Bir Iterable (koleksiyon) alanın stream türüne çevrilerek üzerinde stream API işlevlerinin gerçekleştirilmesi.
        // Java 8
        products.stream().forEach((product) -> {

        });


        List<GetListProductResponse> dtos = products
                .stream()
                .filter((product) -> product.getDiscontinued() == 0 && product.getProductId() > 5)
                .map((product) -> {
                     return new GetListProductResponse(product.getProductId(), product.getProductName());
                 })
                .sorted(Comparator.comparing(GetListProductResponse::getProductName).reversed())
                .toList();

        // GetListProductResponse::getProductId => GetListProductResponse class içerisindeki getProductId REFERANSI!
        //dtos = dtos.stream().sorted(Comparator.comparing(GetListProductResponse::getProductName).reversed()).toList();

        return dtos;
    }

    @Override
    public List<GetListProductResponse> search(String name) {
        return productRepository.getByName(name.toLowerCase());
    }

    @Override
    public Optional<Product> getById(Short id) {
        return productRepository.findById(id);
    }


    private Category throwExceptionIfCategoryNotExists(Short id){
        return categoryService
                .getById(id)
                .orElseThrow( () -> new BusinessException("Verilen id ile bir kategori bulunamadı.") );
    }
}
