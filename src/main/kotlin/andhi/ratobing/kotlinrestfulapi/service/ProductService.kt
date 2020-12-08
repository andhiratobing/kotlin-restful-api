package andhi.ratobing.kotlinrestfulapi.service

import andhi.ratobing.kotlinrestfulapi.model.CreateProductRequest
import andhi.ratobing.kotlinrestfulapi.model.ListProductRequest
import andhi.ratobing.kotlinrestfulapi.model.ProductResponse
import andhi.ratobing.kotlinrestfulapi.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id:String) : ProductResponse

    fun update(id: String, updateProductRequest : UpdateProductRequest) : ProductResponse

    fun delete(id: String)

    fun list(listProductRequest : ListProductRequest) : List<ProductResponse>
}