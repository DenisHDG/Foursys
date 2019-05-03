package goncalves.denis.codechalleng.GithubRepositories;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Owner {

    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("login")
    private String loginName;

    public Owner() {

    }

    public Owner(
            final String avatarUrl,
            final String loginName) {
        this.avatarUrl = avatarUrl;
        this.loginName = loginName;

    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(final String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(final String loginName) {
        this.loginName = loginName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return avatarUrl.equals(owner.avatarUrl) &&
                loginName.equals(owner.loginName);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(avatarUrl, loginName);
    }
}
