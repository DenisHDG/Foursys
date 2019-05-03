package goncalves.denis.codechalleng.GithubRepositories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/search/repositories?q=language:swift&sort=stars")
    Call<Customer> getAll();
}