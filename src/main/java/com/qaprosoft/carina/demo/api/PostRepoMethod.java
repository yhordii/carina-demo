package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

public class PostRepoMethod extends AbstractApiMethodV2 {
    public PostRepoMethod() {
        super("apiGit/repos/oneRepo/creation/rq.json", "apiGit/repos/oneRepo/creation/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.header("Authorization", "Bearer " + R.CONFIG.get("git_token"));
    }
    public PostRepoMethod(String name, String description) {
        super("apiGit/repos/oneRepo/creation/rq.json", "apiGit/repos/oneRepo/creation/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("name", name);
        replaceUrlPlaceholder("description", description);
        request.header("Authorization", "Bearer " + R.CONFIG.get("git_token"));
    }
}
