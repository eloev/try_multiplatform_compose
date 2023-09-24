package utils

import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.yelloyew.common.KmmApp

actual class AudioPlayer {

    private companion object {
        val player = ExoPlayer.Builder(KmmApp.appContext).build()
    }

    actual fun play(url: String) {
        with(player) {
            if (isPlaying) {
                stop()
            }
            setMediaItem(MediaItem.fromUri(url))
            prepare()
            playWhenReady = true
        }
    }

}