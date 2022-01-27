package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetReposAllMethod extends AbstractApiMethodV2 {
    public GetReposAllMethod(String org) {
        super(null,"apiGit/repos/allRepos/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("org", org);
    }
}
