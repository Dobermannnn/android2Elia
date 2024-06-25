package com.example.android2Elia.api;

import com.example.android2Elia.user.User;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("results")
    private User[] results;

    public User[] getResults() {
        return results;
    }

    public void setResults(User[] results) {
        this.results = results;
    }
}
