package andhi.ratobing.kotlinrestfulapi.service.impl

import andhi.ratobing.kotlinrestfulapi.entity.Product
import andhi.ratobing.kotlinrestfulapi.error.NotFoundException
import andhi.ratobing.kotlinrestfulapi.model.CreateProductRequest
import andhi.ratobing.kotlinrestfulapi.model.ListProductRequest
import andhi.ratobing.kotlinrestfulapi.model.ProductResponse
import andhi.ratobing.kotlinrestfulapi.model.UpdateProductRequest
import andhi.ratobing.kotlinrestfulapi.repository.ProductRepository
import andhi.ratobing.kotlinrestfulapi.service.ProductService
import andhi.ratobing.kotlinrestfulapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil : ValidationUtil
): ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
        id = createProductRequest.id!!,
        name = createProductRequest.name!!,
        price = createProductRequest.price!!,
        quantity = createProductRequest.quantity!!,
        createdAt = Date(),
        updatedAt = null
        )

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }




    override fun get(id: String): ProductResponse {
            val product = findProductByIdOrThrowNotFound(id)
                return convertProductToProductResponse(product)

    }




    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)
        validationUtil.validate(updateProductRequest)

            product.apply {
                name = updateProductRequest.name!!
                price = updateProductRequest.price!!
                quantity = updateProductRequest.quantity!!
                updatedAt = Date()
            }
            productRepository.save(product)
            return convertProductToProductResponse(product)

    }



    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products = page.get().collect(Collectors.toList())

        return products.map {
            convertProductToProductResponse(it)
        }
    }



    private fun findProductByIdOrThrowNotFound(id: String): Product{
        val product = productRepository.findByIdOrNull(id)

        if (product == null) {
            throw NotFoundException()
        }else{
            return product
        }
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse{
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }


}