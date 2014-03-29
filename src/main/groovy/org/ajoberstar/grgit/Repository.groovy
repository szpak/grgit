/*
 * Copyright 2012-2014 the original author or authors.
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
package org.ajoberstar.grgit

import groovy.transform.Canonical

import org.ajoberstar.grgit.auth.Credentials

import org.eclipse.jgit.api.Git

// TODO: When Gradle is built with Groovy 2.0+, switch to @Immutable

/**
 * Represents a Git repository.
 * @author Andrew Oberstar
 */
@Canonical
class Repository {
	/**
	 * The directory the repository is contained in.
	 */
	final File rootDir

	/**
	 * The JGit instance opened for this repository.
	 */
	final Git jgit

	/**
	 * The credentials used when talking to remote repositories.
	 */
	final Credentials credentials

	@Override
	String toString() {
		return "Repository(${rootDir.canonicalPath})"
	}
}
