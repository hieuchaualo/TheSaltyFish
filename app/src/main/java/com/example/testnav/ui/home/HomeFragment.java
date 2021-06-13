package com.example.testnav.ui.home;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testnav.R;
import com.example.testnav.databinding.FragmentHomeBinding;
import com.example.testnav.ui.caption.CaptionAdapter;
import com.example.testnav.ui.photo.SavePhoto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.UUID;

import dmax.dialog.SpotsDialog;

import static android.content.Context.CLIPBOARD_SERVICE;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    MediaPlayer mediaPlayer;
    Boolean flag1 = true,flag2 = true, flag3 = true;
    ClipData clipData;
    ClipboardManager clipboardManager;
    private Context context;
    private static final int PERMISSION_REQUEST_CODE = 1000;
    private String url;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context  = container.getContext();

        new ViewModelProvider(this).get(HomeViewModel.class);
        clipboardManager =(ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        String link_audio1 = "https://thesaltyfish.000webhostapp.com/Musics/BachNguyetQuangVaNotChuSa-DaiTuDaZi-6911991_hq.mp3";
        String link_audio2 = "https://thesaltyfish.000webhostapp.com/Musics/Ma%20Phap%20Tinh%20Yeu%20-%20Cover.mp3";
        String link_audio3 = "https://thesaltyfish.000webhostapp.com/Musics/ILikeYouSoMuchYoullKnowItEnglishCover-YsabelleCuevas-5825523.mp3";
        String url3 = "https://cdn.tgdd.vn//GameApp/1332049//88-500x500.jpg";
        String url2 = "https://i.ytimg.com/vi/wN3h8VE62-s/maxresdefault.jpg";
        String url1 = "https://i.pinimg.com/736x/ad/59/23/ad5923dc47cda6611cebd8c2b7115827.jpg";
        binding.floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.tvCaption1.getText().toString();
                clipData = ClipData.newPlainText("text",text);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context.getApplicationContext(), "Text copied", Toast.LENGTH_LONG).show();
            }
        });

        binding.floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = binding.tvCaption4.getText().toString();
                clipData = ClipData.newPlainText("text",text1);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context.getApplicationContext(), "Text copied", Toast.LENGTH_LONG).show();
            }
        });

        binding.floatingActionButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text2 = binding.tvCaption7.getText().toString();
                clipData = ClipData.newPlainText("text",text2);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context.getApplicationContext(), "Text copied", Toast.LENGTH_LONG).show();
            }
        });



        binding.floatingActionButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions((Activity)context, new String[]{
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                            },
                            PERMISSION_REQUEST_CODE);
                }
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(binding.floatingActionButton8.getContext(),"You Should grant permission",Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions((Activity)context, new String[]{}, PERMISSION_REQUEST_CODE);
                }else {
                    AlertDialog dialog = new SpotsDialog(context);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString();
                    try{
                        Picasso.with(context).load(url3)
                                .into(new SavePhoto(context,
                                        dialog,
                                        context.getApplicationContext().getContentResolver(),fileName,"Image description"));
                        Toast.makeText(binding.floatingActionButton8.getContext(),"Download Success",Toast.LENGTH_SHORT).show();
                    }catch(Exception e){

                    }

                }
            }
        });

        binding.floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions((Activity)context, new String[]{
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                            },
                            PERMISSION_REQUEST_CODE);
                }
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(binding.floatingActionButton5.getContext(),"You Should grant permission",Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions((Activity)context, new String[]{}, PERMISSION_REQUEST_CODE);
                }else {
                    AlertDialog dialog = new SpotsDialog(context);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString();
                    try{
                        Picasso.with(context).load(url2)
                                .into(new SavePhoto(context,
                                        dialog,
                                        context.getApplicationContext().getContentResolver(),fileName,"Image description"));
                        Toast.makeText(binding.floatingActionButton5.getContext(),"Download Success",Toast.LENGTH_SHORT).show();
                    }catch(Exception e){

                    }

                }
            }
        });

        binding.floatingActionButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions((Activity)context, new String[]{
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                            },
                            PERMISSION_REQUEST_CODE);
                }
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(binding.floatingActionButton10.getContext(),"You Should grant permission",Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions((Activity)context, new String[]{}, PERMISSION_REQUEST_CODE);
                }else {
                    AlertDialog dialog = new SpotsDialog(context);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString();
                    try{
                        Picasso.with(context).load(url1)
                                .into(new SavePhoto(context,
                                        dialog,
                                        context.getApplicationContext().getContentResolver(),fileName,"Image description"));
                        Toast.makeText(binding.floatingActionButton10.getContext(),"Download Success",Toast.LENGTH_SHORT).show();
                    }catch(Exception e){

                    }

                }
            }
        });
        binding.floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                playAudio(link_audio1,binding.floatingActionButton3,flag1);
                if(flag1){
                    mediaPlayer = new MediaPlayer();

                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    try {
                        mediaPlayer.setDataSource(link_audio1);

                        mediaPlayer.prepare();
                        Toast.makeText(binding.floatingActionButton3.getContext(), "Connect Internet Success",Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(binding.floatingActionButton3.getContext(), "No Internet",Toast.LENGTH_SHORT).show();
                    }
                    flag1 = false;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }

            }

        });
        binding.floatingActionButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                playAudio(link_audio2,binding.floatingActionButton6,flag2);
                if(flag2){
                    mediaPlayer = new MediaPlayer();

                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    try {
                        mediaPlayer.setDataSource(link_audio2);

                        mediaPlayer.prepare();
                        Toast.makeText(binding.floatingActionButton6.getContext(), "Connect Internet Success",Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(binding.floatingActionButton6.getContext(), "No Internet",Toast.LENGTH_SHORT).show();
                    }
                    flag2 = false;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }
            }

        });
        binding.floatingActionButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                playAudio(link_audio3,binding.floatingActionButton9,flag3);
                if(flag3){
                    mediaPlayer = new MediaPlayer();

                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    try {
                        mediaPlayer.setDataSource(link_audio3);

                        mediaPlayer.prepare();
                        Toast.makeText(binding.floatingActionButton9.getContext(), "Connect Internet Success",Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(binding.floatingActionButton9.getContext(), "No Internet",Toast.LENGTH_SHORT).show();
                    }
                    flag3 = false;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }

            }
        });


        return root;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}
