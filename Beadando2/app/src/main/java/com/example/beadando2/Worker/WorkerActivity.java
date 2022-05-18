package com.example.beadando2.Worker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.beadando2.R;

public class WorkerActivity extends AppCompatActivity {

    TextView workerText;
    Button workerButton;

    WorkManager mWorkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);

        workerText = findViewById(R.id.workerTextView);
        workerButton = findViewById(R.id.workerButton);

        mWorkManager = WorkManager.getInstance(this);

        Data inputData = new Data.Builder()
                .putString("data","Hello from WorkManager!")
                .build();

        final OneTimeWorkRequest waitRequest =
                new OneTimeWorkRequest.Builder(WaitWorker.class).build();

        Constraints constraints = new Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .build();

        final OneTimeWorkRequest mRequest =
                new OneTimeWorkRequest.Builder(MyWorker.class)
                        .setConstraints(constraints)
                        .setInputData(inputData)
                        .build();

        workerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mWorkManager.enqueue(mRequest);
                WorkContinuation continuation = mWorkManager.beginWith(waitRequest);
                continuation.then(mRequest).enqueue();
            }
        });

        mWorkManager.getWorkInfoByIdLiveData(mRequest.getId()).observe(
                this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if(workInfo != null) {
                            WorkInfo.State state = workInfo.getState();
                            workerText.setText(state.toString() + ", " +
                                    workInfo.getOutputData().getString("result"));
                        }
                    }
                }
        );
    }
}