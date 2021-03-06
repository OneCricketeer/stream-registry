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
package com.expediagroup.streamplatform.streamregistry.graphql.query.impl;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import com.expediagroup.streamplatform.streamregistry.core.services.DomainService;
import com.expediagroup.streamplatform.streamregistry.graphql.filters.DomainFilter;
import com.expediagroup.streamplatform.streamregistry.graphql.model.inputs.DomainKeyInput;
import com.expediagroup.streamplatform.streamregistry.graphql.model.queries.DomainKeyQuery;
import com.expediagroup.streamplatform.streamregistry.graphql.model.queries.SpecificationQuery;
import com.expediagroup.streamplatform.streamregistry.graphql.query.DomainQuery;
import com.expediagroup.streamplatform.streamregistry.model.Domain;

@Component
@RequiredArgsConstructor
public class DomainQueryImpl implements DomainQuery {
  private final DomainService domainService;

  @Override
  public Optional<Domain> byKey(DomainKeyInput key) {
    return domainService.read(key.asDomainKey());
  }

  @Override
  public Iterable<Domain> byQuery(DomainKeyQuery key, SpecificationQuery specification) {
    return domainService.findAll(new DomainFilter(key, specification));
  }
}
