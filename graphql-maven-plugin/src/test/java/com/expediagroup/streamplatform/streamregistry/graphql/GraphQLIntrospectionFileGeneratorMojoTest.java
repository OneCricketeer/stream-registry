/**
 * Copyright (C) 2018-2019 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.streamplatform.streamregistry.graphql;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GraphQLIntrospectionFileGeneratorMojoTest {
  @Mock
  private GraphQLIntrospectionFileGenerator generator;

  private GraphQLIntrospectionFileGeneratorMojo underTest;

  @Before
  public void before() {
    underTest = new GraphQLIntrospectionFileGeneratorMojo(generator);
  }

  @Test
  public void test() {
    underTest.setSourceSdlResource("sourceSdlResource");
    underTest.setTargetIntrospectionFile("targetIntrospectionFile");
    underTest.execute();

    verify(generator).generate("sourceSdlResource", "targetIntrospectionFile");
  }
}
