package utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.utils.io.core.use

@Composable
internal fun AsyncImage(
    url: String,
    contentScale: ContentScale,
    contentDescription: String? = "",
    modifier: Modifier = Modifier
) {
    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    var hasError by remember { mutableStateOf(false) }

    image?.let {
        androidx.compose.foundation.Image(
            modifier = modifier,
            bitmap = it,
            contentScale = contentScale,
            contentDescription = contentDescription
        )
    } ?: run {
        if (hasError) {
            Spacer(modifier = Modifier.size(0.dp))
        } else {
            Spacer(modifier = modifier)
        }
    }
    LaunchedEffect(key1 = url, block = {
        try {
            HttpClient().use { client ->
                client.get(urlString = url).let { response ->
                    if (response.status == HttpStatusCode.OK) {
                        image = response.body<ByteArray>().toImageBitmap()
                    } else {
                        hasError = true
                        println("AsyncImage response status failed:" + response.status.value)
                    }
                }
            }
        } catch (e: Exception) {
            hasError = true
            println(e)
        }
    })
}

