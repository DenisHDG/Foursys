package goncalves.denis.codechalleng;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import goncalves.denis.codechalleng.GithubRepositories.CustomerAdapter;
import goncalves.denis.codechalleng.GithubRepositories.GetDataService;
import goncalves.denis.codechalleng.GithubRepositories.Customer;
import goncalves.denis.codechalleng.api.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Carregando....");
        progressDoalog.show();

        final GetDataService service = RetrofitClientInstance
                .getRetrofitInstance()
                .create(GetDataService.class);

        final Call<Customer> call = service.getAll();

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(
                    @NonNull final Call<Customer> call,
                    @NonNull final Response<Customer> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(
                    @NonNull final Call<Customer> call,
                    @NonNull final Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(
                        MainActivity.this,
                        R.string.problem_internet,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void generateDataList(final Customer customer) {
        final RecyclerView recyclerView = findViewById(R.id.customRecyclerView);
        final CustomerAdapter adapter = new CustomerAdapter(this, customer);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}