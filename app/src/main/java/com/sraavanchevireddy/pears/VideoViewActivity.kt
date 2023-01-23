package com.sraavanchevireddy.pears

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video
import android.widget.MediaController
import android.widget.VideoView

class VideoViewActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        videoView = findViewById(R.id.player)
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/"+ "ArtAndDove.mp4"))
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()
    }
}