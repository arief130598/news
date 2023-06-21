package com.aplus.news.repository

import com.aplus.news.domain.model.News
import com.aplus.news.domain.repository.NewsApiRepository
import com.aplus.news.utils.ResponseResult
import com.aplus.news.utils.validateResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class NewsApiRepositoryFake : NewsApiRepository {
    var news: Response<List<News>> = Response.success(
        listOf(
            News(
                id = 1,
                createdAt = "2021-05-23T06:21:16.683Z",
                contributorName = "Juanita Marks PhD",
                title = "maiores cupiditate recusandae",
                content = "nim vel praesentium. Et excepturi eius tenetur rerum non. Voluptatibus error " +
                        "voluptate sit consequatur commodi id mollitia. Necessitatibus magnam repellendus " +
                        "omnis. Reprehenderit nesciunt ex a libero explicabo. Omnis omnis inventore est " +
                        "cumque qui facilis aperiam dolor sunt.\\n \\rVelit voluptatem nihil consequuntur " +
                        "rerum ut harum nisi consectetur architecto. Ullam sequi et quo qui. Sunt eum " +
                        "aut quam sapiente ullam rerum saepe. Delectus corporis vero deleniti eum. Qui " +
                        "itaque facilis eveniet enim blanditiis. Aut aliquid consequuntur velit.\\n \\rEx " +
                        "doloribus qui delectus necessitatibus ratione molestiae facere in officiis. " +
                        "Consectetur reiciendis quibusdam assumenda sint eos nemo. Tempore doloremque " +
                        "itaque dolor natus enim dolorem. Ullam ut aut consequatur et assumenda natus " +
                        "est. Voluptatem explicabo aut non voluptates repudiandae.",
                contentThumbnail = "http://placeimg.com/640/480/nature",
                slideshow = listOf()
            ),
            News(
                id = 2,
                createdAt = "2021-05-24T00:14:44.689Z",
                contributorName = "Irma Grant",
                title = "dolor aut aut",
                content = "Earum voluptas magnam doloribus. Harum consequatur accusamus animi. " +
                        "Eum distinctio ut quia tempore. Natus velit velit eum sit adipisci autem " +
                        "vero ea doloremque. Ut et repudiandae. Eos tenetur reprehenderit id excepturi." +
                        "\\n \\rDolorum quam rem corrupti suscipit praesentium labore praesentium eos" +
                        " porro. Non sit sit vel voluptatem aut natus voluptatem et. Nobis impedit " +
                        "tenetur consequatur. Et laborum laborum vero hic. Provident aut sed eligendi" +
                        " porro repudiandae quas et dignissimos est. Fuga esse velit ad id deserunt.\\n " +
                        "\\rDolor modi ullam qui in debitis quae non. Aspernatur odit et harum. Asperiores " +
                        "nihil officiis ut in. Sint magni sunt et provident consequatur consequatur.",
                contentThumbnail = "http://placeimg.com/640/480/abstract",
                slideshow = listOf(
                    "http://placeimg.com/640/480/nature",
                    "http://placeimg.com/640/480/fashion",
                    "http://placeimg.com/640/480/transport"
                )
            )
        )
    )

    override suspend fun getNews(): Flow<ResponseResult<List<News>>> {
        return flow {
            emit(news.validateResponse())
        }
    }
}