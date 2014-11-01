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
package org.ajoberstar.grgit.operation

import org.ajoberstar.grgit.Remote
import org.ajoberstar.grgit.Repository
import org.eclipse.jgit.lib.Config
import org.eclipse.jgit.transport.RemoteConfig
import org.eclipse.jgit.transport.URIish

import java.util.concurrent.Callable

/**
 * Lists remotes in the repository. Returns a list of {@link org.ajoberstar.grgit.Remote}.
 *
 * <p>To list all remotes.</p>
 *
 * <pre>
 * def remotes = grgit.remote.list()
 * </pre>
 *
 * See <a href="http://git-scm.com/docs/git-remote">git-remote Manual Page</a>.
 *
 * @see <a href="http://git-scm.com/docs/git-remote">git-remote Manual Page</a>
 */
class RemoteListOp implements Callable<List> {

    private final Repository repository

    RemoteListOp(Repository repo) {
        this.repository = repo
    }

    @Override
    List call() {
        Config config = repository.jgit.repository.config

        def remotes = []
        config.getSubsections('remote').each {
            remotes += new Remote(name: it, uri: config.getString('remote', it, 'url'))
        }

        return remotes
    }
}
