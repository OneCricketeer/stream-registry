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
package com.expediagroup.streamplatform.streamregistry.graphql.client.builder;

import okhttp3.OkHttpClient;

import com.apollographql.apollo.ApolloClient;

import com.expediagroup.streamplatform.streamregistry.graphql.client.adapters.ObjectNodeTypeAdapter;
import com.expediagroup.streamplatform.streamregistry.graphql.client.type.CustomType;

public class StreamRegistryApolloClient {

  public static ApolloClient.Builder builder() {
    return ApolloClient.builder()
        .okHttpClient(new OkHttpClient.Builder().build())
        .addCustomTypeAdapter(CustomType.OBJECTNODE, new ObjectNodeTypeAdapter());
  }
}
