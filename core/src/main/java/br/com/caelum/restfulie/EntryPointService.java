/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource - guilherme.silveira@caelum.com.br
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.caelum.restfulie;

import java.io.Writer;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.restfulie.config.Configuration;
import br.com.caelum.restfulie.config.SerializationConfig;
import br.com.caelum.restfulie.config.XStreamConfig;
import br.com.caelum.restfulie.http.ApacheHttpClientProvider;
import br.com.caelum.restfulie.http.HttpClientProvider;
import br.com.caelum.restfulie.http.Request;
import br.com.caelum.restfulie.marshall.ResourceSerializer;
import br.com.caelum.restfulie.serializer.BasicSerializer;
import br.com.caelum.restfulie.serializer.XStreamXmlSerializer;

/**
 * A service's entry point.
 * 
 * @author guilherme silveira
 */
@SuppressWarnings("unchecked")
public class EntryPointService implements ResourceSerializer {

	private final XStreamConfig config;
	private final Request request;

	public EntryPointService(URI uri) {
		this(uri, new HashMap<Class, Configuration>(), new ApacheHttpClientProvider());
	}

	public EntryPointService(URI uri, Map<Class, Configuration> configs, HttpClientProvider provider) {
		this(uri, new SerializationConfig(configs), provider);
	}

	public EntryPointService(URI uri, SerializationConfig config, HttpClientProvider provider) {
		this(uri, new XStreamConfig(config), provider);
	}

	public EntryPointService(URI uri, XStreamConfig config, HttpClientProvider provider) {
		this.config = config;
		this.request = provider.request(uri).with("Accept", "application/xml");
	}

}
