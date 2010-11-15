/*
 * Copyright (C) 2010 Toni Menzel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.repository;

/**
 * TODO Maybe don't call this identifier as its not really a identification. Its more a .. Query ??
 */
public interface ArtifactQuery
{

    /**
     * String representation of the query. Usually specific, repository provided, parsers will be able to create more
     * domain specific subclasses from it. (see GavArtifactIdentidier for Maven specific identification)
     *
     * @return an identification that identifies a single resource in an attached repository. It is the user view and may return different resources at different times.
     *         For example this could have no "version" information, still the user might get a valid response when querying it.
     *         (Say, against a Maven Repo, this transforms to an open range version ("LATEST")
     *
     *         Never null.
     */
    String getQueryString();


}