package utils

import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.AVPlayerTimeControlStatusPlaying
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.AVFoundation.timeControlStatus
import platform.Foundation.NSURL

actual class AudioPlayer {

    private companion object {
        val player: AVPlayer = AVPlayer()
    }

    actual fun play(url: String) {
        try {
            if (player.timeControlStatus == AVPlayerTimeControlStatusPlaying) {
                player.pause()
            }
            val playerUrl = NSURL.URLWithString(URLString = url)!!

            with(player) {
                replaceCurrentItemWithPlayerItem(AVPlayerItem(uRL = playerUrl))
                play()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}