package andhi.ratobing.kotlinrestfulapi.repository

import andhi.ratobing.kotlinrestfulapi.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, String> {

}