/*
 * Copyright 2014 the original author or authors.
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

package org.gradle.api.internal.artifacts.ivyservice.ivyresolve.strategy;

import org.gradle.api.artifacts.ComponentMetadata;

public interface VersionSelector {
    /**
     * Indicates if the given version selector is dynamic.
     */
    boolean isDynamic();

    /**
     * Indicates if module metadata is required to determine if the
     * selector matches a candidate version.
     */
    boolean requiresMetadata();

    /**
     * Indicates if the selector implies that it matches only a single version.
     */
    boolean matchesUniqueVersion();

    /**
     * Indicates if the selector matches the given candidate version.
     * Only called if {@link #requiresMetadata()} returned {@code false}.
     *
     * @param candidate the candidate version
     */
    boolean accept(String candidate);

    /**
     * Indicates if the selector matches the given candidate version.
     * Only called if {@link #requiresMetadata()} returned {@code false}.
     *
     * @param candidate the candidate version
     */
    boolean accept(Version candidate);

    /**
     * Indicates if the selector matches the given candidate version
     * (whose metadata is provided). May also be called if {@link #isDynamic} returned
     * {@code false}, in which case it should return the same result as
     * {@code accept(candidate.getId().getVersion()}.
     *
     * @param candidate the metadata for the candidate version
     */
    boolean accept(ComponentMetadata candidate);
}
