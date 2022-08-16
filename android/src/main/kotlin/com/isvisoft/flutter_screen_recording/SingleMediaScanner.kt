package com.isvisoft.flutter_screen_recording

import android.content.Context
import android.media.MediaScannerConnection
import android.net.Uri
import java.io.File


class SingleMediaScanner(context: Context?, f: File?) : MediaScannerConnection.MediaScannerConnectionClient {
    private var mMs: MediaScannerConnection? = null
    private var mFile: File? = f

    init {
        mMs = MediaScannerConnection(context, this)
        mMs!!.connect()
    }

    override fun onMediaScannerConnected() {
        mMs!!.scanFile(mFile!!.absolutePath, null)
        println("onMediaScannerConnected success")
    }

    override fun onScanCompleted(path: String?, uri: Uri?) {
        mMs!!.disconnect()
    }
}