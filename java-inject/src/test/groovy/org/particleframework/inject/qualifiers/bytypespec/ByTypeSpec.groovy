/*
 * Copyright 2017 original authors
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
package org.particleframework.inject.qualifiers.bytypespec

import org.particleframework.context.BeanContext
import org.particleframework.context.DefaultBeanContext
import spock.lang.Specification
/**
 * @author Graeme Rocher
 * @since 1.0
 */
class ByTypeSpec extends Specification {

    void "test by type qualifier injection"() {
        given:
        BeanContext context = new DefaultBeanContext().start()

        when:
        Bean b = context.getBean(Bean)

        then:
        b.foos.find { it instanceof One}
        b.foos.find { it instanceof Two}
        !b.foos.find { it instanceof Three}
    }


}
