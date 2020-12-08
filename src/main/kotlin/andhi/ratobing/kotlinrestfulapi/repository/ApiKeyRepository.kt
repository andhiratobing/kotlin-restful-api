package andhi.ratobing.kotlinrestfulapi.repository

import andhi.ratobing.kotlinrestfulapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, String> {
}