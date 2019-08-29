/**
 * Copyright Indra Soluciones Tecnologías de la Información, S.L.U.
 * 2013-2019 SPAIN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.minsait.onesait.platform.web.security.client.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuthConfiguration {

	@Value("${openplatform.api.auth.token.clientId}")
	private String CLIENT_ID;

	@Value("${openplatform.api.auth.token.password}")
	private String CLIENT_SECRET;

	@Value("${openplatform.api.baseurl}")
	private String OAUTHSERVER_URL;

	@Value("${openplatform.api.auth.token.verify.path}")
	private String CHECK_TOKEN_ENDPOINT_URL;

	@Autowired
	CustomAccessTokenConverter tokenConverter;

	@Primary
	@Bean
	public RemoteTokenServices remoteTokenServices() {
		final RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setCheckTokenEndpointUrl(OAUTHSERVER_URL + CHECK_TOKEN_ENDPOINT_URL);
		tokenServices.setClientId(CLIENT_ID);
		tokenServices.setClientSecret(CLIENT_SECRET);
		tokenServices.setAccessTokenConverter(tokenConverter);
		return tokenServices;
	}

}
