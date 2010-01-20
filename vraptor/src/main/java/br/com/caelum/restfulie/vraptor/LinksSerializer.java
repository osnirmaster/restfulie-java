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

package br.com.caelum.restfulie.vraptor;

import java.io.Writer;

import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.serialization.Serializer;
import br.com.caelum.vraptor.serialization.XStreamXMLSerializer;

import com.thoughtworks.xstream.XStream;

public class LinksSerializer implements Serializer {
	
	private final XStreamXMLSerializer serializer;

	public LinksSerializer(XStream xstream, Writer writer, TypeNameExtractor extractor) {
		this.serializer = new XStreamXMLSerializer(xstream, writer, extractor);
	}

	public Serializer exclude(String... arg0) {
		return serializer.exclude(arg0);
	}

	public <T> Serializer from(T object) {
		return serializer.from(object);
	}

	public Serializer include(String... arg0) {
		return serializer.include(arg0);
	}

	public void serialize() {
		serializer.serialize();
	}

}
