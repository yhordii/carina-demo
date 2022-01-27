package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;


public class DeleteRepoMethod extends AbstractApiMethodV2 {
    public DeleteRepoMethod(String owner, String repo) {
        super(null, "apiGit/repos/oneRepo/delete/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
        request.header("Authorization", "Bearer " + R.CONFIG.get("git_token"));
    }
}
