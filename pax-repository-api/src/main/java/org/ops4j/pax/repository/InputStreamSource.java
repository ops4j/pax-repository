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

import java.io.IOException;
import java.io.InputStream;

/**
 * Indirection for reading from an input stream.
 * Perhaps add metadata because we really have a resource here, not just "search for some GAV" thing.
 */
public interface InputStreamSource
{

    /**
     * @return the concrete, ready to use, stream.
     *
     * @throws java.io.IOException in case of a problem initializing the stream.
     */
    InputStream get()
        throws IOException;
}
