package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetRepoMethod extends AbstractApiMethodV2 {
    public GetRepoMethod(String org, String repo) {
        super(null,"apiGit/repos/oneRepo/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("org", org);
        replaceUrlPlaceholder("repo", repo);
    }
}
