package com.aplus.news.presentation.adapter

import android.content.Context
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class NewsAdapterTest {

    private lateinit var adapter : NewsAdapter

    @Before
    fun setup(){
        val context: Context = mock()
        adapter = NewsAdapter(context, listOf()) {}
    }

    @Test
    fun `test limitOverview() with empty value is return empty`(){
        val data = ""
        val result = adapter.limitContent(data)
        Assert.assertEquals(data, result)
    }

    @Test
    fun `test limitOverview() with string less than 200 chars is return value`(){
        val data = "Enim vel praesentium. Et excepturi eius tenetur rerum non. " +
                "Voluptatibus error voluptate sit consequatur commodi id mollitia. " +
                "Necessitatibus magnam repellendus omnis. Reprehenderit nesciunt ex a libero"
        val result = adapter.limitContent(data)
        Assert.assertEquals(data, result)
    }

    @Test
    fun `test limitOverview() with string more than 200 chars is return 203 chars value`(){
        val data = "Enim vel praesentium. Et excepturi eius tenetur rerum non. Voluptatibus error" +
                " voluptate sit consequatur commodi id mollitia. Necessitatibus magnam repellendus" +
                " omnis. Reprehenderit nesciunt ex a libero explicabo. Omnis omnis inventore est" +
                " cumque qui facilis aperiam dolor sunt.\\n \\rVelit voluptatem nihil consequuntur" +
                " rerum ut harum nisi consectetur architecto. Ullam sequi et quo qui. Sunt eum aut" +
                " quam sapiente ullam rerum saepe. Delectus corporis vero deleniti eum. Qui itaque" +
                " facilis eveniet enim blanditiis. Aut aliquid consequuntur velit.\\n \\rEx doloribus" +
                " qui delectus necessitatibus ratione molestiae facere in officiis. Consectetur" +
                " reiciendis quibusdam assumenda sint eos nemo. Tempore doloremque itaque dolor" +
                " natus enim dolorem. Ullam ut aut consequatur et assumenda natus est. Voluptatem" +
                " explicabo aut non voluptates repudiandae."
        val result = adapter.limitContent(data)
        Assert.assertEquals(203, result.length)
    }
}