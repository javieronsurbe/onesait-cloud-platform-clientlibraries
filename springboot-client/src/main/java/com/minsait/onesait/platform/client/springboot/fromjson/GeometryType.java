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
/*******************************************************************************
 * Indra Sistemas, S.A.
 * 2013 - 2017  SPAIN
 * 
 * All rights reserved
 ******************************************************************************/
package com.minsait.onesait.platform.client.springboot.fromjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum GeometryType {

	@JsonProperty("Point")
	POINT("Point"),

	@JsonProperty("LineString")
	LINE_STRING("LineString"),

	@JsonProperty("MultiLineString")
	MULTILINE_STRING("MultiLineString"),

	@JsonProperty("Polygon")
	POLYGON("Polygon");

	private String name;

	private GeometryType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
