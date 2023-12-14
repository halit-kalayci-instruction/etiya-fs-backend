package com.etiya.training.services.concretes;

import com.etiya.training.entities.Category;
import com.etiya.training.entities.Product;
import com.etiya.training.repositories.ProductRepository;
import com.etiya.training.services.abstracts.ProductService;
import com.etiya.training.services.dtos.product.AddProductRequest;
import com.etiya.training.services.dtos.product.GetListProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// interface-interface => extends
// class-class => extends
// class-interface => implements
@Service
public class ProductManager implements ProductService
{
    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(AddProductRequest request) {
        // ekleme işi için iş akışı
        // dTo => Transfer => Mapping

        // Manual Mapping
        Product newProduct = new Product();
        newProduct.setProductName(request.getProductName());
        newProduct.setQuantityPerUnit(request.getQuantityPerUnit());
        newProduct.setDiscontinued(request.getDiscontinued());

        // TODO: Kategori veritabanından kullanıcının verdiği id ile bi kayıt varsa onu kullan yoksa hata ver.
        Category category = new Category();
        category.setCategoryId(request.getCategoryId());

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
}
