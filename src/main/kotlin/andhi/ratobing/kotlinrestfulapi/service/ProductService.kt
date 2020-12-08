package andhi.ratobing.kotlinrestfulapi.service

import andhi.ratobing.kotlinrestfulapi.model.CreateProductRequest
import andhi.ratobing.kotlinrestfulapi.model.ProductResponse

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id:String) : ProductResponse
}