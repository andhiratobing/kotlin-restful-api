package andhi.ratobing.kotlinrestfulapi.config

import andhi.ratobing.kotlinrestfulapi.entity.ApiKey
import andhi.ratobing.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component


@Component
class ApiKeySeader(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)){
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }
}