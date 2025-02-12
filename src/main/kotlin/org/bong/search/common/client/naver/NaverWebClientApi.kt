package org.bong.search.common.client.naver

import org.bong.search.common.client.BaseWebClientApi
import org.springframework.web.reactive.function.client.WebClient

class NaverWebClientApi(
     private val webClient: WebClient
) : BaseWebClientApi() {

    companion object {
        private const val NAVER_API_HOST = "openapi.naver.com"
        private const val NAVER_CLIENT_ID = "_8o4EDT1hTGUY4iPKU90"
        private const val NAVER_CLIENT_SECRET = "W8zCY43K_R"
        private const val DISPLAY_COUNT = 5
    }

    override fun retrieve(path: String, keyword: String): WebClient.ResponseSpec {
        return webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .scheme("https")
                    .host(NAVER_API_HOST)
                    .path(path)
                    .queryParam("query", keyword)
                    .queryParam("display", DISPLAY_COUNT)
                    .build()
            }
            .header("X-Naver-Client-Id", NAVER_CLIENT_ID)
            .header("X-Naver-Client-Secret", NAVER_CLIENT_SECRET)
            .retrieve()
    }
}
