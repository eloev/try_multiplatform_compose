package utils

import android.graphics.BitmapFactory
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.yelloyew.common.KmmApp

actual fun ByteArray.toImageBitmap(): ImageBitmap {
    return BitmapFactory.decodeByteArray(this, 0, this.size).asImageBitmap()
}

actual fun vibrate() {
    val vibrator = KmmApp.appContext.getSystemService(Vibrator::class.java)
    if (vibrator.hasVibrator()) {
        vibrator.vibrate(
            VibrationEffect.createOneShot(
                100,
                VibrationEffect.DEFAULT_AMPLITUDE
            )
        )
    }
}