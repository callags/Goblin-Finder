package com.example.goblinfinder

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val MY_PERMISSIONS_REQUEST_CAPTURE_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun captureImage(view: View)
    {

        checkPermissions()

    }

    private fun checkPermissions() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA),
                    MY_PERMISSIONS_REQUEST_CAPTURE_IMAGE)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted

            openCamera()
        }
    }

    private fun openCamera() {
        val takeImage = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(takeImage.resolveActivity(packageManager) != null)
        {
            startActivityForResult(takeImage,MY_PERMISSIONS_REQUEST_CAPTURE_IMAGE)
        }
    }

    private fun displayGoblins (){
        val random = (1..100).random()

        if (random in 1..10){
            val bakemonoPage = Intent(this, bakemono::class.java)
            startActivity(bakemonoPage)
        }
        else if (random in 11..20){
            val batiriPage = Intent(this, batiri::class.java)
            startActivity(batiriPage)
        }
        else if (random in 21..30){
            val dekanterPage = Intent(this, dekanter::class.java)
            startActivity(dekanterPage)
        }
        else if (random in 31..40) {
            val nilbogPage = Intent (this, nilbog::class.java)
            startActivity(nilbogPage)
        }
        else if (random in 41..50) {
            val hobgoblinPage = Intent (this, hobgoblin::class.java)
            startActivity(hobgoblinPage)
        }
        else if (random in 51..60) {
            val bugbearPage = Intent (this, bugbear::class.java)
            startActivity(bugbearPage)
        }
        else if (random in 61..70) {
            val koalinthPage = Intent (this, koalinth::class.java)
            startActivity(koalinthPage)
        }
        else if (random in 71..80) {
            val verdanPage = Intent (this, verdan::class.java)
            startActivity(verdanPage)
        }
        else if (random in 81..90) {
            val worghestPage = Intent (this, worghest::class.java)
            startActivity(worghestPage)
        }
        else if (random in 91..100) {
            val forestkithPage = Intent (this, forestkith::class.java)
            startActivity(forestkithPage)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CAPTURE_IMAGE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            iv_cam.setImageBitmap(imageBitmap)

            Toast.makeText(this,"Your image was taken!",Toast.LENGTH_LONG).show()
            displayGoblins()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_CAPTURE_IMAGE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                   openCamera()

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }
}
