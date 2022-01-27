package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetEmojisMethod extends AbstractApiMethodV2 {
    public GetEmojisMethod() {
        super(null,"apiGit/emoji/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
