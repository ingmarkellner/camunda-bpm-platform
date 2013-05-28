/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.cockpit.impl.auth.dummy;

import java.util.Set;

import org.camunda.bpm.cockpit.auth.AuthenticatedPrincipal;

/**
 * @author Daniel Meyer
 *
 */
public class DummyAuthenticatedPrincipal implements AuthenticatedPrincipal {

  private static final long serialVersionUID = 1L;
  
  private String name;
  private Set<String> roles;
  
  public DummyAuthenticatedPrincipal(String name, Set<String> roles) {
    this.name = name;
    this.roles = roles;
  }

  public String getName() {
    return name;
  }

  public Set<String> getRoles() {
    return roles;
  }

}
