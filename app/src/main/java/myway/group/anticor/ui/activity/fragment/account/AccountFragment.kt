package myway.group.anticor.ui.activity.fragment.account

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.yalantis.ucrop.UCrop
import kotlinx.android.synthetic.main.fragment_account.*
import myway.group.anticor.R
import myway.group.anticor.ui.activity.MainActivity
import myway.group.anticor.ui.activity.api.RetrofitInstanceBearer
import myway.group.anticor.ui.activity.repository.TokenProvider
import myway.group.anticor.ui.activity.util.Constants
import myway.group.anticor.ui.activity.util.MyPreference
import myway.group.anticor.ui.activity.util.hideKeyboard
import myway.group.anticor.ui.activity.util.snackbar
import java.io.File
import java.util.*

private const val IMAGE_PICK = 1001
private const val PERMISSION_REQUEST = 1000
class AccountFragment : Fragment(R.layout.fragment_account) {

    /*private val accountVM by viewModels<AccountViewModel> {
        getViewModelFactory(
            MyRepository(
                DatabaseProvider.invoke(requireContext())
            )
        )
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpChangeLang()

        setUpListeners()
    }
    private fun setUpChangeLang() {
        val myPref = MyPreference(requireContext());
        change_lang.setOnClickListener {
            val array =
                arrayOf(
                    getString(R.string.uzbek_ru),
                    getString(R.string.russian)
                )
            val dialog = AlertDialog.Builder(requireContext()).setCancelable(true).setItems(
                array
            ) { p0, p1 ->
                when (p1) {
                    0 -> {
                        myPref.setLang("oz") {
                            startActivity(Intent(context, MainActivity::class.java))
                            requireActivity().finish()
                        }
                    }
                    1 -> {
                        myPref.setLang("ru") {
                            startActivity(Intent(context, MainActivity::class.java))
                            requireActivity().finish()
                        }
                    }
                }
            }
            dialog.show()

        }
    }

    private fun setUpListeners() {
        btn_logout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setCancelable(true)
                .setMessage(getString(R.string.are_you_sure))
                .setNegativeButton(getString(R.string.no)) { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                .setPositiveButton(getString(R.string.yes)) { dialogInterface, i ->
                    val pref =
                        requireActivity().getSharedPreferences(
                            Constants.PREF_NAME,
                            Context.MODE_PRIVATE
                        )
                    val editor = pref.edit()
                    editor.clear()
                    editor.apply()
                   // accountVM.clearDatabase()
                    TokenProvider.resetToken()
                    RetrofitInstanceBearer.instance = null
                   /* val intent = Intent(
                        requireContext(),
                       // RegisterActivity::class.java
                    )*/
                   // startActivity(intent)
                    requireActivity().finish()
                }.show()
        }
        img_avatar.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    PERMISSION_REQUEST
                )
            } else {
                pickImage()
            }
        }

        btn_edit_profile.setOnClickListener {

        }
        //val sheetBehavior = BottomSheetBehavior.from(bottom_sheet_checkout)

        /*btn_replenish_balance.setOnClickListener {
            if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED)
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            else
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }*/

       /* sheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (sheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED)
                    bottomSheet.hideKeyboard()
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

        })*/

    }

    private fun pickImage() {
        val intent =
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, IMAGE_PICK)
    }
    private fun showProgress() {
        progress.isVisible = true
    }
    private fun hideProgress() {
        progress.isVisible = false
    }

    private fun expandHideRv(
        rv: RecyclerView,
        btn: ImageButton
    ) {
        if (rv.isVisible) {
            rv.isVisible = false
            TransitionManager.beginDelayedTransition(layout_account, AutoTransition())
            btn.setImageResource(R.drawable.ic_expand_more)

        } else {
            rv.isVisible = true
            TransitionManager.beginDelayedTransition(layout_account, AutoTransition())
            btn.setImageResource(R.drawable.ic_hide_expand)

        }
    }



   /* private fun setUpViews(user: User) {
        Glide.with(this).load(BASE_URL + user.image)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.gerb)
            .into(img_avatar)
        tv_username.text = getString(R.string.full_name, user.lastName, user.firstName)
        tv_number.text = user.phoneNumber.toString()
        tv_balance.text = getString(R.string.balance, formatMoney(user.balance))
        tv_number.text = getString(R.string.phone_number, user.phoneNumber)

        val seconds = user.totalWatchTime % 60
        var hour = user.totalWatchTime / 60
        val minutes = hour % 60
        hour /= 60
        tv_watch_time.text = getString(R.string.watch_time, hour, minutes, seconds)
    }
*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                IMAGE_PICK -> {
                    val uri = data?.data
                    uri?.let {
                        val destination = "cropped_img_${Date().time}.jpg"
                        val options = UCrop.Options()
                        options.setCircleDimmedLayer(true)
                        options.setToolbarTitle(getString(R.string.edit))
                        UCrop.of(it, Uri.fromFile(File(requireActivity().cacheDir, destination)))
                            .withOptions(options)
                            .start(requireContext(), this)
                    }
                }
                /*UCrop.REQUEST_CROP -> {
                    val uri = UCrop.getOutput(data!!)
                    val path = FilePath.getPath(requireContext(), uri!!)
                    accountVM.changeImage(File(path.toString()))

                }*/
                UCrop.RESULT_ERROR -> {
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED))
                    pickImage()
                else
                    snackbar(getString(R.string.permission_denied))
                return
            }
            else -> snackbar(getString(R.string.error))
        }
    }
}