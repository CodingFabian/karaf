/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.docker.command;

import org.apache.karaf.docker.command.completers.ImagesRepoTagsCompleter;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "docker", name = "tag", description = "Create a tag TARGET_IMAGE that refers to SOURCE_IMAGE")
@Service
public class TagCommand extends DockerCommandSupport {

    @Argument(index = 0, name = "image", description = "ID or name of the image to tag", required = true, multiValued = false)
    @Completion(ImagesRepoTagsCompleter.class)
    String image;

    @Argument(index = 1, name = "tag", description = "Tag", required = true, multiValued = false)
    String tag;

    @Argument(index = 2, name = "repo", description = "Repository where to tag", required = false, multiValued = false)
    String repo;

    @Override
    public Object execute() throws Exception {
        getDockerService().tag(image, repo, tag, url);
        return null;
    }

}
